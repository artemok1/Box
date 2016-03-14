package TH17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.gson.Gson;

public class Parser extends Thread {
	
	private Reader reader;

	private DataModel dataModel;
	private String message = "";
	
 	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		this.prepareData( );
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataModel getDataModel() {
		return dataModel;
	}

	private void prepareData() {
		synchronized (this) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println( "Error: " + e.getMessage());
			}
		}	
		
		System.out.println( "Parsing XML");
		File file = reader.getData();
		this.dataModel = this.parseXML(file);
		
		synchronized (reader) {
			reader.notify();
		}		
		
		synchronized (this) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println( "Error: " + e.getMessage());
			}
		}			
		
		System.out.println( "Parsing JSON");
		file = reader.getData();
   
		this.dataModel = this.parseGSON(file);
	}

	// parse XML document
	private DataModel parseXML(File file) {
		XMLReader xr = null;

		try {
			xr = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			System.out.println( "Error: " + e.getMessage());

			return null;
		}

		SAXParser handler = new SAXParser();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);

		FileReader r;

		try {
			r = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println( "Error: " + e.getMessage());

			return null;
		}

		try {
			xr.parse(new InputSource(r));
		} catch (IOException e) {
			System.out.println( "Error: " + e.getMessage());

			return null;
		} catch (SAXException e) {
			System.out.println( "Error: " + e.getMessage());

			return null;
		}

		return handler.getDataModel();
	}

	// parse GSON document
	private DataModel parseGSON(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			Gson gson = new Gson();

			return gson.fromJson(reader, DataModel.class);
		} catch (Exception e) {
			System.out.println( "Error: " + e.getMessage());
		}

		return null;
	}
}
