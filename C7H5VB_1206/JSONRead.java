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
			// JSON fájl beolvasása
			Object obj = parser.parse(new FileReader("orarendC7H5VB.json"));

			// JSONObject-ként kezelés
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject orarend = (JSONObject) jsonObject.get("XY_orarend");
			JSONArray orak = (JSONArray) orarend.get("ora");

			// Az órák adatainak kiírása
			for (Object oraObj : orak) {
				JSONObject ora = (JSONObject) oraObj;

				System.out.println("Óra ID: " + ora.get("id"));
				System.out.println("Tárgy: " + ora.get("targy"));
				System.out.println("Oktató: " + ora.get("oktato"));
				System.out.println("Helyszín: " + ora.get("helyszin"));
				System.out.println("Szak: " + ora.get("szak"));

				JSONObject idopont = (JSONObject) ora.get("idopont");
				System.out.println("Nap: " + idopont.get("nap"));
				System.out.println("Idõpont -tól: " + idopont.get("tol"));
				System.out.println("Idõpont -ig: " + idopont.get("ig"));
				System.out.println("----------------------------------");

				
			}
			
			// Új JSONArray létrehozása a strukturált adatok számára
			JSONArray structuredOrak = new JSONArray();

			// Az órák adatainak feldolgozása
			for (Object oraObj : orak) {
				JSONObject ora = (JSONObject) oraObj;
				JSONObject structuredOra = new JSONObject();
				structuredOra.put("Óra ID", ora.get("id"));
				structuredOra.put("Tárgy", ora.get("targy"));
				structuredOra.put("Oktató", ora.get("oktato"));
				structuredOra.put("Helyszín", ora.get("helyszin"));
				structuredOra.put("Szak", ora.get("szak"));

				JSONObject idopont = (JSONObject) ora.get("idopont");
				structuredOra.put("Nap", idopont.get("nap"));
				structuredOra.put("Idõpont -tól", idopont.get("tol"));
				structuredOra.put("Idõpont -ig", idopont.get("ig"));

				structuredOrak.add(structuredOra);
			}

			// Új JSON fájl írása
			try (FileWriter file = new FileWriter("orarendC7H5VB1.json")) {
				file.write(structuredOrak.toJSONString());
				file.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
