package com.example.encap;

public class EncapsulationDriver {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println(p1);
		
		//This will not work because we made the property private
		//p1.firstName = "Larry";
		
		//This will also not work
		//System.out.println(p1.age);
		
		//We must utilize our getters and setters
		p1.setAge(40);
		p1.setFirstName("Jerry");
		p1.setLastName("Smith");
		
		System.out.println(p1);
		
		System.out.println(p1.getAge());
		System.out.println(p1.getFirstName());
		System.out.println(p1.getLastName());
	}
	
}
