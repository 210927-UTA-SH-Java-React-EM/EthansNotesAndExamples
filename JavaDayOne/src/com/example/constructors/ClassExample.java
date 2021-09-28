package com.example.constructors;

//Use the double slash to make a single line comment in Java
/*
 * To make a multiline comment use slash star
 */
//Naming convention for Java classes is TitleCase
public class ClassExample {

	//It is common convention to create your variables at the top of the class
	//Naming convention for variable names is camelCase
	int myNumber;
	String myString;
	
	//It is common convention to create your constructors under you var declarations
	//To create a constructor we simply use the name of the class like we are crating a method
	ClassExample(){
		//This is a no args constructor
		//We implicitly call super() on the first line
		//super();
		System.out.println("Printing inside of the no-args");
	}
	
	ClassExample(int num){
		//This is an example of a args constructor
		//We can "chain" the constructors by calling this()
		this();
		System.out.println("Printing inside of the one arg constructor " + num);
		this.myNumber = num;
	}
	
	ClassExample(int num, String str){
		this(num);
		System.out.println("Printing inside of the two arg:" + num + " " + str);
		this.myString = str;
	}
	
	//It is common convention to create your methods below your constructors
    //Naming conventions for methods in Java follow camelCase
    //The method has four parts the return type (void) in our case
    //The name (myMethod)
    //The Parameters (none)
    //The body (everything inside of {})
	void myMethod() {
		System.out.println(myString);
	}
	
	//The main method is a special method that executes your program
	//It will always have the EXACT method signature
	public static void main(String[] args) {
		//Here we can execute whatever logic we like
		//To create a new object you use the new keyword
		ClassExample myClass = new ClassExample(5, "Hello World");
		ClassExample myClass2 = new ClassExample(7, "Hello");
		
		//To call upon the method, you need an instance of the class (an object)
		//Then you use .methodName(), with opening and closing parenthesis
		myClass.myMethod();
	}
	
}
