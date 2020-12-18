package equipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * @author Daniel
 *
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	private static final DateTimeFormatter FORMATOFECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Override
	public LocalDate unmarshal(String f) throws Exception {
		// TODO Auto-generated method stub
		return LocalDate.parse(f, FORMATOFECHA);
	}

	@Override
	public String marshal(LocalDate f) throws Exception {
		// TODO Auto-generated method stub
		return f.format(FORMATOFECHA);
	}

}
