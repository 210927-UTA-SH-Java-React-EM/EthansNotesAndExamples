package com.example.scopes;

public class ScopeDriver {
	
	public static void main(String[] args) {
		
		//We create an instance of out Scopes class
		Scopes sc = new Scopes();
		
		System.out.println(sc.a);
		
		System.out.println(sc.str);
		
		//Show the effect of a static var
		Scopes sc2 = new Scopes();
		
		sc2.str = "I'm a new string";
		
		System.out.println(sc.str);
		System.out.println(sc2.str);
		
		//The proper way to call static vars and methods
		System.out.println(Scopes.str);
		
		Scopes.hello();
		
	}
	
}
