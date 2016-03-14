package TH16;

import java.util.Scanner;

/*
 * �������� ����������, � ������� ������������ 2 ������(����� ���� � ��� ��). 
 * ����� ������ ������ ��� ��������� Thread. ����� ������ ������ ������������ � ������ run 
 * ���������� �������������������� ����� � ���������� ���� ����� �� 1 �� 100 �������� �� 10 ����� � ������, 
 * ����������� ���������, ������ ����� ������ ����� ������� ������ ������ �������: 
 * "Thread 1:" ��� ������� ������, "Thread 2:" � ��� �������  - ����� ������������ �������� ������ (���� ��������������� �����). 
 * ��� ������ ������ ����� ������ � Main ������ ����� print10() - � ��� ��������� ���� �� ������ 10-�� �����. 
 * � ���������� ��� ����� � ���������� "start" ������ ������ ����������.
 * 
 * ����������������� ���������� ����������, ��������� ������������� �� ���� ���������� ������ print10() ������������������.
 */

public class Task1and2 {
	public static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out
				.println("1. Type 'start' to start application asynchronously");
		System.out
				.println("2. Type 'syncStart' to start application synchronously");

		boolean sync = false;

		while (true) {
			String val = scanner.next();

			if (val.equals("start")) {
				break;
			}

			if (val.equals("syncStart")) {
				sync = true;

				break;
			}
		}
		
		Task1and2 task = new Task1and2();
		
		Stream thread1;
		Stream thread2;

		if (sync) {
			thread1 = new Stream(task, sync);
			thread2 = new Stream(task, sync);	
		}else{
			thread1 = new Stream(task);
			thread2 = new Stream(task);		
		}
		
		thread1.setName("Thread 1: ");
		thread2.setName("Thread 2: ");

		thread1.start();
		thread2.start();
	}

	public void print10(Stream stream) {
		int count = 0;

		for (int i = 1; i <= 100; i++) {
			if (count == 0) {
				System.out.print(stream.getName());
			}

			System.out.print(i + " ");

			count++;

			if (count == 10 || i == 100) {
				System.out.println();

				count = 0;
			}
		}
	}
}
