package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer>{
	
	public Food findByName(String username);
	public List<Food> findByCaloriesLessThan(double cal);
	//public List<Food> getAllOrderByCalories();
	
}
