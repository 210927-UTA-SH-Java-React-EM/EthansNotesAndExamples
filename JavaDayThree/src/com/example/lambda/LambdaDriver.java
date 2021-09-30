package com.example.lambda;

import java.util.ArrayList;

public class LambdaDriver {

	public static void main(String[] args) {
		
		traditional();
		
		lambdaWay("Hello from lambda");
		
		System.out.println(add(4,4));
		
		System.out.println(sub(5,7));
		
		//Lambdas can also be used with forEach loops
		ArrayList<String> words = new ArrayList<String>();
		words.add("Here");
		words.add("I");
		words.add("go");
		words.add("again");
		words.add("on");
		words.add("my");
		words.add("own!");
		
		words.forEach((String word) -> {
			System.out.println(word);
		});
		
	}
	
	public static void traditional() {
		PrintInterface p = new PrintInterface() {
			@Override
			public void printSomething() {
				System.out.println("Printing something in traditional");
			}
		};
		p.printSomething();
	}
	
	public static void lambdaWay(String s) {
		PrintInterface p = () -> {System.out.println(s);};
		p.printSomething();
	}
	
	public static int add (int x, int y) {
		Calculate calc = () -> x+y;
		return calc.calculate();
	}
	
	public static int sub(int x, int y) {
		Calculate calc = () -> x-y;
		return calc.calculate();
	}

}
