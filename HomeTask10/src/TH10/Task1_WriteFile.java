package TH10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Write file with students
 */

public class Task1_WriteFile {

	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// fill students array
		Student[] students = addStudents();

		saveList(students);

		showResult(students);

		scanner.close();
	}

	private static void saveList(Student[] students) {
		System.out.println("Now we will save list as a local file");

		System.out
				.println("Put file name (it will be saved in d://Downloads/ as .txt file)");

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]");

		String fileName = "";

		while (true) {
			fileName = scanner.nextLine();

			if (fileName.equals("")) {
				System.out.println("The input should not be empty");

				continue;
			}

			Matcher matcher = pattern.matcher(fileName);

			if (matcher.find()) {
				break;

			} else {
				System.out.println("File format is not allowed");

				continue;
			}
		}

		fileName = "d://Downloads/" + fileName + ".txt";
		
		StringBuilder sb = new StringBuilder();		

		for (int i = 0; i < students.length; i++) {
			sb.append(students[i].getId());
			sb.append("||");
			sb.append(students[i].getSurname());
			sb.append("||");
			sb.append(students[i].getName());
			sb.append("||");
			sb.append(students[i].getBirthday().getTime());
			sb.append("~"); 
		}

		// Write file
		write(fileName, sb.toString());

		System.out.println("File downloaded");

	}

	private static void write(String fileName, String data) {
		// Get file name
		File file = new File(fileName);

		try {
			// check if file already exist
			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				out.print(data);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static void showResult(Student[] students) {
		System.out.println("_____________________________");
		System.out.println("Result list:");

		long clcBDAy = 0;

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				continue;
			}
			
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

		// calculate average age
		clcBDAy = clcBDAy / students.length;

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
				System.out.println("¬ведите число");
				continue;
			}

			if (num < 0) {
				System.out.println("„исло должно быть положительным ");
				continue;
			}

			break;
		}

		return num;
	}
}
