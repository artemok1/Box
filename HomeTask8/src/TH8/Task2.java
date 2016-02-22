package TH8;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/*
 * � ������� ���������� ��������� �������� ������� ������� ����� �������� ������ �����:
 * �������� ���� kjhkj.xml  - � ����� ��� ������� ������ xml. �. e. ����� �������� ���
 * ������� ����� ��������� �����. ����� �������� ������� �������� ����� �� ������. 
 * �������� ����� sfdsgs.txt � ����� ��������� ��� ������ xml ��� json, ���� ���-�� 
 * ������, �� ������� ������.
 */

public class Task2 {
	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		System.out.println("Put file name");

		String text = scanner.nextLine();	
		
		String[] rtext = text.split("\\.");
		
		if (rtext.length != 2 ) {
			System.out.println("File name incorrect");
			
			return;
		}
		
		text = rtext[rtext.length-1];
		
		System.out.println("File format: \"" + text + "\"");
		
		Pattern pattern = Pattern.compile("(xml|json)$");
		
		Matcher matcher = pattern.matcher(text);
		
		if (matcher.find()) {
			System.out.println("File format is allowed");
		}else{
			System.out.println("File format is not allowed");
		}
		 
		scanner.close();
	}

}
