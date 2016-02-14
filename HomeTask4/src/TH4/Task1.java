package TH4;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * ��� ���������� ������� ��������� � 1-� ����������� �������� (�������): 
 * ������� (�� ��� �� ������� �� �������). 
 * � ������� ��� ����� ������� ���������� ����������� ��� ������ ��������,  �������� � �������� ����� ���� ����������:
 * ���, �������, ������� � ��. ������������� � ���, ��� �� ������� �� ������� �� ������ �������� ��� 3 �������� �� ���� ����������. 
 * � ������ ������ ���� ����������� ���������� ����� int, String, boolean. � ������ ������ ���� ������� ������ set � get ��� ���������� �������.
 * 
 * ����� � �������� ������(�����) �� ������ ������� ������� 3 ������� ��������  � ��������� �� ������� �� ������� (���� ������ ������� � �������� ����).
 * ����� ����� ������ �� ������ ������� ������ �� ����� � ��������� ����:
 * ������� ���Δ - ������ = ��������
 * 
 * ����� �� ������ ���� ������������ ����������� ����� �������� �� ������� � �� ��������.
 * ������ � ������� ������ �������� ����������� ����� ������������ �� ��� ��� �� ��������, 
 * ����� ������������ ������ ������ ���, ����� ��������� ���������� ���� ��������� � ������ ������ (���� ����� ������� ��� ��������). 
 */

public class Task1 {
	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// fill pacients array
		Pacient[] array = addPacientsInfo();

		// output pacients array
		System.out.println("");
		System.out.println("������ ���������:");		
		showList(array);

		// filter
		array = filter(array);
       
		System.out.println("");
		System.out.println("��������� ����������:");
		// show filtered
		showList(array);

		scanner.close();

	}

	private static Pacient[] filter(Pacient[] array) {
		// Filter options
		System.out.println("___________________________");
		System.out.println("�������� ����� ��� ������:");
		System.out.println("1 - ����� �� �������");
		System.out.println("2 - ����� �� �����");
		System.out.println("3 - ����� �� ��������");
		System.out.println("4 - ����� �� ��������");
		System.out.println("99 - �������� ��� ��� ����");

		int option = 0;

		List<Pacient> list = new ArrayList<Pacient>();

		Pacient[] resArray;
		
		String val = "";

		while (option != 99) {
			// value should be a number from list
			while (option == 0) {
				try {
					option = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException nfe) {
					System.out.println("������� �����!");
					continue;
				}

				if (option != 1 && option != 2 && option != 3 && option != 4 && option != 99) {
					System.out.println("�������� ����� �� ������!");
					option = 0;
					continue;
				}
			}

			int k = 0;

			// execute selected option
			switch (option) {
			case 1:
				System.out.println("������� ������� ��� ����������");
				val = scanner.next();

				for (int i = 0; i < array.length; i++) {
					if (array[i].getSurname().equals(val)) {
						list.add(k, array[i]);

						k++;
					}
				}

				option = 99;
				break;
			case 2:
				System.out.println("������� ��� ��� ����������");
				val = scanner.next();

				for (int i = 0; i < array.length; i++) {
					if (array[i].getName().equals(val)) {
						list.add(k, array[i]);

						k++;
					}
				}

				option = 99;
				break;
			case 3:
				System.out.println("������� �������� ��� ����������");
				val = scanner.next();

				for (int i = 0; i < array.length; i++) {
					if (array[i].getMiddleName().equals(val)) {
						list.add(k, array[i]);

						k++;
					}
				}

				option = 99;
				break;
			case 4:
				System.out.println("������� ������� ��� ����������");
				val = scanner.next();
				
				boolean corret = false;
				
				int num = -1;
				
				// value should be a number greater or equal zero
				while (corret == false) {
					try {
						num = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException nfe) {
						System.out.println("������� �����!");
						continue;
					}

					corret = true;
				}				

				for (int i = 0; i < array.length; i++) {
					if (array[i].getAge() == num) {
						list.add(k, array[i]);

						k++;
					}
				}

				option = 99;
				break;
			}
		}

		if (list.size() > 0) {
			resArray = new Pacient[list.size()];

			for (int i = 0; i < resArray.length; i++) {
				resArray[i] = list.get(i);
			}
		} else {
			resArray = new Pacient[0];
		}

		return resArray;
	}

	private static void showList(Pacient[] array) {
		for (int i = 0; i < array.length; i++) {
			StringBuilder sb = new StringBuilder();

			sb.append("������� \"");

			if (array[i].getSurname() != null) {
				sb.append(array[i].getSurname());
			}

			if (array[i].getName() != null) {
				if (array[i].getSurname() != null) {
					sb.append(" ");
				}

				sb.append(array[i].getName());
			}

			if (array[i].getMiddleName() != null) {
				if (array[i].getName() != null || array[i].getSurname() != null) {
					sb.append(" ");
				}

				sb.append(array[i].getMiddleName());
			}

			if (array[i].getName() == null && array[i].getSurname() == null
					&& array[i].getMiddleName() == null) {
				sb.append(array[i].getKey());
			}

			sb.append("\" ������� = \"");
			sb.append(array[i].getAge());
			sb.append("\"");
			System.out.println(sb.toString());
		}
	}

	// method to create array of pacients
	public static Pacient[] addPacientsInfo() {

		int numArrray = 0;
		boolean corret = false;
		System.out.println("������� ��������� �������?");

		// value should be a number greater or equal zero
		while (corret == false) {
			try {
				numArrray = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("������� �����!");
				continue;
			}
			if (numArrray <= 0) {
				System.out.println("����� ������ ���� ������ ����!");
				continue;
			}

			corret = true;
		}

		Pacient[] array = new Pacient[numArrray];

		int option = 0;

		for (int i = 0; i < numArrray; i++) {
			System.out.println("��������� �������� � " + (i + 1));

			// create object patient with unique key
			array[i] = new Pacient(i + 1);

			// menu with options
			System.out.println("�������� �����:");
			System.out.println("1 - �������� �������");
			System.out.println("2 - �������� ���");
			System.out.println("3 - �������� ��������");
			System.out.println("4 - �������� �������");
			System.out.println("5 - �������� ��� (M - �������, W - �������)");
			System.out.println("6 - �������� �������");
			System.out.println("7 - ��������� �������������� ��������");
			System.out.println("99 - ���������� ��������� ���������");

			option = 0;

			while (option != 99 && option != 7) {
				// value should be a number from list
				while (option == 0) {
					int count = 0;
					
					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException nfe) {
						if (count == 1) {
							System.out.println("������� �����!");
							count = 0;
						}
						
						count = count + 1;
						
						continue;
					}

					if (option != 1 && option != 2 && option != 3
							&& option != 4 && option != 5 && option != 6
							&& option != 7 && option != 99) {
						System.out.println("�������� ����� �� ������!");
						option = 0;
						continue;
					}
				}

				// execute selected option
				switch (option) {
				case 1:
					System.out.println("������� �������");

					if (scanner.hasNext()) {
						array[i].setSurname(scanner.next());
						System.out
								.println("�������� ����� �� ������ ��� �����������");

					} else {
						System.out.println("��������� �������� �����������");
					}

					option = 0;
					break;
				case 2:
					System.out.println("������� ���");

					if (scanner.hasNext()) {
						array[i].setName(scanner.next());
						System.out
								.println("�������� ����� �� ������ ��� �����������");

					} else {
						System.out.println("��������� �������� �����������");
					}

					option = 0;
					break;
				case 3:
					System.out.println("������� ��������");

					if (scanner.hasNext()) {
						array[i].setMiddleName(scanner.next());
						System.out
								.println("�������� ����� �� ������ ��� �����������");

					} else {
						System.out.println("��������� �������� �����������");
					}

					option = 0;
					break;
				case 4:
					System.out.println("������� �������");

					corret = false;

					// value should be a number greater or equal zero
					while (corret == false) {
						int age = 0;

						try {
							age = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException nfe) {
							System.out.println("������� �����!");
							continue;
						}
						if (age <= 0) {
							System.out
									.println("����� ������ ���� ������ ����!");
							continue;
						}

						array[i].setAge(age);

						System.out
								.println("�������� ����� �� ������ ��� �����������");

						corret = true;
					}

					option = 0;
					break;
				case 5:
					System.out.println("������� ���");

					corret = false;

					// value should be a char type with value 'M' or 'W'
					while (corret == false) {
						char sex = 0;

						String val = scanner.nextLine();

						if (val.length() > 1) {
							System.out.println("������� ������ � ��� W");
							continue;
						}

						sex = val.charAt(0);

						if (sex != 'M' && sex != 'W') {
							System.out.println("������� ������ � ��� W");
							continue;
						}

						array[i].setSex(sex);

						System.out
								.println("�������� ����� �� ������ ��� �����������");

						corret = true;
					}

					option = 0;
					break;
				case 6:
					System.out.println("������� �������");

					if (scanner.hasNext()) {
						array[i].setDiagnosis(scanner.next());
						System.out
								.println("�������� ����� �� ������ ��� �����������");

					} else {
						System.out.println("��������� �������� �����������");
					}

					option = 0;
					break;
				}

			}

			// stop filling pacients array
			if (option == 99) {
				break;
			}
		}

		return array;
	}

}
