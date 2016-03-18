package TH19;

/*
 *  >>>>>>>> Prototype pattern <<<<<<<<<<
 *  Prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources 
 *  and you have a similar object already existing. So this pattern provides a mechanism to copy the original object 
 *  to a new object and then modify it according to our needs. This pattern uses java cloning to copy the object.
 */

import java.util.List;

public class Task1_PrototypePattern {

	public static void main(String[] args) {
		User users = new User();
		users.loadData();

		// Use the clone method to get the User object
		User usrNew;

		try {
			usrNew = (User) users.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}

		User usrNew1;

		try {
			usrNew1 = (User) users.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}
		
		List<String> list = usrNew.getUsrList();
		list.add("Set");
		
		List<String> list1 = usrNew1.getUsrList();
		list1.remove("Anubis");

		System.out.println("users List: " + users.getUsrList());
		System.out.println("usrNew List: " + list);
		System.out.println("usrNew1 List: " + list1);

	}

}
