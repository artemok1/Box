package TH5;

public class Hoover extends Appliance {
	private char type;

	public static final char WASH = 'W';
	public static final char STANDARD = 'S';

	public Hoover(String serialNumber, String name) {
		super(serialNumber, name);
	}

	public void switchOn() {
		super.switchOn();

		if (super.energy == false) {
			System.out.println("¬ключите пылессос в разетку!");

			return;
		}

		System.out.println("ѕылессос работает");
	}

	public void switchOff() {
		if (super.energy == false) {
			System.out.println("ѕылессос не включен!");

			return;
		}
		
		System.out.println("ѕылессос выключен!");
		
		super.switchOff();
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

}
