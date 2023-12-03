package hu.domparse.c7h5vb;

import org.w3c.dom.*;
import javax.xml.parsers.*;
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

            // Gyökér elem lekérése
            Element rootElement = doc.getDocumentElement();
            System.out.println("Gyökér elem: " + rootElement.getNodeName());

            // Fa teljes tartalmának kiírása
            printNode(rootElement, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node, String indent) {
        // Ellenőrizzük, hogy az aktuális csomópont elem típusú-e
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            // Az elem nevének és értékének kiíratása
            System.out.println(indent + "Elem: " + node.getNodeName());

            // Az elem attribútumainak kiíratása
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.println(indent + "  Attribútum: " + attribute.getNodeName() + " = " + attribute.getNodeValue());
                }
            }

            // Ha az elemnek vannak gyermekcsomópontjai bejárjuk őket
            if (node.hasChildNodes()) {
                NodeList children = node.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    Node child = children.item(i);
                    printNode(child, indent + "  ");
                }
            }
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            // Szöveges tartalom kiírása
            String textContent = node.getNodeValue().trim();
            if (!textContent.isEmpty()) {
                System.out.println(indent + "Tartalom: " + textContent);
            }
        }
    }
}
