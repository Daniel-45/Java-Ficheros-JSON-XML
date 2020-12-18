package bookstore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookStore {

	// Atributos
	private List<Book> book;

	// Constructores
	public BookStore() {
		this.book = new ArrayList<>();
	}

	public BookStore(List<Book> book) {
		this.book = book;
	}

	// Selectores y modificadores
	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	// Mostrar datos
	@Override
	public String toString() {
		return "Bookstore [book = " + book + "]";
	}

}
