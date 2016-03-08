package TH13;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler {

	public ArrayList<Person> list = new ArrayList<Person>();

	private String thisElement = "";
	private Person person;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parser started...");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		thisElement = qName;

		if (thisElement.equals("element")) {
			person = new Person();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (person == null) {
			return;
		}
		
		if (thisElement.equals("age")) {
			person.setAge(new Integer(new String(ch, start, length)));
		}

		if (thisElement.equals("id")) {
			person.setId(new Integer(new String(ch, start, length)));
		}
 
		if (thisElement.equals("name")) {
			person.setName(new String(ch, start, length));
		}

		if (thisElement.equals("surname")) {
			person.setSurname(new String(ch, start, length));
		}
		
		if (thisElement.equals("isDegree")) {
			person.setDegree(new Boolean(new String(ch, start, length)));
		}		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("element")) {
			list.add(person);
		}

		thisElement = "";
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parser finished.");
	}

	public ArrayList<Person> getList() {
		return list;
	}

}
