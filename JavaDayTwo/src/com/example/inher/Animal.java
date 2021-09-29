package com.example.inher;

public class Animal {
	
	String name = "animal";
	boolean isAlive = true;
	
	int age = 0;
	
	public Animal() {
		System.out.println("In the animal no-args");
	}
	
	public Animal(String name) {
		this();
		System.out.println("In the animal one-arg");
		this.name = name;
	}
	
	public void walk() {
		System.out.println("The " + name + " is walking");
	}
	
}
