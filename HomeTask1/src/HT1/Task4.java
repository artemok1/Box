package HT1;

/*
 * ������� ����� ����� (�����), ��� ����� � ����� ����� � ������. 
 * ������� ��� �����, ������� � ���� ����� ������� � ���������� ������.
 */

public class Task4 {

	public static void main(String[] args) {
		// Generate number
		int number = (int) (Math.random() * 100000000);

		String numberTxt = String.valueOf(number);

		int len = numberTxt.length();

		// Get last number
		int lnum = Integer.valueOf(numberTxt.substring(len - 1, len));

		int snum = 0;

		// Get penultimate number, only in case number has more then 1 symbol
		if (len > 1) {
			snum = Integer.valueOf(numberTxt.substring(len - 2, len - 1));
		}

		// default
		String rub = "������";

		if (snum == 1) {
			// special case: penultimate number is 1 (e.g. 11, 17, 1119, 999914)
			rub = "������";
		} else {
			if (lnum == 0 || lnum == 5 || lnum == 6 || lnum == 7 || lnum == 8
					|| lnum == 9) {
				rub = "������";
			} else if (lnum == 2 || lnum == 3 || lnum == 4) {
				rub = "�����";
			} else if (lnum == 1) {
				rub = "�����";
			}
		}

		System.out.println("� ��� " + number + " " + rub);
	}
}
