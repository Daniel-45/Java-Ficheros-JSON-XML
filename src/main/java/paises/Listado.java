package paises;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "listadoPaises")
public class Listado {

	@SerializedName("listado")
	List<Pais> paises;

	public Listado() {
		this.paises = new ArrayList<Pais>();
	}

	public Listado(List<Pais> paises) {
		this.paises = paises;
	}

	@XmlElement(name = "pais")
	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	@Override
	public String toString() {
		return "Listado [paises=" + paises + "]";
	}

}
