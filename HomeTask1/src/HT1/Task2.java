package HT1;

/*
 * �������� ����� �����. ����������, �������� �� ��������� ����� ����� ��������.
 */

public class Task2 {

	public static void main(String[] args) {
		// Generate number
		int number = (int) (Math.random() * 100000000 + 1);

		System.out.println("�������� �����: " + number + ".");

		String numberTxt = String.valueOf(number);

		int len = numberTxt.length();
        
		// Get last number
		numberTxt = numberTxt.substring(len - 1, len);

		if (numberTxt.equals("7")) {
			System.out.println("��������� ����� ����� " + number
					+ " �������� ��������.");
		} else {
			System.out.println("��������� ����� ����� " + number
					+ " �� �������� ��������.");
		}
	}
}
