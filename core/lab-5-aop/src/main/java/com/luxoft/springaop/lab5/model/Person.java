package com.luxoft.springaop.lab5.model;

import java.util.List;

public interface Person {
	void setIsProgrammer(boolean isProgrammer);
	void setAge(int age);
	void setHeight(float height);
	void setName(String name);
	String getName();
	void sayHello(Person person);
	Country getCountry();
	void setCountry(Country country);
	boolean isProgrammer();
	void setProgrammer(boolean programmer);
	List<String> getContacts();
	void setContacts(List<String> contacts);
	int getId();
	void setId(int id);
}
