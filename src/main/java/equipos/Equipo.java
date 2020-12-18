package equipos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Daniel
 */

@XmlType(propOrder = { "nombre", "ciudad", "entrenador", "jugadores" })
public class Equipo {

	private String nombre;
	private String ciudad;
	transient private String entrenador; // Se lee pero no se guarda
	private List<Jugador> jugadores;

	public Equipo() {
		this.nombre = "";
		this.ciudad = "";
		this.entrenador = "";
		this.jugadores = new ArrayList<>();
	}

	public Equipo(String nombre, String ciudad, String entrenador, List<Jugador> jugadores) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.entrenador = entrenador;
		this.jugadores = jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}

	@XmlElementWrapper(name = "jugadores")
	@XmlElement(name = "jugador")
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [Nombre = " + nombre + ", Ciudad = " + ciudad + ", Entrenador = " + entrenador 
				+ ", Jugadores = " + jugadores + "]";
	}

}
