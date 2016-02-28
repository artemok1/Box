package TH12;

public class Person {
	private String surname;
	private String name;
	private String midleName;
	
	private int id;
	
	public Person(int id) {
		super();
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		 
		return surname + " " + name+ " " + midleName;
	}
	
	
}
