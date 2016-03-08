package TH13;

/*
 * Дополнительно(если у вас будет время) пробуем создавать xml файлы самостоятельно. 
 * Сделать это можно как с помощью парсера DOM так и с SAX
 */

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Task2 {

	public static void main(String[] args) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();

		DocumentBuilder docBuilder;

		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("class");
		doc.appendChild(rootElement);

		// Student 1
		// student elements
		Element student = doc.createElement("student");
		rootElement.appendChild(student);

		student.setAttribute("id", "1");
		// name
		Element firstname = doc.createElement("name");
		firstname.appendChild(doc.createTextNode("Alexej"));
		student.appendChild(firstname);

		// surname elements
		Element lastname = doc.createElement("surname");
		lastname.appendChild(doc.createTextNode("Zubkovsy"));
		student.appendChild(lastname);

		// age elements
		Element age = doc.createElement("age");
		age.appendChild(doc.createTextNode("25"));
		student.appendChild(age);
		
		// Student 2
		// student elements
		student = doc.createElement("student");
		rootElement.appendChild(student);

		student.setAttribute("id", "2");
		// name
		firstname = doc.createElement("name");
		firstname.appendChild(doc.createTextNode("Artsiom"));
		student.appendChild(firstname);

		// surname elements
		lastname = doc.createElement("surname");
		lastname.appendChild(doc.createTextNode("Akrachkou"));
		student.appendChild(lastname);

		// age elements
		age = doc.createElement("age");
		age.appendChild(doc.createTextNode("28"));
		student.appendChild(age);
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();

		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("D:\\students.xml"));


		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}

		System.out.println("File saved!");

	}

}
