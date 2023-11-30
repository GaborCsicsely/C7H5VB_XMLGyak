package hu.domparse.c7h5vb;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriteC7h5vb {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML dokumentum beolvasása
            Document document = builder.parse(new File("XMLC7H5VB.xml"));
            document.getDocumentElement().normalize();

            // Mentés Új file-ba
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult fileResult = new StreamResult(new File("XMLC7H5VB1.xml"));
            transformer.transform(source, fileResult);
            
            // Konzolra írás
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
