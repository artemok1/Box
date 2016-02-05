package HT2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 *  Создайте массив с 10-ю переменными типа float. Далее найдите дубликаты и выведите их количество. 
 *  Пример: есть массив {2, 3, 5, 7, 6, 5, 7, 3, 7, 20} - в данном массиве цифра 3 и 7 повторяются. 
 *  В результате выполнения программы на экран должно вывести: 
 *  [3] - повторений 2 
 *  [7] - повторений 3
 */
public class Task2 {

	public static void main(String[] args) {
		float[] array = new float[10];

		// fill array with values
		for (int i = 0; i < 10; i++) {
			array[i] = (int) (Math.random() * 10);
		}

		// show generated array
		String result = String.valueOf(array[0]);

		for (int i = 1; i < array.length; i++) {
			result = result + ", " + array[i];
		}

		System.out.println("Generated array: [" + result + "]");

		Integer count;

		// generate hash map with key - array value and value - count of
		// duplicates
		HashMap<Float, Integer> hm = new HashMap<Float, Integer>();

		// count all duplicates
		for (int i = 0; i < array.length; i++) {
			count = hm.get(array[i]);

			hm.put(array[i], count == null ? 1 : count + 1);
		}

		// output result
		for (HashMap.Entry entry : hm.entrySet()) {
			if ((int) entry.getValue() > 1) {
				System.out.println("[" + entry.getKey() + "] - повторений "
						+ entry.getValue());
			}
		}
	}
}
