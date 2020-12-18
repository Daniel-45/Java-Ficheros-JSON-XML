package empresas;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Daniel
 *
 */
@XmlType(propOrder = { "nif", "nombre", "apellidos", "fechaNacimiento", "email", "telefono", "puesto", "direccion" })
public class Empleado {

	private String nif;
	private String nombre;
	private String apellidos;
	@SerializedName("fecha_nacimiento")
	private LocalDate fechaNacimiento;
	private String email;
	private String telefono;
	private String puesto;
	private Direccion direccion;

	public Empleado() {
		this("", "", "", LocalDate.of(1990, 1, 1), "", "", "", new Direccion());
	}

	public Empleado(String nif, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			String telefono, String puesto, Direccion direccion) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.puesto = puesto;
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	@XmlElement(name = "fecha_nacimiento")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getPuesto() {
		return puesto;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Empleado [NIF = " + nif + ", Nombre = " + nombre + ", Apellidos = " + apellidos
				+ ", Fecha nacimiento = " + fechaNacimiento + ", Email = " + email + ", Teléfono = " + telefono
				+ ", Puesto = " + puesto + ", Direccion = " + direccion + "]";
	}

}
