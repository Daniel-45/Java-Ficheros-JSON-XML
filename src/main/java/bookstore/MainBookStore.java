package bookstore;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daw.com.Teclado;

/**
 * 
 * @author Daniel
 *
 */
public class MainBookStore {

	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub

		Reader reader = new FileReader(new File("files/bookstore.json"));

		// Poner adaptador de fechas
		GsonBuilder creadorGson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter());

		creadorGson.registerTypeAdapter(ArrayList.class, new ListaStringAdapter());

		Gson gson = creadorGson.create();

		Libreria libreria = gson.fromJson(reader, Libreria.class);

		System.out.println("Selecciona un rango de precios para realizar la consulta");

		float precioMin, precioMax;

		precioMin = Teclado.leerFloat("\nPrecio mínimo:");

		precioMax = Teclado.leerFloat("\nPrecio máximo:");

		System.out.println();

		libreria.getBookstore().getBook().removeIf(b -> b.getPrice() < precioMin || b.getPrice() > precioMax);

		List<Book> listaLibros = libreria.getBookstore().getBook();

		listaLibros = listaLibros.stream().filter(b -> b.getPrice() >= precioMin && b.getPrice() <= precioMax)
				.sorted((b1, b2) -> Float.compare(b1.getPrice(), b2.getPrice())).collect(Collectors.toList());

		libreria.getBookstore().setBook(listaLibros);

		JAXBContext context = JAXBContext.newInstance(BookStore.class);

		Marshaller ms = context.createMarshaller();

		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ms.marshal(libreria.getBookstore(), System.out);

		ms.marshal(libreria.getBookstore(), new FileWriter("files/bookstore.xml"));
	}

}
