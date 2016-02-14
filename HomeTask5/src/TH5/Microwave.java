package TH5;

public class Microwave extends Appliance{
	private char type;
	
	public static final char SOLO = 'S';
	public static final char GRIL = 'G';
	
	private boolean heat;
	
	public Microwave(String serialNumber, String name) {
		super(serialNumber, name);
 	}
 
	public void heatUp(){	
		if (super.energy == false) {
			System.out.println("Включите микроволновку в разетку!");
			
			return;
		}

		System.out.println("Микроволновка работает"); 	
		
		this.heat = true;
	}
	
	public void switchOn(){
		super.switchOn();
		
		this.heatUp();
	}
	
	public void switchOff(){
		super.switchOff();
		
		this.stopHeatUp();
	}	
	
	public void stopHeatUp() {
		if (this.heat == false) {
			System.out.println("Микроволновка не включена!");
			
			return;
		}	
		
		if (this.heat == false) {
			System.out.println("Микроволновка не включена!");
			
			return;
		}
		
		System.out.println("Микроволновка выключена");
		
		this.heat = false;
	}	
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}	
	
	
}
