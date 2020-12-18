package empresas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daw.com.Teclado;

public class MainEmpresas {

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		// TODO Auto-generated method stub

		JAXBContext context = JAXBContext.newInstance(Empresas.class);

		Unmarshaller ums = context.createUnmarshaller(); // Pasar de XML a objetos Java

		// Mapear a objetos Java
		Empresas empresas = (Empresas) ums.unmarshal(new File("files/empresas.xml"));

		String localidad = Teclado.leerString("Selecciona una localidad:");

		// Quita los empleados que no tengan residencia en la localidad indicada
		Function<Empresa, Empresa> quitarEmpleados = (empresa) -> {
			empresa.getEmpleados().removeIf(e -> !e.getDireccion().getLocalidad().equalsIgnoreCase(localidad));
			return empresa;
		};

		List<Empresa> lista = empresas.getEmpresas().stream().map(quitarEmpleados)
				.filter(empresa -> !empresa.getEmpleados().isEmpty()).collect(Collectors.toList());

		empresas.setEmpresas(lista);

		Gson creador = new GsonBuilder().setPrettyPrinting().create();

		String jsonString = creador.toJson(empresas);

		PrintWriter jsonFichero = new PrintWriter(new File("files/empresas.json"));

		creador.toJson(empresas, jsonFichero);

		// IMPORTANTE!! Hay que cerrar el fichero
		jsonFichero.close();

		System.out.println(jsonString);

	}

}
