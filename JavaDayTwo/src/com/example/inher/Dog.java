package com.example.inher;

public class Dog extends Animal{
	
	int age;
	
	public Dog() {
		super("Dog");
		System.out.println("Inside of the dog constructor");
	}
	
	public Dog(int age) {
		this();
		System.out.println("Inside of the dog 1 arg");
		this.age = age;
	}
	
	public void bark() {
		System.out.println("Doggo Barking");
	}
	
}
