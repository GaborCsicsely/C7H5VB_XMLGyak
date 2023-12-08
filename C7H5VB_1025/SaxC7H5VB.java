package hu.saxc7h5vb;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxC7H5VB {
    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse("c7h5vb_kurzusfelvetel.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SaxHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("start {" + qName + "}; ");
        if (attributes.getLength() > 0) {
            System.out.print("{id:" + attributes.getValue(0) + "}; ");
        }
        System.out.println();
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        System.out.print(" " + new String(ch, start, length).trim() + "\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("end {" + qName + "};");
    }
}

