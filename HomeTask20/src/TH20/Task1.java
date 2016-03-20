package TH20;

/*
 * Делаем до конца задание, которое было на занятии (создать свою коллекцию, в виде иерархии сотрудников компании) 
 * и добавить к ней свой итератор.
 */

public class Task1 {
	public static void main(String[] args) {
		// id is a key. it should be unique. I did not add check whether is is
		// unique

		// create director
		Director director = new Director(1);
		director.setName("Director");

		// create 3 managers
		Manager manager1 = new Manager(2);
		manager1.setName("Manager 1");

		Manager manager2 = new Manager(3);
		manager2.setName("Manager 2");

		Manager manager3 = new Manager(4);
		manager3.setName("Manager 3");

		// add managers as director subordinates
		manager1.setChief(director);

		director.addSubordinate(manager2);
		director.addSubordinate(manager3);

		System.out.println("Initial state:");
		System.out.println("* Director subordinates: "
				+ director.getSubordinates());

		// create 10 workers
		Worker[] workers = new Worker[10];
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Worker(i + 5);
			workers[i].setName("Worker " + (i + 1));
		}

		// add workers as managers subordinates
		manager1.addSubordinate(workers[0]);
		manager1.addSubordinate(workers[1]);
		manager1.addSubordinate(workers[2]);

		manager2.addSubordinate(workers[3]);
		manager2.addSubordinate(workers[4]);
		manager2.addSubordinate(workers[5]);

		manager3.addSubordinate(workers[6]);
		manager3.addSubordinate(workers[7]);
		manager3.addSubordinate(workers[8]);

		workers[9].setChief(manager3);

		System.out.println("* Manager 1 subordinates: "
				+ manager1.getSubordinates());
		System.out.println("* Manager 2 subordinates: "
				+ manager2.getSubordinates());
		System.out.println("* Manager 3 subordinates: "
				+ manager3.getSubordinates());

		System.out.println("");

		// remove worker 10 from Manager 1
		System.out.println("Remove worker 10 from Manager 3");
		manager3.delSubordinate(workers[9]);
		System.out.println("* Manager 3 subordinates: "
				+ manager3.getSubordinates());

		System.out.println("");

		// fire worker 6
		System.out.println("Fire worker 6");
		workers[5].fire();
		System.out.println("* Manager 2 subordinates: "
				+ manager2.getSubordinates());

		System.out.println("");

		// remove manager 2 from director
		System.out.println("Remove manager 2 from director");
		director.delSubordinate(manager2);
		System.out.println("* director subordinates: "
				+ director.getSubordinates());

		System.out.println("");

		// fire manager 1
		System.out.println("Fire manager 1");
		manager1.fire();
		System.out.println("* director subordinates: "
				+ director.getSubordinates());

		System.out.println("");

		// testing iterator
		System.out
				.println("Show subordinates of manager 3 with a help of iterator:");
		SubordinatesIterator iterator = new SubordinatesIterator(manager3);
		while (iterator.hasNext()) {
			System.out.println("* entry - " + iterator.next().toString());
		}
	}
}
