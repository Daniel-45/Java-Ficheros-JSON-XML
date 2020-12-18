package bookstore;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.SerializedName;

public class Book {

	// Atributos
	private Title title;

	@SuppressWarnings("rawtypes")
	private ArrayList author;

	private LocalDate date;

	private float price;

	@SerializedName("_category")
	private String category;

	// Constructores
	public Book() {
		this.title = new Title();
		this.author = new ArrayList<String>();
		this.date = LocalDate.now();
		this.price = 0;
		this.category = "";
	}

	public Book(Title title, ArrayList<String> author, LocalDate date, float price, String category) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.price = price;
		this.category = category;
	}

	// Selectores y modificadores
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getAuthor() {
		return author;
	}

	public void setAuthor(ArrayList<String> author) {
		this.author = author;
	}

	@XmlJavaTypeAdapter(LocalDateAdapterXML.class)
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// Mostrar datos
	@Override
	public String toString() {
		return "Book [title = " + title + ", author = " + author + ", date = " + date 
				+ ", price=" + price + ", category = " + category + "]";
	}

}
