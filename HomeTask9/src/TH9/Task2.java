package TH9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Попробуйте создать файл .txt с какими-нибудь записями, потом прочитать его в программе и вывести данные в консоль.
 * + попробуйте создать свой файл и записать туда информацию, введенную с консоли. 
 */

public class Task2 {

	public static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		System.out.println("Put some data");

		String data = scanner.nextLine();

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

		// Write file
		write(fileName, data);

		System.out.println("File downloaded");

		String dataUp = "";

		// Now read file
		try {
			dataUp = read(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File was not uploaded");
		}
		
		System.out.println("File was uploaded back to device");
		
		System.out.println("Data from the file:");
		System.out.println(dataUp);

		scanner.close();

	}

	public static void write(String fileName, String text) {
		// Get file name
		File file = new File(fileName);

		try {
			// check if file already exist
			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String read(String fileName) throws FileNotFoundException {
		// Этот спец. объект для построения строки
		StringBuilder sb = new StringBuilder();

		File file = exists(fileName);

		try {
			// Объект для чтения файла в буфер
			BufferedReader in = new BufferedReader(new FileReader(
					file.getAbsoluteFile()));
			try {
				// В цикле построчно считываем файл
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				// Также не забываем закрыть файл
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// Возвращаем полученный текст с файла
		return sb.toString();
	}

	private static File exists(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getName());
		}

		return file;
	}

}
