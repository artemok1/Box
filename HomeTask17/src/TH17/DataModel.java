package TH17;

import java.util.ArrayList;
import java.util.List;

/*
 * Data structure of external document
 */

public class DataModel {

	private String name;
	private String location;
	private String date;

	private List<Stock> stock = new ArrayList<Stock>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Stock> getStock() {
		return this.stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	
	public void addStock(Stock stock){
		this.stock.add(stock);
	}
}
