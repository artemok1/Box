package TH5;

import java.util.Arrays;
import java.util.Scanner;

/*
 *������ ����� � ������� ����������� ��������. ����� ����� ����������� � ��������� ������ 
 *���������� ����� ����������: ����������� ����� ��������� 20 50 100. ������� ������ ��� 
 *���������� ����� � ��������. ������� ������� ��������� ������. �� ���� ���������� ����� 
 *�����. �� ����� � ��������� �������� (�������� ������� ��� ���). ��� ������ ����� �������
 *������ ������������ ����� ����������� ����� ������ �������� �������� �����. ������� 
 *����������� � ����� ����������� � ����������� �����. ������ � ��  ���� ����������. 
 */

public class Task2 {

	public static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		// Create ATM
		ATM atm = createATM();

		System.out.println(atm.getBank() + " ATM at " + atm.getAddress()
				+ " initialized.");

		playWithATM(atm);

		scanner.close();
	}

	private static void playWithATM(ATM atm) {
		System.out.println("_______________________");
		System.out.println("Start work with ATM");
		System.out.println("1 - Put money in the ATM");
		System.out.println("2 - Withdraw money from the ATM");
		System.out.println("3 - Exit");

		int[] selOptions = new int[3];
		int selOption = 0;

		// options for main menu
		for (int i = 0; i < selOptions.length; i++) {
			selOptions[i] = i + 1;
		}

		// options for sub menu
		int[] selOptionsP = new int[4];

		for (int i = 0; i < selOptionsP.length; i++) {
			selOptionsP[i] = i + 1;
		}

		while (true) {
			selOption = getIntSel(selOptions);

			switch (selOption) {
			case 1:
				System.out.println("_______________________");
				System.out.println("Select option to put money in the ATM");
				System.out
						.println("1 - Put money the nominal value of 20 y.e. in the ATM");
				System.out
						.println("2 - Put money the nominal value of 50 y.e. in the ATM");
				System.out
						.println("3 - Put money the nominal value of 100 y.e. in the ATM");
				System.out.println("4 - Back to a main menu");

				while (true) {
					int selOptionP = getIntSel(selOptionsP);

					int sum = 0;

					switch (selOptionP) {
					case 1:
						System.out
								.println("Put the amount of money the nominal value of 20 y.e.");

						sum = getIntSel();

						atm.setNum20(sum);

						System.out.println("You successfully added " + sum * 20
								+ " �.�.");
						break;
					case 2:
						System.out
								.println("Put the amount of money the nominal value of 50 y.e.");

						sum = getIntSel();

						atm.setNum50(sum);

						System.out.println("You successfully added " + sum * 50
								+ " �.�.");

						break;
					case 3:
						System.out
								.println("Put the amount of money the nominal value of 100 y.e.");

						sum = getIntSel();

						atm.setNum100(sum);

						System.out.println("You successfully added " + sum
								* 100 + " �.�.");
						break;
					}

					if (selOptionP == 4) {
						System.out.println("_______________________");
						System.out.println("Main menu");
						System.out.println("1 - Put money in the ATM");
						System.out.println("2 - Withdraw money from the ATM");
						System.out.println("3 - Exit");

						break;
					}
				}

				break;
			case 2:
				System.out
						.println("Enter the amount of money you want to withdraw from ATM. It should be 20 fold or 50 fold.");
				
				boolean ok = false;
				
				while (ok == false) {
					ok = atm.getMoney(getIntSel());	
					
					
				}

				break;
			}

			if (selOption == 3) {
				break;
			}
		}

		System.out.println("You stopped work with ATM");
	}

	private static ATM createATM() {
		int selOption = 0;
		int[] num = new int[3];

		// Init. ATM
		System.out.println("Initialize ATM");
		System.out.println("1 - ������� ���������� ����� ��������� 20 �.�.");
		System.out.println("2 - ������� ���������� ����� ��������� 50 �.�.");
		System.out.println("3 - ������� ���������� ����� ��������� 100 �.�.");
		System.out.println("4 - ��������� �������������");

		int[] selOptions = new int[4];

		for (int i = 0; i < selOptions.length; i++) {
			selOptions[i] = i + 1;
		}

		while (true) {
			selOption = getIntSel(selOptions);

			num = addMoney(selOption, num);

			if (selOption == 4) {
				break;
			}
		}

		ATM atm = new ATM(num[0], num[1], num[2]);

		// add some options
		atm.setAddress("Kulman Street, 11");
		atm.setBank("BSB");

		return atm;
	}

	// add money to ATM
	private static int[] addMoney(int selOption, int[] num) {
		switch (selOption) {
		case 1:
			System.out.println("������� ���������� ����� ��������� 20 �.�.");

			num[0] = num[0] + getIntSel();

			System.out
					.println("���������� ����� ��������� 20 �.�. = " + num[0]);
			break;
		case 2:
			System.out.println("������� ���������� ����� ��������� 50 �.�.");

			num[1] = num[1] + getIntSel();

			System.out
					.println("���������� ����� ��������� 50 �.�. = " + num[1]);
			break;
		case 3:
			System.out.println("������� ���������� ����� ��������� 100 �.�.");

			num[2] = num[2] + getIntSel();

			System.out.println("���������� ����� ��������� 100 �.�. = "
					+ num[2]);
			break;
		case 4:
			break;
		}

		return num;
	}

	private static int getIntSel(int[] restr) {
		// value should be a number from list
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("�������� ����� �� ������!");
				continue;
			}

			Arrays.sort(restr);

			if (Arrays.binarySearch(restr, 0, restr.length, option) < 0) {
				System.out.println("�������� ����� �� ������!");
				option = 0;
				continue;
			}
		}

		return option;
	}

	private static int getIntSel() {
		// value should be a number greater then zero
		int num = 0;

		while (true) {
			try {
				num = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("������� �����");
				continue;
			}

			if (num < 0) {
				System.out.println("����� ������ ���� ������������� ");
				continue;
			}

			break;
		}

		return num;
	}

}
