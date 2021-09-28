package com.example.garbage;

public class Garbage {
	
	//Finalize is a method we can call right before we destroy an object in Java
	@Override
	protected void finalize() {
		System.out.println("GarbageDrivers finalize method called");
		System.out.println("Goodbye cruel world");
		System.exit(0);
	}
	
}
