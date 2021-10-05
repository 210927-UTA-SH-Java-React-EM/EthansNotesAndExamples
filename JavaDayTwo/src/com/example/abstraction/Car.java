package com.example.abstraction;

public abstract class Car {
	
	int cost;
	boolean isDriving = false;
	
	//You can use constructors to enforce class constraints
	public Car(int cost) {
		this.cost = cost;
	}
	
	//This is an example of a concrete method
	public void start() {
		System.out.println("Car has started");
	}
	
	//This is an example of an abstract method
	public abstract void drive();
	
}
