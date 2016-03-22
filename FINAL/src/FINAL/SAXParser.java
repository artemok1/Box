package FINAL;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler {

	private DataModel data = new DataModel();
	private String thisElement = "";
	private Stock stock;

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		this.thisElement = qName;

		if (this.thisElement.equals("stock")) {
			stock = new Stock();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (this.thisElement.equals("name") && stock == null) {
			this.data.setName(new String(ch, start, length));
		}

		if (this.thisElement.equals("location")) {
			this.data.setLocation(new String(ch, start, length));
		}

		if (this.thisElement.equals("date")) {
			this.data.setDate(new String(ch, start, length));
		}

		if (stock == null) {
			return;
		}

		if (this.thisElement.equals("id")) {
			stock.setId(new Integer(new String(ch, start, length)));
		}

		if (this.thisElement.equals("name")) {
			stock.setName(new String(ch, start, length));
		}

		if (this.thisElement.equals("bid")) {
			stock.setBid(new Double(new String(ch, start, length)));
		}

		if (this.thisElement.equals("minPrice")) {
			stock.setMinPrice(new Double(new String(ch, start, length)));
		}

		if (this.thisElement.equals("maxPrice")) {
			stock.setMaxPrice(new Double(new String(ch, start, length)));
		}

		if (this.thisElement.equals("visible")) {
			stock.setVisible(new Boolean(new String(ch, start, length)));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("stock")) {
			this.data.addStock(stock);
		}

		this.thisElement = "";
	}

	@Override
	public void endDocument() throws SAXException {
	}

	public DataModel getDataModel() {
		return this.data;
	}

}
