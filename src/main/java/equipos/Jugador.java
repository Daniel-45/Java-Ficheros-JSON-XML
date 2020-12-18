package equipos;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Daniel
 */

@XmlType(propOrder = { "posicion", "nombre", "apellidos", "fechaNacimiento", "nacionalidad" })
public class Jugador {

	private String posicion;
	private String nombre;
	private String apellidos;
	@SerializedName("fecha_nacimiento")
	private LocalDate fechaNacimiento;
	private String nacionalidad;

	public Jugador() {
		this.posicion = "";
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = LocalDate.of(1990, 1, 1);
		this.nacionalidad = "";
	}

	public Jugador(String posicion, String nombre, String apellidos, LocalDate fechaNacimiento, String nacionalidad) {
		this.posicion = posicion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
	}

	@XmlAttribute
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@XmlElement(name = "fecha_nacimiento")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Jugador [Posición = " + posicion + ", Nombre = " + nombre + ", Apellidos = " + apellidos
				+ ", Fecha nacimiento = " + fechaNacimiento + ", Nacionalidad = " + nacionalidad + "]";
	}

}
