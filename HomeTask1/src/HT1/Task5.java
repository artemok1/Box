package HT1;

/*
 * ������� ������, ������� �������� ������� ? � ������� #.  �������� ��� ������� ? �� HELLO, � # - �������. 
 * ��������� ������� �� �����.
 */

public class Task5 {

	public static void main(String[] args) {
		String text = "?: How to organize ? ####future ta####sks in a todo list (or calendar): ?";

		System.out.println("�������� ������: \"" + text + "\".");

		text = text.replace("#", "");
		text = text.replace("?", "HELLO");

		System.out.println("���������: \"" + text + "\".");
	}
}
