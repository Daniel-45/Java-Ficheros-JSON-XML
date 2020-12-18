package empresas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Daniel
 *
 */

@XmlType(propOrder = { "calle", "numero", "localidad", "provincia", "codigoPostal" })
public class Direccion {

	private String calle;
	private int numero;
	private String localidad;
	private String provincia;
	@SerializedName("codigo_postal")
	private String codigoPostal;

	public Direccion() {
		this("", 0, "", "", "");
	}

	public Direccion(String calle, int numero, String localidad, String provincia, String codigoPostal) {
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	@XmlElement(name = "codigo_postal")
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "[Calle = " + calle + ", Numero = " + numero + ", Localidad = " + localidad + ", Provincia = "
				+ provincia + ", Código Postal = " + codigoPostal + "]";
	}

}
