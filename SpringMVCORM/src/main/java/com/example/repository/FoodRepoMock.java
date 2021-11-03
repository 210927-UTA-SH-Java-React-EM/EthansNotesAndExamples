package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.Food;

@Repository("foodDao")
public class FoodRepoMock implements FoodRepo{
	
	//Mock database to hold some food for now
	private List<Food> foodList = new ArrayList<Food>();

	@Override
	public void insert(Food f) {
		foodList.add(f);
	}

	@Override
	public Food selectById(int id) {
		for(Food f: foodList) {
			if(f.getFoodId() == id) {
				return f;
			}
		}
		return null;
	}

	@Override
	public List<Food> selectAll() {
		// TODO Auto-generated method stub
		return foodList;
	}

	@Override
	public Food selectByName(String name) {
		
		for(Food f: foodList) {
			if(f.getFoodName().equals(name)) {
				return f;
			}
		}
		
		return null;
	}
	
	
	
}
