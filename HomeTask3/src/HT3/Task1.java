package HT3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/*
 *  Создайте массив с 10-ю переменными типа int. Значения необходимо вводить с клавиатуры в отдельном методе. 
 *  Затем выведите все значения на экран также в отдельном методе в виде: "значение" | "значение 2" | "значение 3" |  
 *  и тд. - Далее отсортируйте массив по возрастанию одним из способов из статьи (или всеми:) ). Результат вывести 
 *  на экран: "значение" | "значение 2" | "значение 3" |  и тд. Далее найдите в массиве все четные числа и выведите 
 *  их на экран: "значение" | "значение 2" | "значение 3" |  и тд. 
 *  
 *  В итоге у вас должна получиться программа как минимум с 3 методами:
 *  1 - для ввода данных с клавиатуры
 *  2 - для сортировки
 *  3 - для вывода 
 *  
 *  Вывод значений массива на экран должен быть сделан в отдельном методе, этот метод будет использоваться для вывода 
 *  значений массива до сортировки и после сортировки. Сортировку нужно сделать 3-мя различными способами (на ваш выбор).
 *   На следующем занятии необходимо уметь пояснить, как работает тот или иной тип сортировки, плюсы и минусы каждой из них.
 */

public class Task1 {
	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// create array
		int[] array = createArray();

		// print array
		System.out.println("Полученный массив:");
		printArray(array);

		// sort array
		array = sort(array);

		// print array
		System.out.println("Отстортированный массив:");
		printArray(array);

		// find even elements
		array = findEven(array);

		if (array.length > 0) {
			// print array
			System.out.println("Четные элементы:");
			printArray(array);
		} else {
			System.out.println("Четные элементы не обнаружены");
		}

		scanner.close();
	}

	// method to create array
	public static int[] createArray() {

		int numArrray = 0;

		System.out.println("Введите количество элементов массива");

		while (numArrray == 0) {
			if (scanner.hasNextInt()) {
				numArrray = scanner.nextInt();

				if (numArrray <= 0) {
					System.out.println("Введенное значение некорректно");
					numArrray = 0;
				}
			} else {
				System.out.println("Введенное значение некорректно");
				numArrray = 0;
			}
		}

		int[] array = new int[numArrray];

		System.out.println("Введите " + numArrray
				+ " чисел, чтобы создать массив");

		for (int i = 0; i < numArrray; i++) {
			if (scanner.hasNextInt()) {
				array[i] = scanner.nextInt();

			} else {
				System.out.println("Введенное значение некорректно");
				i--;
			}
		}

		return array;
	}

	// method to print array
	public static void printArray(int[] array) {
		// show array
		String result = "\"" + String.valueOf(array[0]) + "\"";

		for (int i = 1; i < array.length; i++) {
			result = result + " | " + "\"" + array[i] + "\"";
		}

		System.out.println(result);
	}

	// method to sort array
	public static int[] sort(int[] array) {
		int numArrray = 0;

		System.out.println("Введите способ сортировки(1,2 или 3):");
		System.out.println("cортировка выбором - 1");
		System.out.println("cортировка пузырьком - 2");
		System.out
				.println("cортировка массива при помощи метода Arrays.sort() - 3");

		while (numArrray == 0) {
			if (scanner.hasNextInt()) {
				numArrray = scanner.nextInt();

				if (numArrray != 1 && numArrray != 2 && numArrray != 3) {
					System.out.println("Введенное значение некорректно");
					numArrray = 0;
				}
			} else {
				System.out.println("Введенное значение некорректно");
				numArrray = 0;
			}
		}

		switch (numArrray) {
		case 1:
			for (int i = 0; i < array.length; i++) {

				int min = array[i];
				int min_i = i;

				for (int j = i + 1; j < array.length; j++) {

					if (array[j] < min) {
						min = array[j];
						min_i = j;
					}
				}

				if (i != min_i) {
					int tmp = array[i];
					array[i] = array[min_i];
					array[min_i] = tmp;
				}
			}
			break;
		case 2:
			for (int i = array.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {

					if (array[j] > array[j + 1]) {
						int tmp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = tmp;
					}
				}
			}
			break;
		case 3:
			Arrays.sort(array);
			break;
		}

		return array;
	}

	// method to find even elements
	public static int[] findEven(int[] array) {
		List<Integer> list = new ArrayList<Integer>();

		int k = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0 && array[i] % 2 == 0) {
				list.add(k, array[i]);

				k++;
			}
		}

		int[] resArray = new int[list.size()];

		for (int i = 0; i < resArray.length; i++) {
			resArray[i] = list.get(i);
		}

		return resArray;
	}
}
