package equipos;

import java.io.File;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author Daniel
 *
 */
public class MainTestStreamsEquipos {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub

		JAXBContext context = JAXBContext.newInstance(EquiposDeFutbol.class);

		Unmarshaller ums = context.createUnmarshaller(); // Pasar de XML a objetos Java

		// Mapear a objetos Java
		EquiposDeFutbol equipos = (EquiposDeFutbol) ums.unmarshal(new File("files/equipos-futbol.xml"));

		List<Equipo> lista = equipos.getEquipo();

		Comparator<Equipo> porNombre = (Equipo eq1, Equipo eq2) -> eq1.getNombre().compareTo(eq2.getNombre());

		Comparator<Jugador> porEdad = (Jugador j1, Jugador j2) -> j1.getFechaNacimiento().compareTo(j2.getFechaNacimiento());

		// Todos los equipos
		System.out.println("TODOS LOS EQUIPOS");
		System.out.println("-----------------");

		lista.stream().forEach(System.out::println);

		// Todos los equipos por orden alfabético
		System.out.println("\nTODOS LOS EQUIPOS ORDENADOS");
		System.out.println("---------------------------");

		lista.stream().sorted(porNombre).forEach(System.out::println);

		// Todos los equipos por orden ascendente
		System.out.println("\nTODOS LOS EQUIPOS ORDENADOS ASCENDENTE (Z - A)");
		System.out.println("----------------------------------------------");

		lista.stream().sorted(porNombre.reversed()).forEach(System.out::println);

		// Listar equipos de Madrid
		System.out.println("\nEQUIPOS DE MADRID ORDENADOS ALFABETICAMENTE");
		System.out.println("-------------------------------------------");

		lista.stream()
		.filter(e -> e.getCiudad().equals("Madrid"))
		.sorted(porNombre)
		.forEach(System.out::println);

		// Lista de entrenadores
		System.out.println("\nLISTA DE ENTRENADORES");
		System.out.println("---------------------");

		lista.stream()
		.map(eq -> eq.getEntrenador())
		.forEach(System.out::println);


		// Lista de entrenadores de equipos de Madrid
		System.out.println("\nLISTA DE ENTRENADORES DE EQUIPOS DE MADRID");
		System.out.println("------------------------------------------");

		lista.stream()
		.filter(eq -> eq.getCiudad().equals("Madrid"))
		.map(eq -> eq.getEntrenador())
		.forEach(System.out::println);

		// Jugadores posición de delantero
		System.out.println("\nLISTA DE JUGADORES EN LA POSICIÓN DE DELANTERO");
		System.out.println("----------------------------------------------");

		lista.stream()
		.flatMap(eq -> eq.getJugadores().stream())
		.filter(j -> j.getPosicion().equals("delantero"))
		.forEach(System.out::println);

		// Jugadores de equipos de Madrid y posición portero
		System.out.println("\nLISTA DE JUGADORES DE EQUIPOS DE MADRID Y EN LA POSICIÓN DE PORTERO");
		System.out.println("-------------------------------------------------------------------");

		lista.stream()
		.filter(eq -> eq.getCiudad().equals("Madrid"))
		.flatMap(eq -> eq.getJugadores().stream())
		.filter(j -> j.getPosicion().equals("portero"))
		.forEach(System.out::println);

		// Jugadores de nacionalidad española
		System.out.println("\nLISTA DE JUGADORES DE EQUIPOS DE NACIONALIDAD ESPAÑOLA");
		System.out.println("------------------------------------------------------");

		lista.stream()
		.flatMap(eq -> eq.getJugadores().stream())
		.filter(j -> j.getNacionalidad().equals("Española"))
		.forEach(System.out::println);

		// Jugadores mayores de 25 años
		System.out.println("\nLISTA DE JUGADORES MENORES DE 25 AÑOS");
		System.out.println("-------------------------------------");

		lista.stream()
		.flatMap(eq -> eq.getJugadores().stream())
		.filter(j -> j.getFechaNacimiento().plusYears(25).isAfter(LocalDate.now()))
		.forEach(System.out::println);

		// Jugadores ordenados por edad de mayor a menor
		System.out.println("\nJUGADORES ORDENADOS POR EDAD DE MAYOR A MENOR");
		System.out.println("---------------------------------------------");
		lista.stream()
		.flatMap(eq -> eq.getJugadores().stream())
		.sorted(porEdad)
		.forEach(System.out::println);

		// Jugadores ordenados por edad de mayor a menor
		System.out.println("\nJUGADORES ORDENADOS POR EDAD DE MENOR A MAYOR");
		System.out.println("---------------------------------------------");
		lista.stream()
		.flatMap(eq -> eq.getJugadores().stream())
		.sorted(porEdad.reversed())
		.forEach(System.out::println);

		// Jugador con mayor edad
		System.out.println("\nJUGADOR CON MAYOR EDAD DEL DOCUMENTO XML");
		System.out.println("----------------------------------------");

		System.out.println(lista.stream()
				.flatMap(eq -> eq.getJugadores().stream())
				.sorted(porEdad).findFirst());

		// Jugador con mayor edad
		System.out.println("\nJUGADOR CON MENOR EDAD DEL DOCUMENTO XML");
		System.out.println("----------------------------------------");

		System.out.println(lista.stream()
				.flatMap(eq -> eq.getJugadores().stream())
				.sorted(porEdad.reversed()).findFirst());

		// Número de equipos del documento XML
		System.out.println("\nNÚMERO DE EQUIPOS DEL DOCUMENTO XML");
		System.out.println("-----------------------------------");

		System.out.println("El número total de equipos es: " + lista.stream().count());

		// Cantidad total de jugadores del documento XML
		System.out.println("\nNÚMERO DE JUGADORES DEL DOCUMENTO XML");
		System.out.println("-------------------------------------");

		System.out.println(lista.stream()
				.flatMap(eq -> eq.getJugadores().stream())
				.count());

	}

}
