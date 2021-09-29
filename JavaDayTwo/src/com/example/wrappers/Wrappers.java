package com.example.wrappers;

public class Wrappers {

	public static void main(String[] args) {
		
		//There are multiple ways we can create a wrapper object
		Integer x = 5;
		Integer y1 = new Integer(8);
		Integer parseInt = Integer.parseInt("5");
		
		int x2 = 5;
		int y2 = 7;
		
		autoboxing(x2, y2);
		unboxing(x, y1);

	}
	
	public static void autoboxing(Integer x, Integer y) {
		System.out.println("We are in the autoboxing method!");
		System.out.println(x+y);
	}
	
	public static void unboxing(int x, int y) {
		System.out.println("We are in the unboxing method!");
		System.out.println(x+y);
	}

}
