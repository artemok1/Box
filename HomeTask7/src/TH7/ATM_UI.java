package TH7;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_UI implements IATM_UI {
	private Scanner scanner;
	private ATM atm;

	public ATM_UI() {
		super();
		
		scanner = new Scanner(System.in);

		int selOption = 0;
		int[] num = new int[3];

		// Init. ATM
		System.out.println("Initialize ATM");
		System.out.println("1 - введите количество купюр номиналом 20 у.е.");
		System.out.println("2 - введите количество купюр номиналом 50 у.е.");
		System.out.println("3 - введите количество купюр номиналом 100 у.е.");
		System.out.println("4 - Закончить инициализацию");

		int[] selOptions = new int[4];

		for (int i = 0; i < selOptions.length; i++) {
			selOptions[i] = i + 1;
		}

		while (true) {
			selOption = this.getIntSel(selOptions);

			num = addMoney(selOption, num);

			if (selOption == 4) {
				break;
			}
		}

		this.atm = new ATM(num[0], num[1], num[2]);

		// add some options
		this.atm.setAddress("Kulman Street, 11");
		this.atm.setBank("BSB");

		this.atm.setListener(this);

		System.out.println(this.atm.getBank() + " ATM at "
				+ this.atm.getAddress() + " initialized.");
	}


	@Override
	public void work() {
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
					int selOptionP = this.getIntSel(selOptionsP);

					int sum = 0;

					switch (selOptionP) {
					case 1:
						System.out
								.println("Put the amount of money the nominal value of 20 y.e.");

						sum = this.getIntSel();

						this.atm.setNum20(sum);

						break;
					case 2:
						System.out
								.println("Put the amount of money the nominal value of 50 y.e.");

						sum = this.getIntSel();

						this.atm.setNum50(sum);

						break;
					case 3:
						System.out
								.println("Put the amount of money the nominal value of 100 y.e.");

						sum = this.getIntSel();

						this.atm.setNum100(sum);

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
	}

	@Override
	public void showSetNum20Message(int num20) {
		System.out.println("You successfully added " + num20 * 20 + " у.е.");
	}

	@Override
	public void showSetNum50Message(int num50) {
		System.out.println("You successfully added " + num50 * 50 + " у.е.");
	}

	@Override
	public void showSetNum100Message(int num100) {
		System.out.println("You successfully added " + num100 * 100 + " у.е.");
	}

 
	@Override
	public void close() {
		System.out.println("You stopped work with ATM");
		
		this.scanner.close();
	}
	
	@Override
	public void showGetMoneyMessage(String message) {
		 if (message != null) {
			 System.out.println(message);
		}
	}	

	private int getIntSel() {
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

	private int getIntSel(int[] restr) {
		// value should be a number from list
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Выберите опцию из списка!");
				continue;
			}

			Arrays.sort(restr);

			if (Arrays.binarySearch(restr, 0, restr.length, option) < 0) {
				System.out.println("Выберите опцию из списка!");
				option = 0;
				continue;
			}
		}

		return option;
	}

	// add money to ATM
	private int[] addMoney(int selOption, int[] num) {
		switch (selOption) {
		case 1:
			System.out.println("Введите количество купюр номиналом 20 у.е.");

			num[0] = num[0] + this.getIntSel();

			System.out
					.println("Количество купюр номиналом 20 у.е. = " + num[0]);
			break;
		case 2:
			System.out.println("Введите количество купюр номиналом 50 у.е.");

			num[1] = num[1] + this.getIntSel();

			System.out
					.println("Количество купюр номиналом 50 у.е. = " + num[1]);
			break;
		case 3:
			System.out.println("Введите количество купюр номиналом 100 у.е.");

			num[2] = num[2] + this.getIntSel();

			System.out.println("Количество купюр номиналом 100 у.е. = "
					+ num[2]);
			break;
		case 4:
			break;
		}

		return num;
	}

}
