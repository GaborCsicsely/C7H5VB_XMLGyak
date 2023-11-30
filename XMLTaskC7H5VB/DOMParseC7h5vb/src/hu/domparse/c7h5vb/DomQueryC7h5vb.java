package hu.domparse.c7h5vb;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomQueryC7h5vb {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("XMLC7H5VB.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("\nGyárak:");
            List<String> gyarak = getGyarak(doc);
            for (String gyar : gyarak) {
                System.out.println(gyar);
            }

            System.out.println("\nGyárak címei:");
            List<String> cimek = getGyarCimek(doc);
            for (String cim : cimek) {
                System.out.println(cim);
            }

            System.out.println("\nÖsszetett lekérdezés eredménye:");
            List<String> osszetettLekerdezesEredmeny = osszetettLekerdezes(doc);
            for (String eredmeny : osszetettLekerdezesEredmeny) {
                System.out.println(eredmeny);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getGyarak(Document doc) {
        List<String> gyarak = new ArrayList<>();
        NodeList gyarakElements = doc.getElementsByTagName("Gyarak");
        for (int i = 0; i < gyarakElements.getLength(); i++) {
            Element gyarElement = (Element) gyarakElements.item(i);
            String gyarAzonosito = gyarElement.getAttribute("GyarAzonosito");
            gyarak.add("Gyár Azonosító: " + gyarAzonosito);
        }
        return gyarak;
    }

    private static List<String> getGyarCimek(Document doc) {
        List<String> cimek = new ArrayList<>();
        NodeList gyarakElements = doc.getElementsByTagName("Gyarak");
        for (int i = 0; i < gyarakElements.getLength(); i++) {
            Element gyarElement = (Element) gyarakElements.item(i);
            Element cimElement = (Element) gyarElement.getElementsByTagName("Cime").item(0);
            String utca = cimElement.getElementsByTagName("UtcaHazszam").item(0).getTextContent();
            String varos = cimElement.getElementsByTagName("Varos").item(0).getTextContent();
            cimek.add("Cím: " + utca + ", " + varos);
        }
        return cimek;
    }
    
    private static List<String> osszetettLekerdezes(Document doc) {
        List<String> eredmeny = new ArrayList<>();
        NodeList kiszallitasElements = doc.getElementsByTagName("Kiszallitas");
        NodeList gyarakElements = doc.getElementsByTagName("Gyarak");
        NodeList megrendelokElements = doc.getElementsByTagName("Megrendelok");

        for (int i = 0; i < kiszallitasElements.getLength(); i++) {
            Element kiszallitasElement = (Element) kiszallitasElements.item(i);
            int mennyiseg = Integer.parseInt(kiszallitasElement.getElementsByTagName("Mennyiseg").item(0).getTextContent());

            if (mennyiseg > 3000) {
                String gyarAzonosito = kiszallitasElement.getAttribute("GyarAzonosito");
                String megrendeloAzonosito = kiszallitasElement.getAttribute("MegrendeloAzonosito");

                String gyarCim = getCim(gyarakElements, gyarAzonosito);
                String megrendeloCim = getCim(megrendelokElements, megrendeloAzonosito);

                eredmeny.add("Mennyiség: " + mennyiseg + ", Gyár Címe: " + gyarCim + ", Megrendelő Címe: " + megrendeloCim);
            }
        }
        return eredmeny;
    }

    private static String getCim(NodeList elements, String azonosito) {
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            if (element.getAttribute("GyarAzonosito").equals(azonosito) || element.getAttribute("MegrendeloAzonosito").equals(azonosito)) {
                NodeList cimek = element.getElementsByTagName("Cime");
                if (cimek.getLength() > 0) {
                    Element cimElement = (Element) cimek.item(0);
                    String utca = cimElement.getElementsByTagName("UtcaHazszam").item(0).getTextContent();
                    String varos = cimElement.getElementsByTagName("Varos").item(0).getTextContent();
                    return utca + ", " + varos;
                }
            }
        }
        return "Cím nem található";
    }

}
