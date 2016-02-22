package TH8;

import java.util.Scanner;
import java.util.regex.Pattern;
//import java.util.regex.Matcher;

public class CarNumber {
	public static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		
		System.out.println("Put car number");
		
		String carNum = scanner.nextLine();
		
		Pattern pattern = Pattern.compile("^\\d{4} [A-Z]{2}-[0-7]{1}$");
		
		if (pattern.matcher(carNum).find()) {
			System.out.println("Car number \"" + carNum + "\" correct");
		}else{
			System.out.println("Car number \"" + carNum + "\" incorrect");
		}
		
		scanner.close();
	}

}
