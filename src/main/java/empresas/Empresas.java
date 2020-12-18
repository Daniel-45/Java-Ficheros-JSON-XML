package empresas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Daniel
 *
 */

@XmlRootElement
public class Empresas {

	private List<Empresa> empresas;

	public Empresas() {
		this.empresas = new ArrayList<Empresa>();
	}

	public Empresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	@XmlElement(name = "empresa")
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	@Override
	public String toString() {
		return "Empresas [Empresas = " + empresas + "]";
	}

}
