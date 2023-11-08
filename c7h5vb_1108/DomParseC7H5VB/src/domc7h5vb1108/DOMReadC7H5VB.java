package domc7h5vb1108;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class DOMReadC7H5VB {
    public static void main(String[] args) {
        try {
            //Beolvassa az XML fájlt
            File xmlFile = new File("C7H5VB_orarend.xml");
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
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(indent + "Elem: " + node.getNodeName());

            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.println(indent + "  Attribútum: " + attribute.getNodeName() + " = " + attribute.getNodeValue());
                }
            }

            if (node.hasChildNodes()) {
                NodeList children = node.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    Node child = children.item(i);
                    printNode(child, indent + "  ");
                }
            }
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            String textContent = node.getNodeValue().trim();
            if (!textContent.isEmpty()) {
                System.out.println(indent + "Tartalom: " + textContent);
            }
        }
    }
}