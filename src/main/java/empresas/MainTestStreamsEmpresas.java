package empresas;

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

public class MainTestStreamsEmpresas {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		
		JAXBContext context = JAXBContext.newInstance(Empresas.class);

		Unmarshaller ums = context.createUnmarshaller(); // Pasar de XML a objetos Java

		// Mapear a objetos Java
		Empresas empresas = (Empresas) ums.unmarshal(new File("files/empresas.xml")); 

		List<Empresa> lista = empresas.getEmpresas();

		Comparator<Empresa> porNombre = (Empresa e1, Empresa e2) -> e1.getNombre().compareTo(e2.getNombre());

		Comparator<Empleado> porEdad = (Empleado e1, Empleado e2) -> e1.getFechaNacimiento().compareTo(e2.getFechaNacimiento());

		// Todos las empresas
		System.out.println("TODAS LAS EMPRESAS");
		System.out.println("----------------");

		lista.stream()
		.map(e -> e.getNombre().concat(" - CIF: " + e.getCif().concat(" - Direccion = " + e.getDireccion())))
		.forEach(System.out::println);

		// Todos las empresas por orden ascendente
		System.out.println("\nTODOS LAS EMPRESAS ORDENADOS ASCENDENTE (Z - A)");
		System.out.println("-----------------------------------------------");

		lista.stream()
		.sorted(porNombre.reversed())
		.map(e -> e.getNombre().concat(" - CIF: " + e.getCif().concat(" - Direccion = " + e.getDireccion())))
		.forEach(System.out::println);

		// Lista de empresas y CIF
		System.out.println("\nLISTA DE EMPRESAS Y CIF");
		System.out.println("-----------------------");

		lista.stream()
		.map(e -> "Empresa: " + e.getNombre().concat(" - CIF: " + e.getCif()))
		.forEach(System.out::println);

		// Lista de nombres y apellidos de los empleados que viven en Torrejón de Ardoz
		System.out.println("\nLISTA DE EMPLEADOS CON DOMICILIO EN TORREJON DE ARDOZ");
		System.out.println("------------------------------------------------------");

		lista.stream()
		.flatMap(e -> e.getEmpleados().stream())
		.filter(e -> e.getDireccion().getLocalidad().equals("Torrejon de Ardoz"))
		.map(e -> "Empleado: " + e.getNif().concat(" - " + e.getNombre().concat(" " + e.getApellidos().concat(" - Localidad: " + e.getDireccion().getLocalidad()))))
		.forEach(System.out::println);

		// Lista de los CEO de cada empresa
		System.out.println("\nLISTA DE LOS CEO DE CADA EMPRESA");
		System.out.println("--------------------------------");

		lista.stream()
		.flatMap(e -> e.getEmpleados().stream())
		.filter(e -> e.getPuesto().contains("CEO"))
		.map(e -> "Empleado: " + e.getNif().concat(" - " + e.getNombre().concat(" - " + e.getApellidos()).concat(" - Puesto: " + e.getPuesto())))
		.forEach(System.out::println);

		// Lista de empleados menores de 25 años
		System.out.println("\nLISTA DE EMPLEADOS MENORES DE 25 AÑOS");
		System.out.println("-------------------------------------");

		lista.stream()
		.flatMap(e -> e.getEmpleados().stream())
		.filter(e -> e.getFechaNacimiento().plusYears(25).isAfter(LocalDate.now()))
		.map(e -> "Empleado: " + e.getNombre().concat(" " + e.getApellidos().concat(" - Fecha de nacimiento: " + e.getFechaNacimiento())))
		.forEach(System.out::println);

		// Lista de empleados ordenados por edad de mayor a menor
		System.out.println("\nEMPLEADOS ORDENADOS POR EDAD DE MAYOR A MENOR");
		System.out.println("---------------------------------------------");
		lista.stream()
		.flatMap(e -> e.getEmpleados().stream())
		.sorted(porEdad)
		.map(e -> "Empleado: " + e.getNombre().concat(" " + e.getApellidos().concat(" - Fecha de nacimiento: " + e.getFechaNacimiento())))
		.forEach(System.out::println);

		// Lista de empleados ordenados por edad de mayor a menor
		System.out.println("\nEMPLEADOS ORDENADOS POR EDAD DE MENOR A MAYOR");
		System.out.println("---------------------------------------------");
		lista.stream()
		.flatMap(e -> e.getEmpleados().stream())
		.sorted(porEdad.reversed())
		.map(e -> "Empleado: " + e.getNombre().concat(" " + e.getApellidos().concat(" - Fecha de nacimiento: " + e.getFechaNacimiento())))
		.forEach(System.out::println);

		// Empleado de menor edad de Emma Tech Solutions S.L.
		System.out.println("\nEMPLEADO CON MENOR EDAD DE EMMA TECH SOLUTIONS");
		System.out.println("----------------------------------------------");

		System.out.println(lista.stream()
				.filter(e -> e.getNombre().equals("Emma Tech Solutions S.L."))
				.flatMap(e -> e.getEmpleados().stream())
				.sorted(porEdad.reversed()).findFirst());

		// Empleado de mayor edad de Emma Tech Solutions S.L.
		System.out.println("\nEMPLEADO CON MAYOR EDAD DE EMMA TECH SOLUTIONS");
		System.out.println("----------------------------------------------");

		System.out.println(lista.stream()
				.filter(e -> e.getNombre().equals("Emma Tech Solutions S.L."))
				.flatMap(e -> e.getEmpleados().stream())
				.sorted(porEdad).findFirst());

		// Empleado de menor edad
		System.out.println("\nEMPLEADO CON MENOR EDAD DEL DOCUMENTO XML");
		System.out.println("-----------------------------------------");

		System.out.println(lista.stream()
				.flatMap(e -> e.getEmpleados().stream())
				.sorted(porEdad.reversed()).findFirst());

		// Empleado de menor edad
		System.out.println("\nEMPLEADO CON MAYOR EDAD DEL DOCUMENTO XML");
		System.out.println("-----------------------------------------");

		System.out.println(lista.stream()
				.flatMap(e -> e.getEmpleados().stream())
				.sorted(porEdad).findFirst());
		
		// Número de empleados de Emma Tech Solutions S.L.
		System.out.println("\nNÚMERO DE EMPLEADOS DE EMMA TECH SOLUTION S.L.");
		System.out.println("----------------------------------------------");
		
		System.out.print("Número de empleados de Emma Tech Solutions: ");
		
		System.out.println(lista.stream()
				.filter(e -> e.getNombre().equals("Emma Tech Solutions S.L."))
				.flatMap(e -> e.getEmpleados().stream())
				.count());
		
		// Lista de empleados con cuenta de correo Gmail
		System.out.println("\nLISTA DE EMPLEADOS CON CUENTA DE CORREO GMAIL");
		System.out.println("---------------------------------------------");
		
		lista.stream()
		.flatMap(e -> e.getEmpleados().stream())
		.filter(e -> e.getEmail().contains("gmail"))
		.map(e -> "Empleado: " + e.getNombre().concat(" " + e.getApellidos().concat(" - Email: " + e.getEmail())))
		.forEach(System.out::println);

	}

}
