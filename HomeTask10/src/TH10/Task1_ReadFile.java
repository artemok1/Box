package TH10;

/*
 * Read saved file
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1_ReadFile {
	
	public static Scanner scanner;

	public static void main(String[] args) {
		System.out
		.println("Put file name (it should be .txt file from d://Downloads/)");	
		
		scanner = new Scanner(System.in);
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9].txt$");

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
		
		String dataUp = "";
		
		fileName = "d://Downloads/" + fileName;

		// Now read file
		try {
			dataUp = read(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File" + fileName + "was not found");
		}
		
		System.out.println("File was uploaded. Result:");
		
		Student[] students = parse(dataUp);
		
		Task1_WriteFile.showResult(students);
		
		scanner.close();

	}
	
	private static Student[] parse(String dataUp) {
		String[] lines = dataUp.split("~"); 
		
		Student[] students = new Student[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split("\\|\\|"); 
			
			if (line[0].equals("\n")) {
				continue;
			}
			
			students[i] = new Student(Integer.valueOf(line[0]));
			
			students[i].setSurname(line[1]);
			students[i].setName(line[2]);
			
			Long birthDay = Long.valueOf(line[3]);
			
			Date date = new Date(birthDay);
			
			students[i].setBirthday(date);
		}
		
		
		return students;
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
