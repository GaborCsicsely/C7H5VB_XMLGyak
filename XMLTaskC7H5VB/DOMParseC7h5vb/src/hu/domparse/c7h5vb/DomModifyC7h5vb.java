package hu.domparse.c7h5vb;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class DomModifyC7h5vb {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML dokumentum beolvasása
            Document document = builder.parse("XMLC7H5VB.xml");

            // Dolgozóhoz telefonszám hozzáadása
            addPhoneNumber(document, 2, "06101234567");

            // Vezető nevének módosítása
            modifyLeaderName(document, "Nagy Ervin");

            // Gyártási ráták növelése
            increaseManufacturingRate(document, 100);

            // Eltávolítja az első megrendelőt
            removeFirstCustomer(document);

            // Gyártósoros dolgozók fizetésének emelése
            increaseSalary(document, 1500);


            // Fájlba írás és konzolra írás
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            // Konzolra írás
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);

            // Fájlba mentés
            StreamResult file = new StreamResult("XMLC7H5VBModify.xml");
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addPhoneNumber(Document doc, int dolgozoID, String newPhoneNumber) {
        NodeList dolgozok = doc.getElementsByTagName("Dolgozok");
        for (int i = 0; i < dolgozok.getLength(); i++) {
            Element dolgozo = (Element) dolgozok.item(i);
            if (Integer.parseInt(dolgozo.getAttribute("ID")) == dolgozoID) {
                Element phoneElem = doc.createElement("Telefonszam");
                phoneElem.setTextContent(newPhoneNumber);
                dolgozo.appendChild(phoneElem);
                break;
            }
        }
    }

    private static void modifyLeaderName(Document doc, String newName) {
        NodeList vezetok = doc.getElementsByTagName("Vezeto");
        if (vezetok.getLength() > 0) {
            Element vezeto = (Element) vezetok.item(0);
            vezeto.getElementsByTagName("Nev").item(0).setTextContent(newName);
        }
    }

    private static void increaseManufacturingRate(Document doc, int increaseBy) {
    NodeList gyarak = doc.getElementsByTagName("Gyarak");
        for (int i = 0; i < gyarak.getLength(); i++) {
            Element gyar = (Element) gyarak.item(i);
            String currentRate = gyar.getAttribute("GyartasiRata");
            int newRate = Integer.parseInt(currentRate) + increaseBy;
            gyar.setAttribute("GyartasiRata", Integer.toString(newRate));
        }
    }

private static void removeFirstCustomer(Document doc) {
    NodeList megrendelok = doc.getElementsByTagName("Megrendelok");
    if (megrendelok.getLength() > 0) {
        Node firstCustomer = megrendelok.item(0);
        firstCustomer.getParentNode().removeChild(firstCustomer);
    }
}

    private static void increaseSalary(Document doc, int amount) {
        NodeList dolgozok = doc.getElementsByTagName("Dolgozok");
        for (int i = 0; i < dolgozok.getLength(); i++) {
            Element dolgozo = (Element) dolgozok.item(i);
            if (dolgozo.getElementsByTagName("Beosztas").item(0).getTextContent().equals("Gyártósoros")) {
                int currentSalary = Integer.parseInt(dolgozo.getElementsByTagName("Fizetes").item(0).getTextContent());
                dolgozo.getElementsByTagName("Fizetes").item(0).setTextContent(String.valueOf(currentSalary + amount));
            }
        }
    }
}
