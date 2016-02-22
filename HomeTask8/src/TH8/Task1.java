package TH8;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * С помощью регулярных выражений осуществить сжатие английского текста, заменив каждую группу из 
 * двух или более рядом стоящих символов, на один символ, за которым следует количество его вхождений 
 * в группу. К примеру, строка hellowoooorld должна сжиматься в hel2owo4rld.
 */

public class Task1 {

	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		System.out.println("Put some text");

		String text = scanner.nextLine();

		Pattern pattern = Pattern.compile("(.)\\1{0,}");

		Matcher matcher = pattern.matcher(text);

		String rtext = "";

		while (matcher.find()) {
			rtext = rtext + matcher.group(1);

			int length = matcher.group().length();

			if (length > 1) {
				rtext = rtext + length;
			}
		}

		System.out.println("Resul: \"" + rtext + "\"");

		scanner.close();
	}

}
