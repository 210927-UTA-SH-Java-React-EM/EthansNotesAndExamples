package com.example.models;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User() {
		//super();
	}
	
	public User(String firstName, String lastName, String username, String password) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
