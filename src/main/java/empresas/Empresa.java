package empresas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Daniel
 *
 */
@XmlType(propOrder = { "nombre", "cif", "direccion", "empleados" })
public class Empresa {

	private String nombre;
	private String cif;
	private Direccion direccion;
	private List<Empleado> empleados;

	public Empresa() {
		this("", "", new Direccion(), new ArrayList<>());
	}

	public Empresa(String nombre, String cif, Direccion direccion, List<Empleado> empleados) {
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.empleados = empleados;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCif() {
		return cif;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	@XmlElementWrapper(name = "empleados")
	@XmlElement(name = "empleado")
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Empresa [Nombre = " + nombre + ", CIF = " + cif + ", Direccion = " + direccion 
				+ ", Empleados = " + empleados + "]";
	}

}
