package com.example.repository;

import java.util.List;

import com.example.models.Food;

public interface FoodRepo {
	
	void insert(Food f);
	
	Food selectById(int id);
	
	List<Food> selectAll();
	
	Food selectByName(String name);
	
}
