package equipos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Daniel
 */
@XmlRootElement(name = "equipos_de_futbol")
public class EquiposDeFutbol {

	@SerializedName("equipos")
	private List<Equipo> equipo;

	public EquiposDeFutbol() {
		this.equipo = new ArrayList<>();
	}

	public EquiposDeFutbol(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Equipos Futbol{" + "Equipo = " + equipo + '}';
	}

}
