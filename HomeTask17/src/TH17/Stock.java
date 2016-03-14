package TH17;

// stock class

public class Stock extends SecurityPaper implements IStock {
	private int id;
	
	private double bid;
	private double minPrice;
	private double maxPrice;
	
	private boolean visible;

	@Override
	public void setId(int id) {
		this.id = id; 
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public double getBid() {
		return this.bid;
	}

	@Override
	public void setBid(double bid) {
		this.bid = bid;
	}

	@Override
	public double getMinPrice() {
		return this.minPrice;
	}

	@Override
	public void setMinPrice(double price) {
		this.minPrice = price;
	}

	@Override
	public double getMaxPrice() {
		return this.maxPrice;
	}

	@Override
	public void setMaxPrice(double price) {
		this.maxPrice = price;
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
