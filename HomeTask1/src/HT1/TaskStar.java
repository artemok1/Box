package HT1;

/*
 * Сделать расчет выражения
 */

public class TaskStar {

	public static void main(String[] args) {
		double x = Math.random()*100;
		int t = (int)(Math.random()*100);
		int s = (int)(Math.random()*100); 
		
		System.out.println("х = " + x + "."); 
		System.out.println("t = " + t + ".");
		System.out.println("s = " + s + ".");
		
		double y =  Math.pow(Math.sin(Math.pow(x, t)),2)/(Math.sqrt(Math.pow(x,s) + 1));
		
		System.out.println("y = " + y + ".");
	}

}
