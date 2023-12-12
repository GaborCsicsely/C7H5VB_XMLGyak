package c7h5vb;

import org.json.JSONObject;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JSONWrite {

    public static void main(String[] args) {
        try {
            // Beolvas�s az orarendC7h5vb.json f�jlb�l
            String content = new String(Files.readAllBytes(Paths.get("orarendC7H5VB.json")));
            JSONObject jsonObject = new JSONObject(content);

            // Konzolra �s f�jlba �r�s
            System.out.println(jsonObject.toString(4));
            Files.write(Paths.get("orarendC7H5VB1.json"), jsonObject.toString(4).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

