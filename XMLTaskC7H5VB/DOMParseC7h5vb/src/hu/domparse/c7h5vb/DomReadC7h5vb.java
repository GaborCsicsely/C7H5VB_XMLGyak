package hu.domparse.c7h5vb;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

public class DomReadC7h5vb {
    public static void main(String[] args) {
        try {
            //Beolvassa az XML fájlt
            File xmlFile = new File("XMLC7H5VB.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            DOMSource source = new DOMSource(doc);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Gyökér elem lekérése
            Element rootElement = doc.getDocumentElement();
            System.out.println("Gyökér elem: " + rootElement.getNodeName());

         // Konzolra írás
         	StreamResult consoleResult = new StreamResult(System.out);
       		transformer.transform(source, consoleResult);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
