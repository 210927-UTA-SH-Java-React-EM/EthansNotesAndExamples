package com.example.stringexample;

public class StringExample {
	
	public static void main(String[] args) {
		//declare using a string literal, first time instantiated it is stored in the string pool
		String str1 = "hi";
		
		//declare using a string literal second time, we just point at the one already in the pool
		String str2 = "hi";
		
		//declare using the new keyword, it will create a completely new string object with the value hi
		String str3 = new String("hi");
		
		//With strings the == will check to see if the objects are the same objects in memory
		System.out.println(str1 == str2); //true
		System.out.println(str1 == str3); //false
		System.out.println(str2 == str3); //false
		
		String str4 = "hi";
		
		str2 = "hello";
		
		System.out.println(str1 == str2); //false
		System.out.println(str1 == str4); //true
		
		System.out.println("str4 reassigned to the object reference of str3");
		str4 = str3;
		
		System.out.println(str3 == str4); //true
		
		//If we want to check value of a string vs value of a string
		System.out.println(str1.equals(str3));
		
		//Concatentation
		String str5 = "Hello";
		str5 = str5.concat(", Whats UP?");
		System.out.println(str5);
		
		String str6 = "Hello";
		//short hand concat
		str6 += ", Whats Up?";
		System.out.println(str6);
		
		//String have a length property, so you can check how many chars are stored
		//Use the .length() method to get the length of the string
		System.out.println(str5.length());
		
	}
	
}
