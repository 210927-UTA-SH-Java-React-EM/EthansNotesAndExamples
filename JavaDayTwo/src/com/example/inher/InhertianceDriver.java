package com.example.inher;

public class InhertianceDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Creating Animal 1");
		Animal a1 = new Animal();
		System.out.println("Creating Animal 2");
		Animal a2 = new Animal("Cat");
		System.out.println("Creating Dog 1");
		Dog d1 = new Dog(1);
		
		a1.walk();
		a2.walk();
		d1.walk();
		
		//a2.bark(); doesnt work because animal does not have the bark method
		d1.bark();
		
		System.out.println("Animal one age: " + a1.age);
		System.out.println("Animal two age: " + a2.age);
		//The age variable in the animal class is overshaddowed by the age variable in the dog class
		System.out.println("Dog age: " + d1.age);
		
	}
	
}
