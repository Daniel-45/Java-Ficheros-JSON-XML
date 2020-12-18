package equipos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainEquiposFutbol {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		JAXBContext context = JAXBContext.newInstance(EquiposDeFutbol.class);

		Unmarshaller ums = context.createUnmarshaller(); // Pasar de XML a objetos Java

		// Mapear a objetos Java
		EquiposDeFutbol equipos = (EquiposDeFutbol) ums.unmarshal(new File("files/equipos-futbol.xml"));

		System.out.print("Introduce una ciudad: ");

		String ciudad = sc.nextLine();

		Function<Equipo,Equipo> quitarNacionales = (equipo) -> {
			equipo.getJugadores().removeIf(jugador -> jugador.getNacionalidad().equals("Española"));
			return equipo;
		};

		List<Equipo> lista = equipos.getEquipo().stream()
				.filter(equipo -> equipo.getCiudad().equals(ciudad))  // Filtrar por ciudad
				.map(quitarNacionales) // Eliminar jugadores españoles
				.filter(equipo -> !equipo.getJugadores().isEmpty()) // Filtrar equipos sin jugadores extranjeros
				.collect(Collectors.toList()); // Crear lista con resultado

		equipos.setEquipo(lista);

		Gson creador = new GsonBuilder().setPrettyPrinting().create();

		// Invocar al método toJson del objeto Gson para la conversión
		String jsonString = creador.toJson(equipos);

		PrintWriter jsonFichero;

		jsonFichero = new PrintWriter(new File("files/equipos-futbol.json"));

		creador.toJson(equipos, jsonFichero);

		// IMPORTANTE!! Hay que cerrar el fichero
		jsonFichero.close();

		System.out.println(jsonString);

	}

}
