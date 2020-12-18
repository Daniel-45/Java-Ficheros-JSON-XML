package bookstore;

import com.google.gson.annotations.SerializedName;

public class Title {

	// Atributos
	@SerializedName("_lang")
	private String lang;

	@SerializedName("__text")
	private String text;

	// Constructor
	public Title() {
		this.lang = "";
		this.text = "";
	}

	// Selectores y modificadores
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	// Mostrar datos
	@Override
	public String toString() {
		return "Title [lang =" + lang + ", text = " + text + "]";
	}

}
