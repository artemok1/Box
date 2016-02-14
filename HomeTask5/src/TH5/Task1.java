package TH5;

/*
 * Создать иерархию классов, описывающих бытовую технику. Создать несколько объектов описанных классов, 
 * часть из них включить в розетку. Иерархия должна иметь хотя бы три уровня. 
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

	public static Scanner scanner;

	public static void main(String[] args) {
		Appliance[] devices = fillKitche();

		System.out.println("Choose device:");
		generateKitchen(devices);

		scanner = new Scanner(System.in);

		generateOptions(devices);

		scanner.close();
	}

	private static void generateOptions(Appliance[] devices) {
		int[] menu = new int[devices.length];

		int selOption = 0;

		for (int i = 0; i < devices.length; i++) {
			menu[i] = i + 1;
		}

		int[] selOptions = new int[6];

		for (int i = 0; i < selOptions.length; i++) {
			selOptions[i] = i + 1;
		}

		while (true) {
			int option = getIntSel(menu) - 1;

			StringBuilder sb = new StringBuilder();

			sb.append("Device: \"");
			sb.append(devices[option].getCompany());
			sb.append(" ");
			sb.append(devices[option].getDeviceName());
			sb.append("\"  selected");
			System.out.println(sb.toString());

			System.out.println("Choose option:");

			System.out.println("1 - plug in");
			System.out.println("2 - plug out");
			System.out.println("3 - switch on");
			System.out.println("4 - switch off");
			System.out.println("5 - choose another device");
			System.out.println("6 - exit");

			while (true) {
				selOption = getIntSel(selOptions);

				executeDevice(selOption, devices[option]);

				if (selOption == 5 || selOption == 6) {
					break;
				}
			}

			if (selOption == 6) {
				break;
			}
			
			if (selOption == 5) {
				System.out.println("Choose device:");
			}

		}
		
		System.out.println("You left the kitchen");
	}

	public static Appliance[] fillKitche() {
		// Kitchen
		Appliance[] devices = new Appliance[3];

		// Microwave
		devices[0] = new Microwave("1212ER899", "ME83XR");

		devices[0].setCompany("Samsung");
		devices[0].setCountry("Korea");
		devices[0].setDescription("Клевая Микроволновка");

		// Hoover
		devices[1] = new Hoover("12X2ERL9U", "AQUA+ Pet & Family");

		devices[1].setCompany("Thomas");
		devices[1].setCountry("Germany");
		devices[1].setDescription("Добрый пылессос");

		// Washer
		devices[2] = new Washer("1rt12E44444", "F1096ND3");

		devices[2].setCompany("LG");
		devices[2].setCountry("Japan");
		devices[2].setDescription("Надежная стиралка");

		return devices;
	}

	public static void generateKitchen(Appliance[] devices) {
		// menu with devices
		for (int i = 0; i < devices.length; i++) {
			StringBuilder sb = new StringBuilder();

			sb.append(i + 1);
			sb.append(" - ");
			sb.append(devices[i].getCompany());
			sb.append(" ");
			sb.append(devices[i].getDeviceName());
			sb.append("  ");
			sb.append(devices[i].getCountry());
			sb.append("  \"");
			sb.append(devices[i].getDescription());
			sb.append("\"");
			System.out.println(sb.toString());
		}
	}

	private static int getIntSel(int[] restr) {
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

	public static void executeDevice(int option, Appliance device) {
		switch (option) {
		case 1:
			device.plugIn();
			break;
		case 2:
			device.plugOut();
			break;
		case 3:
			device.switchOn();
			break;
		case 4:
			device.switchOff();
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			System.out.println("Choosen option does not exist");

			return;
		}
	}

}
