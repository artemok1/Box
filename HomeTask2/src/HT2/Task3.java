package HT2;

/*
 * Напишите программу, которая печатает массив, затем инвертирует (то есть меняет местами первый элемент с последним,
 *  второй — с предпоследним и т.д.), и вновь печатает.
 */

public class Task3 {

	public static void main(String[] args) {
		int[] array = new int[11];

		// fill array with values
		for (int i = 0; i < 11; i++) {
			array[i] = (int) (Math.random() * 100);

		}

		// show array
		String result = String.valueOf(array[0]);

		for (int i = 1; i < array.length; i++) {
			result = result + ", " + array[i];
		}

		System.out.println("Generated array: [" + result + "]");

		int tmp = 0;

		//invert array 
		for (int i = 0; i < array.length / 2; i++) {
			tmp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = tmp;
		}
		
		//show result
		result = String.valueOf(array[0]);

		for (int i = 1; i < array.length; i++) {
			result = result + ", " + array[i];
		}	
		
		System.out.println("Inverted array: [" + result + "]");
	}
}
