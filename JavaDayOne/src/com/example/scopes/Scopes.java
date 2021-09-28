package com.example.scopes;

public class Scopes {
	
	//Order of initialization
	//The first thing created when a class is called are the static variables
	//The thing are static initializers
	//After that we create instance variables, followed by instance initializers
	//The last thing are the constructors
	
	//The first 2 are instance variables
	public int a = 5;
	public int b = 6;
	
	//The second 2 are class scope
	public static int c = 7;
	public static String str = "Hello";
	
	public final static String CONSTANT = "This can never be reassigned";
	
	//Static initilizer block of code
	static {
		System.out.println("Some logic here in static");
		str = "Hello World";
		//a = 8;
	}
	
	//instance initilizer
	{
		System.out.println("Some logic here in instance");
	}
	
	//method scope
	public void method1() {
		String hello = "Hello";
		System.out.println(hello);
		//Some block scope
		if(5 == 5) {
			//These are block scope
			int i = 78;
			//We can still access hello because we are in the method
			hello = "World";
			System.out.println(hello);
		}
		//YOu cannot print i outside of the if statement
		//System.out.println(i);
	}
	
	public static void hello() {
		System.out.println("Hello static method");
	}
	
}
