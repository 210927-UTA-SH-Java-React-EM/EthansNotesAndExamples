package com.example.poly;

public class PolyDriver {
	
	public static void main(String[] args) {
		
		Parent.overloadMe();
		Parent.overloadMe("Hello");
		Parent.overloadMe("Hello", 1);
		Parent.overloadMe(2, "World");
		
		Overriding or1 = new Overriding();
		Parent p1 = new Overriding();
		Parent p2 = new Parent();
		
		//Doesnt Work (compile)
		//Overriding or2 = new Parent();
		//The following will cause ClassCastException
		//Overriding or2 = (Overriding) new Parent();
		
		//We can cast objects to get their parents variables
		System.out.println("Overriding x variable: " + or1.x);
		//This is the parents variable due to casting
		System.out.println("Parent x variable: " + p1.x);
		System.out.println("Parent x variable: " + p2.x);
		
		//Explicit down casting will give us the childs field value
		System.out.println("Overriding x variable: " + ((Overriding) p1).x);
		//What we did above is considered variable hiding, and not recommended
		
		//We can't use casting to get the parents method when the actual objecxt is a child
		System.out.println("Overriding getObj() method:" + or1.getObj());
		System.out.println("Overriding getObj() method:" + p1.getObj());
		System.out.println("Parent getObj() method:" + p2.getObj());
		
		//Since we dont inherit static methods, we can only hide them, not override
		// Since they belong to the class, we can technically cast to get them, but it isnt necessarily the same
		// as traditional casting
		System.out.println("Overriding static method: " + or1.hiding());
		System.out.println("Parent static method: " + p1.hiding());
		System.out.println("Parent static method: " + p2.hiding());
		System.out.println("Overriding static method: " + ((Overriding) p1).hiding());
		
		//The variable inherited will be the same throughout all instances due to inheritance
		final String i = "inherited boolean: ";
		System.out.println(i + or1.inherited);
		System.out.println(i + p1.inherited);
		System.out.println(i + p2.inherited);
	}
	
}
