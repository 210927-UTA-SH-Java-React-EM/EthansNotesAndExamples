package com.example.generics;

public class Generics {
	
	public static void main(String[] args) {
		
		GenericClass<String> gc1 = new GenericClass<String>("I am storing a string");
		GenericClass<Integer> gc2 = new GenericClass<Integer>(3);
		
		System.out.println(gc1.getValue());
		//gc1.setValue(2); we have to set it to the same data type
		gc1.setValue("I am still a string");
		System.out.println(gc1.getValue());		
	}
}

class GenericClass<T> {
	private T value;
	private Double value2;
	
	public GenericClass(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}