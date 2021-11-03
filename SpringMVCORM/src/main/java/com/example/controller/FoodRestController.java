package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Food;
import com.example.repository.FoodRepo;

@RestController
@RequestMapping(value="/rest")
public class FoodRestController {
	
	private FoodRepo fDao;
	
	@Autowired
	public FoodRestController(FoodRepo fDao) {
		this.fDao = fDao;
	}
	
	@GetMapping("/id/{id}")
	public Food getFoodById(@PathVariable("id")int id) {
		return fDao.selectById(id);
	}
	
	@GetMapping("/")
	public List<Food> getAllFood(){
		return fDao.selectAll();
	}
	
}
