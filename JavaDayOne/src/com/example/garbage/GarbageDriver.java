package com.example.garbage;

public class GarbageDriver {
	
	public static void main(String[] args) {
		System.out.println("Instantiate a new Garbage Object");
		Garbage g = new Garbage(); //Garbage object 1
		System.out.println("Garbage object was created");
		
		System.out.println("Assign the variable g to some other garabage object");
		g = new Garbage(); //Garbage object 2
		
		System.gc();
		
		for(;;) {
			System.out.println("Waiting for garbage collection");
		}
	}
	
}
