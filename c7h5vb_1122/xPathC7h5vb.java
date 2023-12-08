package domc7h5vb1108;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;

public class xPathC7h5vb {
    public static void main(String[] args) {
    	try {
            // Dokumentum és XPath inicializálása
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("c7h5vb_orarend.xml");
            XPath xpath = XPathFactory.newInstance().newXPath();

            // 1. Módosítás: id="1" tanóra időpontjának megváltoztatása
            Node tolNode1 = (Node) xpath.evaluate("/XY_orarend/ora[@id='1']/idopont/tol", doc, XPathConstants.NODE);
            if (tolNode1 != null) {
                tolNode1.setTextContent("9:00");
            }

            // 2. Módosítás: id="5" tanóra időpontjának megváltoztatása
            Node tolNode5 = (Node) xpath.evaluate("/XY_orarend/ora[@id='5']/idopont/tol", doc, XPathConstants.NODE);
            Node igNode5 = (Node) xpath.evaluate("/XY_orarend/ora[@id='5']/idopont/ig", doc, XPathConstants.NODE);
            if (tolNode5 != null && igNode5 != null) {
                tolNode5.setTextContent("11:00");
                igNode5.setTextContent("13:00");
            }

            // 3. Módosítás: Oktató nevének megváltoztatása
            Node oktatoNode = (Node) xpath.evaluate("/XY_orarend/ora[@id='3']/oktato", doc, XPathConstants.NODE);
            if (oktatoNode != null) {
                oktatoNode.setTextContent("Nagy Péter");
            }

            // Fájlba írás
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult consoleResult = new StreamResult(System.out);
            StreamResult fileResult = new StreamResult(new File("orarendC7h5vb1.xml"));
            transformer.transform(source, consoleResult);
            transformer.transform(source, fileResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
