package paises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daw.com.Teclado;

public class MainPaises {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub

		JAXBContext context = JAXBContext.newInstance(Listado.class);

		Unmarshaller ums = context.createUnmarshaller();

		Listado lista = (Listado) ums.unmarshal(new File("files/paises.xml"));
		
		System.out.println("Lista de países\n");
		
		lista.getPaises()
				.stream()
				.forEach(p -> System.out.println("País: " + p.getNombre() + " - Continente: " + p.getContinente()));
		
		String continente = Teclado.leerString("\nIntroduce un continente:");
				
		// Muestra los países del continente introducido por teclado
		lista.getPaises().removeIf(p -> !p.getContinente().equalsIgnoreCase(continente));
		
		Gson creador = new GsonBuilder().setPrettyPrinting().create();

		String jsonString = creador.toJson(lista);

		PrintWriter jsonFichero = new PrintWriter(new File("files/paises.json"));

		creador.toJson(lista,jsonFichero);

		jsonFichero.close();

		System.out.println("\n" + jsonString);

	}

}
