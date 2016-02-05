package HT2;

import java.util.Arrays;

/*
 * Создайте массив типа int. Отсортируйте массив любым слособом (по убыванию либо по возрастанию). 
 * Результат вывести на экран
 */

public class TaskStar {

	public static void main(String[] args) {
		int[] array = new int[10];

		// fill array with values
		for (int i = 0; i < 10; i++) {
			array[i] = (int) (Math.random() * 100);
		}

		// show array
		String result = String.valueOf(array[0]);

		for (int i = 1; i < array.length; i++) {
			result = result + ", " + array[i];
		}

		System.out.println("Generated array: [" + result + "]");

		// sort in ascending order
		Arrays.sort(array);

		// show result
		result = String.valueOf(array[0]);

		for (int i = 1; i < array.length; i++) {
			result = result + ", " + array[i];
		}

		System.out.println("Sorted in asceding order: [" + result + "]");

		int tmp = 0;

		// invert array
		for (int i = 0; i < array.length / 2; i++) {
			tmp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = tmp;
		}

		// show result
		result = String.valueOf(array[0]);

		for (int i = 1; i < array.length; i++) {
			result = result + ", " + array[i];
		}

		System.out.println("Sorted in desceding order: [" + result + "]");

	}
}
