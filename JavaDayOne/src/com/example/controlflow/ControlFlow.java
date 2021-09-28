package com.example.controlflow;

public class ControlFlow {
	
	public static void main(String args[]) {
		ControlFlow cf = new ControlFlow();
		cf.ifElseIfExample(-1);
		cf.switchExample("Swinter");
		cf.ternary(3);
		cf.forLoopExample();
		cf.whileLoopExample();
		cf.doWhileLoopExample();
		cf.shortCircuit();
		cf.preVsPostFix();
	}
	
	public void ifElseIfExample(int a) {
		if(a < 0) {
			System.out.println("The number is negative");
		} else if (a > 0) {
			System.out.println("The number is positive");
		} else {
			System.out.println("The number is zero");
		}
	}
	
	public void switchExample(String season) {
		switch(season) {
			//Everyone of the cases can be thought of as an individual else if in an if-statement
			case "Summer":
				System.out.println("Lets go to the pool/lake");
				break;
			case "Fall":
				System.out.println("Trick-or-treat");
				break;
			case "Winter":
				System.out.println("It's snowing");
				break;
			case "Spring":
				System.out.println("Sprannng Break");
				break;
			default:
				System.out.println("Season is not recognized");
		}
	}
	
	public void ternary(int x) {
		String s = x > 3 ? "x is greater than 3" : "x is not greater than 3";
		System.out.println(s);
	}
	
	public void forLoopExample() {
		//When using a for loop, we use three things
		// Looping variable, boolean condition, increment
		for(int i = 0; i<10; i++) {
			System.out.println(i);
		}
	}
	
	public void whileLoopExample() {
		//Declaring a looping variable
		int i = 10;
		
		//boolean expression
		while(i <10) {
			System.out.println(i);
			i++;
		}
	}
	
	public void doWhileLoopExample() {
		int i = 10;
		
		do {
			//Inside of these brackets are where the repeated code is executed
			System.out.println(i);
			i++;
		} while(i < 10);
	}
	
	//Short circuiting in action
	private boolean inc(int i) {
		return i > 0 ? true: false;
	}
	
	public void shortCircuit() {
		int i = 0;
		boolean bool1 = true;
		boolean bool2 = false;
		boolean bool3 = false;
		
		bool3 = (bool2 & inc(i++)); //Increment here
		bool3 = (bool2 && inc(i++)); // Logical and doesn't look at second value
		bool3 = (bool1 | inc(i++)); // Increment here
		bool3 = (bool1 || inc(i++)); // Logical or doesn't look at second value
		
		System.out.println(i);
	}
	
	public void preVsPostFix() {
		int x = 5;
		int y = ++x;
		
		System.out.println(y + " " + x);
		
		int z = x++;
		System.out.println(z + " " + x);
	}
	
}
