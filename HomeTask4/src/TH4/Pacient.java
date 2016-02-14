package TH4;

public class Pacient {
	private String name;
	private String surname;
	private String middleName;
	private String diagnosis;
	private String address;
	private String email;
	
	private int key;
	private int age;
	private int lastWeight;
	private int lastgrowth;
	
	private char sex;
	
	private boolean hasInsurance;

	public static final char M = 'M';
	public static final char W = 'W';
	
	Pacient(int key){
		this.key = key;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLastWeight() {
		return lastWeight;
	}

	public void setLastWeight(int lastWeight) {
		this.lastWeight = lastWeight;
	}

	public int getLastgrowth() {
		return lastgrowth;
	}

	public void setLastgrowth(int lastgrowth) {
		this.lastgrowth = lastgrowth;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isHasInsurance() {
		return hasInsurance;
	}

	public void setHasInsurance(boolean hasInsurance) {
		this.hasInsurance = hasInsurance;
	}

	public int getKey() {
		return key;
	}	
	
}

