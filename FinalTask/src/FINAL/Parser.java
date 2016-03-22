package FINAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.gson.Gson;

public class Parser extends Thread {

	private String type;
	private DataModel dataModel;
	private String message = "";

	public Parser(String type) {
		this.type = type;
	}

	@Override
	public void run() {
		this.prepareData(this.type);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public DataModel getDataModel() {
		return dataModel;
	}

	private void prepareData(String command) {
		File file = null;

		if (command.equals(MainWindow.JSON) || command.equals(MainWindow.GSON)) {
			file = this.getFile(MainController.JSONLINK);
		} else if (command.equals(MainWindow.XML)) {
			file = this.getFile(MainController.XMLLINK);
		}

		if (file == null) {
			return;
		}

		// check file format
		String[] rtext = file.getName().split("\\.");

		if (rtext.length != 2) {
			this.message = "File format is not allowed";

			return;
		}

		String text = rtext[rtext.length - 1];

		Pattern pattern = Pattern.compile("(xml|json)$");

		Matcher matcher = pattern.matcher(text);

		if (matcher.find() == false) {
			this.message = "File format is not allowed";

			return;
		}

		if (command.equals(MainWindow.XML)) {
			this.dataModel = this.parseXML(file);
		}
		if (command.equals(MainWindow.GSON)) {
			this.dataModel = this.parseGSON(file);
		}

		if (command.equals(MainWindow.JSON)) {
			this.dataModel = this.parseJSONSimple(file);
		}

		if (this.dataModel == null) {
			return;
		}

	}

	// Get file from web
	private File getFile(String link) {

		InputStream inputStream = null;

		FileOutputStream outputStream = null;

		File file;

		try {
			URL url = new URL(link);

			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();

			int responseCode = httpURLConnection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				inputStream = httpURLConnection.getInputStream();

				String fileName = "";

				switch (link) {
				case MainController.JSONLINK:
					fileName = "data.json";
					break;
				case MainController.XMLLINK:
					fileName = "data.xml";
					break;
				}

				file = new File(fileName);

				outputStream = new FileOutputStream(file);

				int byteRead = -1;

				byte[] buffer = new byte[512];

				while ((byteRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, byteRead);
				}

				// everything is fine
				return file;
			} else {
				this.message = "Internet connection is not working, response code: "
						+ responseCode;
			}

		} catch (Exception e) {
			this.message = "Error: " + e.getMessage();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				this.message = "Error: " + e.getMessage();
			}

			try {
				outputStream.close();
			} catch (IOException e) {
				this.message = "Error: " + e.getMessage();
			}
		}

		return null;
	}

	// parse XML document
	private DataModel parseXML(File file) {
		XMLReader xr = null;

		try {
			xr = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			this.message = "Error: " + e.getMessage();

			return null;
		}

		SAXParser handler = new SAXParser();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);

		FileReader r;

		try {
			r = new FileReader(file);
		} catch (FileNotFoundException e) {
			this.message = "Error: " + e.getMessage();

			return null;
		}

		try {
			xr.parse(new InputSource(r));
		} catch (IOException e) {
			this.message = "Error: " + e.getMessage();

			return null;
		} catch (SAXException e) {
			this.message = "Error: " + e.getMessage();

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
			this.message = "Error: " + e.getMessage();
		}

		return null;
	}

	private DataModel parseJSONSimple(File file) {
		JSONParser parser = new JSONParser();

		DataModel dataModel = new DataModel();

		try {
			// init. parser
			JSONObject obj = (JSONObject) parser.parse(new FileReader(file));

			// set name
			dataModel.setName((String) obj.get("name"));
			dataModel.setLocation((String) obj.get("location"));
			dataModel.setDate((String) obj.get("date"));

			// get objects array from variable stock
			JSONArray jsonArray = (JSONArray) obj.get("stock");

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);

				Stock stock = new Stock();
				stock.setId((int) (long) jsonObject.get("id"));
				stock.setName((String) jsonObject.get("name"));
				stock.setMaxPrice(new Double(String.valueOf(jsonObject
						.get("maxPrice"))));
				stock.setMinPrice(new Double(String.valueOf(jsonObject
						.get("minPrice"))));
				stock.setBid(new Double(String.valueOf(jsonObject.get("bid"))));
				stock.setVisible((Boolean) jsonObject.get("visible"));

				dataModel.addStock(stock);
			}

			return dataModel;
		} catch (Exception e) {
			this.message = "Error: " + e.getMessage();
		}

		return null;
	}
}
