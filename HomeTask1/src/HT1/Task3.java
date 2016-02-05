package HT1;

/*
 * »меетс€ пр€моугольное отверстие размерами a и b (размеры задать любые), определить,
 * можно ли его полностью закрыть круглой картонкой радиусом r (тоже подставл€ем любое значение).
 */

public class Task3 {

	public static void main(String[] args) {
		int a = (int) (Math.random() * 100 + 1);
		int b = (int) (Math.random() * 100 + 1);
		int r = (int) (Math.random() * 100 + 1);

		System.out.println("»меетс€ пр€моугольное отверстие размерами " + a
				+ " и " + b + ", и кругла€ картонка радиусом " + r + ".");

		// Radius should be greater or equal than half of diagonal
		if (Math.sqrt((a * a + b * b)) / 2 >= r) {
			System.out.println(" артонка не закроет квадрат.");
		} else {
			System.out.println(" артонка закроет квадрат.");
		}
	}
}
