package com.example.arrays;

public class ArraysAndVarArgs {
	
	//Arrays can be declared in one of two ways
	static int myIntArray[] = new int[] {1,2,3,4,5,6};
	
	char[] myCharArray = {'a', 'b', 'c'};
	
	//mult-dimensional arrays
	int[][] the2dArray = new int[3][3];
	static int[][] my2dArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	static //Access an index of a 2d
	int value = my2dArray[1][2];
	
	public static void arrayLoop() {
		//Use a standard for loop to iterate over a array
		for(int i=0; i<myIntArray.length; i++) {
			System.out.println(myIntArray[i]);
		}
		
		System.out.println("-------");
	}
	
	public static void enhancedForLoop() {
		//It essentially, just loops through an array, and outputs each index
		for(Integer number: myIntArray) {
			System.out.println(number);
		}
		System.out.println("-------");
	}
	
	public static void arraysAsObj() {
		//We can make arrays with objects like Strings
		String[] names = new String[3];
		names[0] = "Ethan";
		names[1] = "Caroline";
		names[2] = "Fred";
		
		for(String name: names) {
			System.out.println(name);
		}
		
		System.out.println("-------");
	}
	
	public static void twoDLoop() {
		//Use nested for loops to iterate through layers of multi-dimensional arrays
		for(int i=0; i<my2dArray.length; i++) {
			for(int j=0; j<my2dArray[i].length; j++) {
				System.out.println("Value at position " + i + " " + j + "= " + my2dArray[i][j]);
			}
		}
	}
	
	public static void workWithArray(int[] arr) {
		for(int number: arr) {
			System.out.println(number);
		}
	}
	
	public static void display(String strValue, int... arr) {
		System.out.println(strValue);
		for(int val: arr) {
			System.out.println(val);
		}
	}
	
	
	
	public static void main(String[] args) {
		//Throw an IndexOutOfBoundsException
		//System.out.println(myIntArray[6]);
		System.out.println(myIntArray.length);
		System.out.println(value);
		arrayLoop();
		enhancedForLoop();
		arraysAsObj();
		twoDLoop();
		workWithArray(myIntArray);
		display("Hello with var args", 1,2,3,4,5,6,7,8,91,3,52,63,623,7,2,72,763);
	}
	
}
