package TH5;

public class Device {

	protected String serialNumber;
	protected String country;
	protected String deviceName;
	protected String description;
	protected String model;
	
	protected boolean active;
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	protected String company;
	protected int warranty;

	public Device(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void switchOn() {
		active = true;
	}

	public void switchOff() {
		active = false;
	}

}
