package TH17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reader extends Thread {
	private Parser parser;

	// links
	public static final String JSONLINK = "http://kiparo.ru/t/stock.json";
	public static final String XMLLINK = "http://kiparo.ru/t/stock.xml";

	File fileData;

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	@Override
	public void run() {
		System.out.println( "Reading XML");
		
		// read XML
		fileData = getFile(XMLLINK);

		synchronized (parser) {
			parser.notify();
		}

		synchronized (this) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println( "Reading JSON");

		// read JSON
		fileData = getFile(JSONLINK);
		
		synchronized (parser) {
			parser.notify();
		}		
	}

	public File getData() {
		return fileData;
	};

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
				case JSONLINK:
					fileName = "data.json";
					break;
				case XMLLINK:
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
				System.out
						.println("Internet connection is not working, response code: "
								+ responseCode);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

			try {
				outputStream.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		return null;
	}
}
