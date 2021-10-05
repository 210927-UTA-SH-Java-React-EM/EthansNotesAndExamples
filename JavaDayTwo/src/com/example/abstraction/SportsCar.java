package com.example.abstraction;

public class SportsCar extends Car implements SportsUpgrade{
	
	String name;
	
	public SportsCar(int cost, String name) {
		super(cost);
		this.name = name;
	}

	@Override
	public String getMods() {
		return SportsCar.sportsMods + ", Tire Upgrade, Window Tint";
	}

	@Override
	public void rev() {
		System.out.println("The sports car rev's its engine");
		
	}

	@Override
	public void burnout() {
		System.out.println("The sports car does a burnout");
		
	}

	@Override
	public void drive() {
		this.isDriving = true;
		System.out.println("The sports car drive fast!");
	}

}
