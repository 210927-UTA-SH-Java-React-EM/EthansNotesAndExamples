package com.example.models;

public class Food {

	private int foodId;
	
	private String foodName;
	
	private double calories;

	public Food(int foodId, String foodName, double calories) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.calories = calories;
	}

	public Food() {
		super();
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", calories=" + calories + "]";
	}
}
