package bookstore;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;


@SuppressWarnings("rawtypes")
public class ListaStringAdapter extends TypeAdapter<ArrayList>{

	@Override
	public void write(JsonWriter out, ArrayList value) throws IOException {
		// TODO Auto-generated method stub
		
		// Si hay más de un valor escribe como un ArrayList
		if (value.size() > 1) {			
			out.value(value.toString());
		}	
		else {			
			out.value((String)value.get(0)); // Si solo es un valor escribo el valor del primero como un String
		}
	}

	@Override
	public ArrayList read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> lista = new ArrayList<>();
		
		// Devuelve el tipo del siguiente elemento a leer
		if (in.peek() == JsonToken.BEGIN_ARRAY) {
			Gson gson = new Gson ();
			lista = gson.fromJson(in, lista.getClass()); // Leer como un ArrayList
		}
		else {			
			lista.add(in.nextString()); // Leer como un String
		}

		return lista;
	}
	
}
