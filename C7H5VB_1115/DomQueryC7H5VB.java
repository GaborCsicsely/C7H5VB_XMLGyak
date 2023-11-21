package domc7h5vb1115;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DomQueryC7H5VB {
	public static void main(String[] args) {
        try {
        	File xmlFile = new File("c7h5vb_orarend.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList oraElements = doc.getElementsByTagName("ora");
            if (oraElements.getLength() > 0) {
                Node firstOraElement = oraElements.item(0);
                printNode(firstOraElement, "");
            }

            System.out.println("\nKurzusn�v: " + getKurzusNevek(doc));

            System.out.println("\nOrarend strukt�ra a konzolon:");
            printNode(doc.getDocumentElement(), "");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("orarend1c7h5vb.xml"));
            transformer.transform(source, result);

            System.out.println("\nAz orarend1c7h5vb.xml f�jl elk�sz�lt.");

            System.out.println("\nKurzusokat oktat�k nevei:");
            List<String> oktatoNevek = getOktatoNevek(doc);
            for (String oktato : oktatoNevek) {
                System.out.println(oktato);
            }

            System.out.println("\n�sszetett lek�rdez�s eredm�nye:");
            List<String> osszetettLekerdezesEredmeny = osszetettLekerdezes(doc);
            for (String eredmeny : osszetettLekerdezesEredmeny) {
                System.out.println(eredmeny);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getKurzusNevek(Document doc) {
        List<String> kurzusNevek = new ArrayList<>();
        NodeList oraElements = doc.getElementsByTagName("ora");
        for (int i = 0; i < oraElements.getLength(); i++) {
            Element oraElement = (Element) oraElements.item(i);
            String targyNev = oraElement.getElementsByTagName("targy").item(0).getTextContent();
            kurzusNevek.add(targyNev);
        }
        return kurzusNevek;
    }

    private static void printNode(Node node, String indent) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(indent + "Elem: " + node.getNodeName());

            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.println(indent + "  Attrib�tum: " + attribute.getNodeName() + " = " + attribute.getNodeValue());
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
    private static List<String> getOktatoNevek(Document doc) {
        List<String> oktatoNevek = new ArrayList<>();
        NodeList oraElements = doc.getElementsByTagName("ora");
        for (int i = 0; i < oraElements.getLength(); i++) {
            Element oraElement = (Element) oraElements.item(i);
            String oktatoNev = oraElement.getElementsByTagName("oktato").item(0).getTextContent();
            if (!oktatoNevek.contains(oktatoNev)) {
                oktatoNevek.add(oktatoNev);
            }
        }
        return oktatoNevek;
    }
    
    private static List<String> osszetettLekerdezes(Document doc) {
    	//Itt a szerdai �r�k nev�t �s hely�t �rja ki
        List<String> eredmeny = new ArrayList<>();
        NodeList oraElements = doc.getElementsByTagName("ora");
        for (int i = 0; i < oraElements.getLength(); i++) {
            Element oraElement = (Element) oraElements.item(i);
            String nap = oraElement.getElementsByTagName("nap").item(0).getTextContent().toLowerCase();
            String helyszin = oraElement.getElementsByTagName("helyszin").item(0).getTextContent();
            if (nap.equals("szerda")) {
                eredmeny.add("Kurzus: " + oraElement.getElementsByTagName("targy").item(0).getTextContent() +
                        ", Helysz�n: " + helyszin);
            }
        }
        return eredmeny;
    }


}
