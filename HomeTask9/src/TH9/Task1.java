package TH9;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Создайте класс Студент с соответвующими полями (имя, фамилия, дата рождения). 
 * Поле дата рождения  должна быть типа Date. Создайте массив объектов класса Студент, 
 * заполнение данных должно быть из консоли, день рождения должен вводиться в виде строки 
 * (любой формат), затем конвертироваться в Date и записываться в объект Студент. 
 * Ваша задача найти средний возраст всех студентов. Результат вывести в следующем виде: 
 * 50 лет 3 месяца. 
 * Способ реализации любой. Если это будет очень легко предлагаю подумать как написать с
 * редний возраст в формате: 50 лет 3 месяца 5 дней 10 часов и 5 минут.
 */

public class Task1 {

	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// fill students array
		Student[] students = addStudents();

		showResult(students);

		scanner.close();
	}

	private static void showResult(Student[] students) {
		System.out.println("_____________________________");
		System.out.println("Result list:");
		
		long clcBDAy = 0;
		
		for (int i = 0; i < students.length; i++) {
			StringBuilder sb = new StringBuilder();
			
			sb.append("Student ");
			sb.append(students[i].getId());
			sb.append(" - ");
			sb.append(students[i].getSurname());
			sb.append(" ");
			sb.append(students[i].getName());
			sb.append(" Age: ");
			
			Age age = students[i].getAge();
			
			sb.append(age.getYears());
			sb.append(" year(s) ");
			sb.append(age.getMonths());
			sb.append(" monthe(s) ");	
			sb.append(age.getDays());
			sb.append(" day(s) ");				
			
			System.out.println(sb.toString());
			
			clcBDAy = clcBDAy + students[i].getBirthday().getTime();
		}
		
		//calculate average age
		clcBDAy = clcBDAy/students.length;
		
		Date clcDay = new Date(clcBDAy);
		
		Age age = new Age(clcDay);
		
		System.out.println("_____________________________");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Average age: ");
		sb.append(age.getYears());
		sb.append(" year(s) ");
		sb.append(age.getMonths());
		sb.append(" monthe(s) ");	
		sb.append(age.getDays());
		sb.append(" day(s) ");			
		
		System.out.println(sb.toString());		
	}

	private static Student[] addStudents() {
		System.out.println("How many students do you want to add?");

		int number = getIntSel();

		Student[] students = new Student[number];

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < students.length; i++) {
			// create student object
			students[i] = new Student(i + 1);

			System.out.println("Add surname of the student " + (i + 1));

			while (true) {
				String surname = scanner.nextLine();

				if (surname.equals("")) {
					System.out.println("The input should not be empty");

					continue;
				}

				students[i].setSurname(surname);

				break;
			}

			System.out.println("Add name of the student " + (i + 1));

			while (true) {
				String name = scanner.nextLine();

				if (name.equals("")) {
					System.out.println("The input should not be empty");

					continue;
				}

				students[i].setName(name);

				break;
			}

			System.out
					.println("Add birthday of the student in format \"yyyy-MM-dd \""
							+ (i + 1));

			while (true) {
				String birthday = scanner.nextLine();

				if (birthday.equals("")) {
					System.out.println("The input should not be empty");

					continue;
				}

				try {
					students[i].setBirthday(formatter.parse(birthday));
				} catch (ParseException e) {
					System.out
							.println("Date should be in format \"yyyy-MM-dd \"");

					continue;
				}

				break;
			}

		}

		return students;
	}

	private static int getIntSel() {
		// value should be a number greater then zero
		int num = 0;

		while (true) {
			try {
				num = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Введите число");
				continue;
			}

			if (num < 0) {
				System.out.println("Число должно быть положительным ");
				continue;
			}

			break;
		}

		return num;
	}
}
