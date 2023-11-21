package domc7h5vb1115;

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

            // XML dokumentum beolvas�sa
            Document document = builder.parse("c7h5vb_orarend.xml");

         // �raad� hozz�ad�sa
            NodeList orak = document.getElementsByTagName("ora");
            for (int i = 0; i < orak.getLength(); i++) {
                Node ora = orak.item(i);
                boolean hasOraado = false;

                NodeList children = ora.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    Node child = children.item(j);
                    if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals("oraado")) {
                        hasOraado = true;
                        break;
                    }
                }

                if (!hasOraado) {
                    Element oraado = document.createElement("oraado");
                    oraado.setTextContent("�j �raad�");
                    ora.appendChild(oraado);
                }
            }

            // �ra t�pus�nak m�dos�t�sa
            for (int i = 0; i < orak.getLength(); i++) {
                Element ora = (Element) orak.item(i);
                if (ora.getAttribute("t�pus").equals("gyakorlat")) {
                    ora.setAttribute("t�pus", "el�ad�s");
                }
            }

            // Cs�t�rt�ki �r�k napj�nak m�dos�t�sa p�ntekire
            for (int i = 0; i < orak.getLength(); i++) {
                Element ora = (Element) orak.item(i);
                NodeList idopontok = ora.getElementsByTagName("idopont");
                for (int j = 0; j < idopontok.getLength(); j++) {
                    Element idopont = (Element) idopontok.item(j);
                    NodeList napok = idopont.getElementsByTagName("nap");
                    if (napok.getLength() > 0) {
                        Element nap = (Element) napok.item(0);
                        if (nap.getTextContent().equals("Cs�t�rt�k")) {
                            nap.setTextContent("P�ntek");
                        }
                    }
                }
            }

            // F�jlba �r�s �s konzolra �r�s
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            // Konzolra �r�s
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);

            // F�jlba ment�s
            StreamResult file = new StreamResult("orarendModifyC7h5vb.xml");
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
