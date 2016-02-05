package HT1;

/*
 * ������� ������������� ��������� ��������� a � b (������� ������ �����), ����������,
 * ����� �� ��� ��������� ������� ������� ��������� �������� r (���� ����������� ����� ��������).
 */

public class Task3 {

	public static void main(String[] args) {
		int a = (int) (Math.random() * 100 + 1);
		int b = (int) (Math.random() * 100 + 1);
		int r = (int) (Math.random() * 100 + 1);

		System.out.println("������� ������������� ��������� ��������� " + a
				+ " � " + b + ", � ������� �������� �������� " + r + ".");

		// Radius should be greater or equal than half of diagonal
		if (Math.sqrt((a * a + b * b)) / 2 >= r) {
			System.out.println("�������� �� ������� �������.");
		} else {
			System.out.println("�������� ������� �������.");
		}
	}
}
