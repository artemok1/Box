package HT2;

/*
 * Создайте массив с 10-ю переменными типа int. Используя оператор "for" найдите и выведите на экран наименьшее и 
 * наибольшее значение в массиве. min value =  "значение которое у вас получилось". 
 * max value =  "значение которое у вас получилось". Далее замените наименьшее значение на 0, а наибольшее значение 
 * на 99 и выведите получившийся массив на экран в виде: [23, 0, 34, 99, 43534].
 */

public class Task1 {

	public static void main(String[] args) {

		int[] array = new int[10];

		//fill array with values
		for (int i = 0; i < 10; i++) {
			array[i] = (int) (Math.random() * 100);
			 
		}
		
		//show array
		String result = String.valueOf(array[0]);
		
		for (int i = 1; i < array.length; i++) {
 			result = result + ", " + array[i];	
	 		}
		
		System.out.println("Generated array: [" + result + "]"); 

		int min = array[0];
		int max = array[0];

		//find minimum and maximum values
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			
			if (array[i] > max) {
				max = array[i];
			}			
		}
		
		System.out.println("min value = \"" + min + "\"" );
		System.out.println("max value = \"" + max + "\"" );
		
		//replace minimum value with "0" and maximum value with "99"
		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) {
				array[i] = 0;
			}
			
			if (array[i] == max) {
				array[i] = 99;
			}			
		}
		
		//show result
		result = String.valueOf(array[0]);
		
		for (int i = 1; i < array.length; i++) {
 			result = result + ", " + array[i];	
	 		}
		
		System.out.println("Result array: [" + result + "]"); 
	}
}
