package com.example.singleton;

public class LazySingleton {
	
	//have a value to prove that its the same instance every time
	private int value;
	
	/*
	 * A static member of type LazySingleton will hold our one and only instance. It starts off as uninstantiated since we want
	 * it to load only when its required
	 */
	private static LazySingleton mySingleton;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	//We need to override the clone method from the object class, to disallow users from cloning the singleton
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
}
