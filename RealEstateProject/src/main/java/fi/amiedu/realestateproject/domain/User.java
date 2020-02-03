package fi.amiedu.realestateproject.domain;

import java.util.HashMap;

public class User {
	String type;
	String name;
	String password;

	public User(String type, String name, String password){
	this.type = type;
	this.name = name;
	this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void display() {
		System.out.println("User name: " + getName() + " and role of user: " + getType());
	}
}
