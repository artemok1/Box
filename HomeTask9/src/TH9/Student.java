package TH9;

import java.util.Date;

public class Student {
 String name;
 String surname;
 String formatedAge;
 
 Date birthday;
 
 int id;
 
public Student(int id) {
	super();
	this.id = id;
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

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public int getId() {
	return id;
}

public Age getAge() {
	Age age = new Age(this.birthday);
	
	return age;
}
 
}
