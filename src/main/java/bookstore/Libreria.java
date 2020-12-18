package bookstore;

public class Libreria {

	// Atributos
	private BookStore bookstore;

	// Constructores
	public Libreria() {
		this.bookstore = new BookStore();
	}

	public Libreria(BookStore bookstore) {
		super();
		this.bookstore = bookstore;
	}

	// Selectores y modificadores
	public BookStore getBookstore() {
		return bookstore;
	}

	public void setBookstore(BookStore bookstore) {
		this.bookstore = bookstore;
	}

	// Mostrar datos
	@Override
	public String toString() {
		return "Librería [bookstore = " + bookstore + "]";
	}

}
