package TH1;

public class Person {

	private int age;
	private long id;
	private boolean isDegree;

	private String name;
	private String surname;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getIsDegree() {
		return isDegree;
	}

	public void setIsDegree(boolean isDegree) {
		this.isDegree = isDegree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {

		return id + " " + surname + " " + name;
	}

}
