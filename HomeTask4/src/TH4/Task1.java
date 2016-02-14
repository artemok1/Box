package TH4;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Вам необходимо создать программу с 1-м собственным объектом (классом): 
 * Пациент (то что мы сделали на занятии). 
 * В объекте вам нужно описать переменные характерные для данной сущности,  например у пациента могут быть переменные:
 * ФИО, возраст, диагноз и тд. Дополнительно к тем, что мы создали на занятии вы должны добавить еще 3 свойства на свое усмотрение. 
 * В классе должны быть обязательно переменные типов int, String, boolean. В классе долюны быть созданы методы set и get для переменных свойств.
 * 
 * Далее в основном классе(файле) вы должны создать минимум 3 объекта Пациента  и заполнить их данными из консоли (ввод данных сделать в красивом виде).
 * После ввода данных вы должны вывести данные на экран в вледующем виде:
 * Пациент “ФИО” - Возрас = “возраст”
 * 
 * Далее вы должны дать пользователю возможность найти пациента по фамилии и по возрасту.
 * Тоесть в консоли должно появится предложение найти пользователя по ФИО или по возрасту, 
 * далее пользователь вводит нужное имя, далее программа отображает всех пациентов с данным именем (тоже самое сделать для возраста). 
 */

public class Task1 {
	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// fill pacients array
		Pacient[] array = addPacientsInfo();

		// output pacients array
		System.out.println("");
		System.out.println("Список пациентов:");		
		showList(array);

		// filter
		array = filter(array);
       
		System.out.println("");
		System.out.println("Результат фильтрации:");
		// show filtered
		showList(array);

		scanner.close();

	}

	private static Pacient[] filter(Pacient[] array) {
		// Filter options
		System.out.println("___________________________");
		System.out.println("Выберите опцию для фльтра:");
		System.out.println("1 - фльтр по фамилии");
		System.out.println("2 - фльтр по имени");
		System.out.println("3 - фльтр по отчеству");
		System.out.println("4 - фльтр по возрасту");
		System.out.println("99 - отсавить все как есть");

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
					System.out.println("Введите число!");
					continue;
				}

				if (option != 1 && option != 2 && option != 3 && option != 4 && option != 99) {
					System.out.println("Выберите опцию из списка!");
					option = 0;
					continue;
				}
			}

			int k = 0;

			// execute selected option
			switch (option) {
			case 1:
				System.out.println("Введите фамилию для фильтрации");
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
				System.out.println("Введите имя для фильтрации");
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
				System.out.println("Введите отчество для фильтрации");
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
				System.out.println("Введите возраст для фильтрации");
				val = scanner.next();
				
				boolean corret = false;
				
				int num = -1;
				
				// value should be a number greater or equal zero
				while (corret == false) {
					try {
						num = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException nfe) {
						System.out.println("Введите число!");
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

			sb.append("Пациент \"");

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

			sb.append("\" Возраст = \"");
			sb.append(array[i].getAge());
			sb.append("\"");
			System.out.println(sb.toString());
		}
	}

	// method to create array of pacients
	public static Pacient[] addPacientsInfo() {

		int numArrray = 0;
		boolean corret = false;
		System.out.println("Сколько пациентов добавим?");

		// value should be a number greater or equal zero
		while (corret == false) {
			try {
				numArrray = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Введите число!");
				continue;
			}
			if (numArrray <= 0) {
				System.out.println("Число должно быть больше нуля!");
				continue;
			}

			corret = true;
		}

		Pacient[] array = new Pacient[numArrray];

		int option = 0;

		for (int i = 0; i < numArrray; i++) {
			System.out.println("Добовляем пациента № " + (i + 1));

			// create object patient with unique key
			array[i] = new Pacient(i + 1);

			// menu with options
			System.out.println("Выберите опцию:");
			System.out.println("1 - добавить фамилию");
			System.out.println("2 - добавить имя");
			System.out.println("3 - добавить отчество");
			System.out.println("4 - добавить возраст");
			System.out.println("5 - добавить пол (M - Мужчина, W - женщина)");
			System.out.println("6 - добавить диагноз");
			System.out.println("7 - закончить редактирование пациента");
			System.out.println("99 - прекоатить добавлять пациентов");

			option = 0;

			while (option != 99 && option != 7) {
				// value should be a number from list
				while (option == 0) {
					int count = 0;
					
					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException nfe) {
						if (count == 1) {
							System.out.println("Введите число!");
							count = 0;
						}
						
						count = count + 1;
						
						continue;
					}

					if (option != 1 && option != 2 && option != 3
							&& option != 4 && option != 5 && option != 6
							&& option != 7 && option != 99) {
						System.out.println("Выберите опцию из списка!");
						option = 0;
						continue;
					}
				}

				// execute selected option
				switch (option) {
				case 1:
					System.out.println("Введите фамилию");

					if (scanner.hasNext()) {
						array[i].setSurname(scanner.next());
						System.out
								.println("Выберите опцию из списка для продолжения");

					} else {
						System.out.println("Введенное значение некорректно");
					}

					option = 0;
					break;
				case 2:
					System.out.println("Введите имя");

					if (scanner.hasNext()) {
						array[i].setName(scanner.next());
						System.out
								.println("Выберите опцию из списка для продолжения");

					} else {
						System.out.println("Введенное значение некорректно");
					}

					option = 0;
					break;
				case 3:
					System.out.println("Введите отчество");

					if (scanner.hasNext()) {
						array[i].setMiddleName(scanner.next());
						System.out
								.println("Выберите опцию из списка для продолжения");

					} else {
						System.out.println("Введенное значение некорректно");
					}

					option = 0;
					break;
				case 4:
					System.out.println("Введите возраст");

					corret = false;

					// value should be a number greater or equal zero
					while (corret == false) {
						int age = 0;

						try {
							age = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException nfe) {
							System.out.println("Введите число!");
							continue;
						}
						if (age <= 0) {
							System.out
									.println("Число должно быть больше нуля!");
							continue;
						}

						array[i].setAge(age);

						System.out
								.println("Выберите опцию из списка для продолжения");

						corret = true;
					}

					option = 0;
					break;
				case 5:
					System.out.println("Введите пол");

					corret = false;

					// value should be a char type with value 'M' or 'W'
					while (corret == false) {
						char sex = 0;

						String val = scanner.nextLine();

						if (val.length() > 1) {
							System.out.println("Введите символ М или W");
							continue;
						}

						sex = val.charAt(0);

						if (sex != 'M' && sex != 'W') {
							System.out.println("Введите символ М или W");
							continue;
						}

						array[i].setSex(sex);

						System.out
								.println("Выберите опцию из списка для продолжения");

						corret = true;
					}

					option = 0;
					break;
				case 6:
					System.out.println("Введите диагноз");

					if (scanner.hasNext()) {
						array[i].setDiagnosis(scanner.next());
						System.out
								.println("Выберите опцию из списка для продолжения");

					} else {
						System.out.println("Введенное значение некорректно");
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
