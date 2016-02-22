package TH6;

import java.util.Scanner;

/*  ������� ������ � �������. ���������� ���������� ���� � ������. ���������� ������, 
 *  ��� ����� ����� ����������� ����������� ���������, � ������ � ����� ������ ����� 
 *  ����� ���� �������, �� ����� � �������������.
 */

public class TaskStar {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		
		String text;

		System.out.println("������� ������ � �������");

		while (true) {
			text = scanner.nextLine();

			// remove leading and ending spaces
			text = text.trim();

			if (text.length() == 0) {
				System.out.println("������ �� ������ ���� ������");

				continue;
			}

			break;
		}
		
		//replace special chars in text
		text = text.replaceAll("(\\,+|\\.+|\\!+|\\?+|\\;+|\\:+)", " ");
		String[] result = text.split(" +");
		
		System.out.println("����� ������� ����: " + result.length);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		scanner.close();
	}
}
