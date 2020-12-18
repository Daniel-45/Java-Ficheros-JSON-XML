package paises;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Daniel
 *
 */

@XmlType(propOrder = { "nombre", "capital", "textoCapital", "ciudadImportante" })
public class Pais {

	transient private String continente;
	private String nombre;
	private String capital;
	private String textoCapital;
	private List<String> ciudadImportante;

	public Pais() {
		this.continente = "";
		this.nombre = "";
		this.capital = "";
		this.textoCapital = "";
		this.ciudadImportante = new ArrayList<String>();
	}

	public Pais(String continente, String nombre, String capital, String textoCapital, List<String> ciudadImportante) {
		this.continente = continente;
		this.nombre = nombre;
		this.capital = capital;
		this.textoCapital = textoCapital;
		this.ciudadImportante = ciudadImportante;
	}

	@XmlAttribute
	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getTextoCapital() {
		return textoCapital;
	}

	public void setTextoCapital(String textoCapital) {
		this.textoCapital = textoCapital;
	}

	@XmlElement(name = "ciudadImportante")
	public List<String> getCiudadImportante() {
		return ciudadImportante;
	}

	public void setCiudadImportante(List<String> ciudadImportante) {
		this.ciudadImportante = ciudadImportante;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", capital=" + capital + ", textoCapital=" + textoCapital
				+ ", ciudadImportante=" + ciudadImportante + "]";
	}

}
