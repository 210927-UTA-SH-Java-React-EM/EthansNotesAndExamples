package com.example.models;

import java.io.Serializable;

public class User implements Serializable {

	// Serializable ID
	private static final long serialVersionUID = 236629132635269168L;
	
	
	// User info strings
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	
	// Constructors
	
	public User() {
		super();
	}
	
	public User(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	
	// Getters / Setters

	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }

	public String getUsername() { return username; }

	public String getPassword() { return password; }
	

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public void setUsername(String username) { this.username = username; }

	public void setPassword(String password) { this.password = password; }
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}

	
	
}
