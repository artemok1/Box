package HT1;

/*
 * �������� ���������� ���� String c ����� ������� (�� ������ ��������).
 * ����� �������� �� ����� ���������� �������� � ������ ������. ����� ��������� ������ ������� 
 * (���� ����� �������� �� ������� �� +-1 �� �������), � ���������� � ��� ������ ���� 2-� ����� 
 * ���������� ���� String � ������� �� ����������� ������. ���������� ������ �������� �� �����.
 */

public class Task1 {

	public static void main(String[] args) {
		String text = "How to organize future tasks in a todo list (or calendar)";

		System.out.println("�������� ������: \"" + text + "\".");

		int len = text.length();

		System.out.println("����� �������� � �������� ������: " + len + ".");
		System.out.println("������ ���������: \"" + text.substring(0, len / 2)
				+ "\".");
		System.out.println("������ ���������: \""
				+ text.substring(len / 2, len) + "\".");
	}
}
