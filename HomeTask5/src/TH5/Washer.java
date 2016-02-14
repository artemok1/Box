package TH5;

public class Washer extends Appliance {
	private int rotation;
	private int maxLoading;
	private boolean wash;

	public Washer(String serialNumber, String name) {
		super(serialNumber, name);
	}

	public void wash() {
		super.switchOn();
		
		if (super.energy == false) {
			System.out.println("�������� ���������� ������ � �������!");
			
			return;
		}

		System.out.println("����������� ������ ��������");
		this.wash = true;
	}

	public void stopWash() {
		if (this.wash = true) {
			System.out.println("������ ������������");

			this.wash = false;
		} else {
			System.out.println("���������� ������ �� �������");
		}
	 
	}
	
	public void switchOn(){
		super.switchOn();
		
		this.wash();
	}
	
	public void switchOff(){
		super.switchOff();
		
		this.stopWash();
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getMaxLoading() {
		return maxLoading;
	}

	public void setMaxLoading(int maxLoading) {
		this.maxLoading = maxLoading;
	}

}
