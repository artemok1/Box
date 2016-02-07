package HT3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/*
 *  �������� ������ � 10-� ����������� ���� int. �������� ���������� ������� � ���������� � ��������� ������. 
 *  ����� �������� ��� �������� �� ����� ����� � ��������� ������ � ����: "��������" | "�������� 2" | "�������� 3" |  
 *  � ��. - ����� ������������ ������ �� ����������� ����� �� �������� �� ������ (��� �����:) ). ��������� ������� 
 *  �� �����: "��������" | "�������� 2" | "�������� 3" |  � ��. ����� ������� � ������� ��� ������ ����� � �������� 
 *  �� �� �����: "��������" | "�������� 2" | "�������� 3" |  � ��. 
 *  
 *  � ����� � ��� ������ ���������� ��������� ��� ������� � 3 ��������:
 *  1 - ��� ����� ������ � ����������
 *  2 - ��� ����������
 *  3 - ��� ������ 
 *  
 *  ����� �������� ������� �� ����� ������ ���� ������ � ��������� ������, ���� ����� ����� �������������� ��� ������ 
 *  �������� ������� �� ���������� � ����� ����������. ���������� ����� ������� 3-�� ���������� ��������� (�� ��� �����).
 *   �� ��������� ������� ���������� ����� ��������, ��� �������� ��� ��� ���� ��� ����������, ����� � ������ ������ �� ���.
 */

public class Task1 {
	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// create array
		int[] array = createArray();

		// print array
		System.out.println("���������� ������:");
		printArray(array);

		// sort array
		array = sort(array);

		// print array
		System.out.println("���������������� ������:");
		printArray(array);

		// find even elements
		array = findEven(array);

		if (array.length > 0) {
			// print array
			System.out.println("������ ��������:");
			printArray(array);
		} else {
			System.out.println("������ �������� �� ����������");
		}

		scanner.close();
	}

	// method to create array
	public static int[] createArray() {

		int numArrray = 0;

		System.out.println("������� ���������� ��������� �������");

		while (numArrray == 0) {
			if (scanner.hasNextInt()) {
				numArrray = scanner.nextInt();

				if (numArrray <= 0) {
					System.out.println("��������� �������� �����������");
					numArrray = 0;
				}
			} else {
				System.out.println("��������� �������� �����������");
				numArrray = 0;
			}
		}

		int[] array = new int[numArrray];

		System.out.println("������� " + numArrray
				+ " �����, ����� ������� ������");

		for (int i = 0; i < numArrray; i++) {
			if (scanner.hasNextInt()) {
				array[i] = scanner.nextInt();

			} else {
				System.out.println("��������� �������� �����������");
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

		System.out.println("������� ������ ����������(1,2 ��� 3):");
		System.out.println("c��������� ������� - 1");
		System.out.println("c��������� ��������� - 2");
		System.out
				.println("c��������� ������� ��� ������ ������ Arrays.sort() - 3");

		while (numArrray == 0) {
			if (scanner.hasNextInt()) {
				numArrray = scanner.nextInt();

				if (numArrray != 1 && numArrray != 2 && numArrray != 3) {
					System.out.println("��������� �������� �����������");
					numArrray = 0;
				}
			} else {
				System.out.println("��������� �������� �����������");
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
