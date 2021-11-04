package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Food;
import com.example.repository.FoodRepo;

@Service
public class FoodService {

	private FoodRepo fDao;
	
	@Autowired
	public FoodService(FoodRepo f) {
		this.fDao = f;
	}
	
	public Food createFood(Food f) {
		try {
			fDao.save(f);
			return f;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Food> getAllFood(){
		try {
			return fDao.findAll();
		} catch(Exception e) {
			return new ArrayList<Food>();
		}
	}
	
	public Food getFoodByName(String name) {
		return fDao.findByName(name);
	}
	
	
	public List<Food> getFoodLessThanCal(double cal){
		return fDao.findByCaloriesLessThan(cal);
	}
	
	/*
	public List<Food> sortByCals(){
		return fDao.findAllOrderByCalories();
	}
	*/
	
	public void deleteFood(Food f) {
		fDao.delete(f);
	}
	
	public Food updateFood(Food f) {
		return fDao.save(f);
	}
	
}
