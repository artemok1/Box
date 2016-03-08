package TH13;

public class Person {
	@Override
	public String toString() {
	   StringBuilder sb = new StringBuilder();	
	   
	   sb.append(id);
	   sb.append(" ");
	   sb.append(name);
	   sb.append(" ");
	   sb.append(surname);
	   sb.append(", age - ");
	   sb.append(age);  
	   sb.append(", is degree - ");
	   sb.append(isDegree);
		
       return sb.toString();
	}
	
	private int age;
	private int id;
	
	private Boolean isDegree;
	
	private String name;
	private String surname;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isDegree() {
		return isDegree;
	}
	public void setDegree(boolean isDegree) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
