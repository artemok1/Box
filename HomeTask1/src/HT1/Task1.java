package HT1;

/*
 * Создайте переменную типа String c любым текстом (не сильно короткое).
 * Далее выведите на экран количество символов в данной строке. Далее разделите строку пополам 
 * (если ровно поделить не выходит то +-1 не страшно), в результате у вас должно быть 2-е новых 
 * переменных типа String с частями из изначальной строки. Полученные строки выведите на экран.
 */

public class Task1 {

	public static void main(String[] args) {
		String text = "How to organize future tasks in a todo list (or calendar)";

		System.out.println("Исходная строка: \"" + text + "\".");

		int len = text.length();

		System.out.println("Число символов в исходной строке: " + len + ".");
		System.out.println("Первая половинка: \"" + text.substring(0, len / 2)
				+ "\".");
		System.out.println("Вторая половинка: \""
				+ text.substring(len / 2, len) + "\".");
	}
}
