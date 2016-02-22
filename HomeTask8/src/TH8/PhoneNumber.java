package TH8;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneNumber {
	public static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		
		System.out.println("Put phone number");
		
		String phoneNum = scanner.nextLine();
		
		phoneNum = phoneNum.replaceAll("[^+\\d]","");
		
		Pattern pattern = Pattern.compile("^\\+375(29|17|33|25|44)\\d{7}$");
		
		if (pattern.matcher(phoneNum).find()) {
			System.out.println("Phone number \"" + phoneNum + "\" correct");
		}else{
			System.out.println("Phone number \"" + phoneNum + "\" incorrect");
		}
		
		scanner.close();
	}

}
