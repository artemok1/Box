package TH16;

import java.util.Scanner;

/*
 * Написать приложение, в котором используются 2 потока(класс один и тот же). 
 * Класс потока задать как наследник Thread. Класс потока должен обеспечивать в методе run 
 * построчный несинхронизированный вывод в консольное окно чисел от 1 до 100 порциями по 10 чисел в строке, 
 * разделенных пробелами, причем перед каждой такой порцией должна стоять надпись: 
 * "Thread 1:" для первого потока, "Thread 2:" — для второго  - можно использовать название потока (есть соответствующий метод). 
 * Для вывода строки чисел задать в Main классе метод print10() - в нем запускать цикл на печать 10-ти чисел. 
 * В приложении при вводе с клавиатуры "start" потоки должны стартовать.
 * 
 * Усовершенствовать предыдущее приложение, обеспечив синхронизацию за счет объявления вызова print10() синхронизированным.
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
