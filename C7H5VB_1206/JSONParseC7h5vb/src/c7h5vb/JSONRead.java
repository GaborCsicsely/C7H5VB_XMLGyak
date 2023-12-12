package c7h5vb;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;

public class JSONRead {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {
			// JSON f�jl beolvas�sa
			Object obj = parser.parse(new FileReader("orarendC7H5VB.json"));

			// JSONObject-k�nt kezel�s
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject orarend = (JSONObject) jsonObject.get("XY_orarend");
			JSONArray orak = (JSONArray) orarend.get("ora");

			// Az �r�k adatainak ki�r�sa
			for (Object oraObj : orak) {
				JSONObject ora = (JSONObject) oraObj;

				System.out.println("�ra ID: " + ora.get("id"));
				System.out.println("T�rgy: " + ora.get("targy"));
				System.out.println("Oktat�: " + ora.get("oktato"));
				System.out.println("Helysz�n: " + ora.get("helyszin"));
				System.out.println("Szak: " + ora.get("szak"));

				JSONObject idopont = (JSONObject) ora.get("idopont");
				System.out.println("Nap: " + idopont.get("nap"));
				System.out.println("Id�pont -t�l: " + idopont.get("tol"));
				System.out.println("Id�pont -ig: " + idopont.get("ig"));
				System.out.println("----------------------------------");

				
			}
			
			// �j JSONArray l�trehoz�sa a struktur�lt adatok sz�m�ra
			JSONArray structuredOrak = new JSONArray();

			// Az �r�k adatainak feldolgoz�sa
			for (Object oraObj : orak) {
				JSONObject ora = (JSONObject) oraObj;
				JSONObject structuredOra = new JSONObject();
				structuredOra.put("�ra ID", ora.get("id"));
				structuredOra.put("T�rgy", ora.get("targy"));
				structuredOra.put("Oktat�", ora.get("oktato"));
				structuredOra.put("Helysz�n", ora.get("helyszin"));
				structuredOra.put("Szak", ora.get("szak"));

				JSONObject idopont = (JSONObject) ora.get("idopont");
				structuredOra.put("Nap", idopont.get("nap"));
				structuredOra.put("Id�pont -t�l", idopont.get("tol"));
				structuredOra.put("Id�pont -ig", idopont.get("ig"));

				structuredOrak.add(structuredOra);
			}

			// �j JSON f�jl �r�sa
			try (FileWriter file = new FileWriter("orarendC7H5VB1.json")) {
				file.write(structuredOrak.toJSONString());
				file.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
