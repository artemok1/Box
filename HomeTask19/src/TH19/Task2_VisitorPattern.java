package TH19;

/*
 *  >>>>>>>> Visitor Pattern <<<<<<<<<<
 *  Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. 
 *  With the help of visitor pattern, we can move the operational logic from the objects to another class.
 */

public class Task2_VisitorPattern {

	public static void main(String[] args) {
		// create list of item in shop
		IItem[] items = new IItem[] { new Book(20, "1234"),
				new Book(100, "5678"), new Fruit(7, 2, "Banana"),
				new Fruit(5, 3, "Apple") };
        
		// calculate price of customer
		int total = calculatePrice(items);
		
		System.out.println("Total Cost = " + total);
	}

	private static int calculatePrice(IItem[] items) {
		// create visitor
		ShoppingCartVisitor visitor = new ShoppingCartVisitor();
		
		int sum = 0;
		
		// calculate price
		for (IItem item : items) {
			sum = sum + item.accept(visitor);
		}
		
		return sum;
	}

}
