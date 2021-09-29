package com.example.abstraction;

public interface Upgrade {
	
	boolean modifed = true;
	
	String getMods();
	
	//Default keyword allows us to implement methods in interfaces now
	default void showOff() {
		System.out.println("Showing off our cool mods");
	}
	
}
