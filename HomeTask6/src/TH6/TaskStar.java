package TH6;

import java.util.Scanner;

/*  »меетс€ строка с текстом. ѕодсчитать количество слов в тексте. ∆елательно учесть, 
 *  что слова могут раздел€тьс€ несколькими пробелами, в начале и конце текста также 
 *  могут быть пробелы, но могут и отсутствовать.
 */

public class TaskStar {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		
		String text;

		System.out.println("¬ведите строку с текстом");

		while (true) {
			text = scanner.nextLine();

			// remove leading and ending spaces
			text = text.trim();

			if (text.length() == 0) {
				System.out.println("—торка не должна быть пустой");

				continue;
			}

			break;
		}
		
		//replace special chars in text
		text = text.replaceAll("(\\,+|\\.+|\\!+|\\?+|\\;+|\\:+)", " ");
		String[] result = text.split(" +");
		
		System.out.println("¬сего найдено слов: " + result.length);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		scanner.close();
	}
}
