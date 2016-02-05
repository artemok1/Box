package HT1;

/*
 * Имеется строка, которая содержит символы ? и символы #.  Замените все символы ? на HELLO, а # - удалите. 
 * Результат вывести на экран.
 */

public class Task5 {

	public static void main(String[] args) {
		String text = "?: How to organize ? ####future ta####sks in a todo list (or calendar): ?";

		System.out.println("Исходная строка: \"" + text + "\".");

		text = text.replace("#", "");
		text = text.replace("?", "HELLO");

		System.out.println("Результат: \"" + text + "\".");
	}
}
