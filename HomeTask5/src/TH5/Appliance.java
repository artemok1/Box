package TH5;

public class Appliance extends Device {
	protected int voltage;
	protected int power;

	protected boolean energy;

	public Appliance(String serialNumber, String name) {
		super(serialNumber);

		this.deviceName = name;
	}

	public void plugIn() {
		energy = true;
		System.out.println("Прибор включен в разетку");
	}

	public void plugOut() {
		energy = false;
		System.out.println("Прибор выключен из разетки");
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
