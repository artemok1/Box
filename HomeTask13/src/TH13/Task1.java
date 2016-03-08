package TH13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 *  Делаем разбор того же xml файла, что и на занятии, но только с помощью парсера SAX. 
 *  На выходе должна появиться коллекция List с данными, как на занятии
 */

public class Task1 {

	public static void main(String[] args) {

		XMLReader xr = null;

		try {
			xr = XMLReaderFactory.createXMLReader();

		} catch (SAXException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}

		SAXParser handler = new SAXParser();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);

		FileReader r;

		try {
			r = new FileReader("test.xml");
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}
		
		try {
			xr.parse(new InputSource(r));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			
			return;
		} catch (SAXException e) {
			System.out.println("Error: " + e.getMessage());
			
			return;
		}
		
		System.out.println();
		System.out.println("Result");
		
		ArrayList<Person> list = handler.getList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
 
}
