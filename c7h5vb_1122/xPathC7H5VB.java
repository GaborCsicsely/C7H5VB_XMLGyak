package xpathc7h5vb;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.StringReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;

public class xPathC7H5VB {

	public static void main(String[] args) {
	      
		try {
			File xmlFile = new File("studentC7H5VB.xml");
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document doc = builder.parse(xmlFile);
		    XPath xPath = XPathFactory.newInstance().newXPath();
		    
		    System.out.println("1. Összes Student kiírása:");
		    String expression = "/class/student";
		    NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);
                System.out.println("");
                System.out.println((i+1) + ". Student:");
                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
                System.out.println("");
            }
		    
		    System.out.println("2. Kettes ID-vel rendelkezõ Student:");
		    expression = "/class/student[@id='2']";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);

                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
            }
		    
		    System.out.println("3. Összes Student függetlenül, hogy hol vannak:");
		    expression = "//student";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);
                System.out.println("");
                System.out.println((i+1) + ". Student:");
                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
                System.out.println("");
            }
		    
		    System.out.println("4. Második Student elem:");
		    expression = "/class/student[2]";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);

                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
            }
		    
		    System.out.println("5. Utolsó Student elem:");
		    expression = "/class/student[last()]";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);

                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
            }
		    
		    System.out.println("6. Utolsó elõtti Student elem:");
		    expression = "/class/student[last()-1]";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);

                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
            }
		    
		    System.out.println("7. Elsõ két Student elem:");
		    expression = "/class/student[position()<3]";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);
                System.out.println("");
                System.out.println((i+1) + ". Student:");
                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
                System.out.println("");
            }
		    
		    System.out.println("8. Class root összes gyermek eleme:");
		    expression = "/class/*";
            nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node childNode = nodeList.item(i);
                System.out.println("Elem neve: " + childNode.getNodeName());

                NodeList childElements = childNode.getChildNodes();
                for (int j = 0; j < childElements.getLength(); j++) {
                    org.w3c.dom.Node childElement = childElements.item(j);
                    if (childElement.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        System.out.println("    " + childElement.getNodeName() + ": " + childElement.getTextContent());
                    }
                }
            }

		    System.out.println("9. Összes student amely rendelkezik legalább egy valamilyen attribútummal:");
		    expression = "/class/student[@*]";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);
                System.out.println("");
                System.out.println((i+1) + ". Student:");
                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
                System.out.println("");
            }
		    
		    System.out.println("10. Dokumentum Összes eleme:");
		    expression = "/*";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node childNode = nodeList.item(i);
                System.out.println("Elem neve: " + childNode.getNodeName());

                NodeList childElements = childNode.getChildNodes();
                for (int j = 0; j < childElements.getLength(); j++) {
                    org.w3c.dom.Node childElement = childElements.item(j);
                    if (childElement.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        System.out.println("    " + childElement.getNodeName() + ": " + childElement.getTextContent());
                    }
                }
            }
		    
		    System.out.println("11. Összes Student akinek a kora több mint 20:");
		    expression = "/class/student[kor>20]";
		    nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

		    for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);
                System.out.println("");
                System.out.println((i+1) + ". Student:");
                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
                System.out.println("");
            }
		    
		    System.out.println("12. Összes student elem keresztnev vagy vezeteknev csomópontja:");
            expression = "/class/student[./keresztnev or ./vezeteknev]";
            nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node student = nodeList.item(i);
                System.out.println("");
                System.out.println((i+1) + ". Student:");
                // Keresztnév
                String firstName = xPath.compile("./keresztnev").evaluate(student);
                System.out.println("Keresztnév: " + firstName);

                // Vezetéknév
                String lastName = xPath.compile("./vezeteknev").evaluate(student);
                System.out.println("Vezetéknév: " + lastName);

                // Becenév
                String nickname = xPath.compile("./becenev").evaluate(student);
                System.out.println("Becenév: " + nickname);

                // Kor
                String age = xPath.compile("./kor").evaluate(student);
                System.out.println("Kor: " + age);
                System.out.println("");
            }


		} catch (Exception e) {
		    e.printStackTrace();
		}

	   }
	}