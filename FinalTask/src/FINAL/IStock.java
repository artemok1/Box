package FINAL;

// Stock interface

public interface IStock extends ISecurityPaper {
	public double getBid();

	public void setBid(double bid);

	public double getMinPrice();

	public void setMinPrice(double price);

	public double getMaxPrice();

	public void setMaxPrice(double price);

	public boolean isVisible();

	public void setVisible(boolean visible);
}
