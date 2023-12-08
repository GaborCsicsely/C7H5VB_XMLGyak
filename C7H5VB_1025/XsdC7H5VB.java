package hu.saxc7h5vb;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XsdC7H5VB {
    public static void main(String[] args) {
        try {
            File schemaFile = new File("c7h5vb_kurzusfelvetel.xsd");
            File xmlFile = new File("c7h5vb_kurzusfelvetel.xml");

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Validator validator = factory.newSchema(schemaFile).newValidator();
            validator.validate(new StreamSource(xmlFile));

            System.out.println("XSD Validation successful");
        } catch (Exception e) {
            System.out.println("Unsuccessful validation");
            e.printStackTrace();
        }
    }
}
