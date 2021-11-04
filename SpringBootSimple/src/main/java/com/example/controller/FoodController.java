package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Food;
import com.example.service.FoodService;

@RestController
@RequestMapping(value="/food")
public class FoodController {
	
	private FoodService fServ;
	
	@Autowired
	public FoodController(FoodService f) {
		this.fServ = f;
	}
	
	@GetMapping(value="/get")
	public List<Food> getAll(){
		System.out.println("In the /get method");
		return fServ.getAllFood();
	}
	
	@PostMapping(value="/create")
	public Food createFood(@RequestBody Food f) {
		System.out.println(f);
		return fServ.createFood(f);
	}
	
	@GetMapping(value="/get/cals")
	public List<Food> getFoodUnderCals(@RequestParam("cals")double cals){
		
		return fServ.getFoodLessThanCal(cals);
		
	}
	
	@GetMapping(value="/{name}")
	public Food getFoodByName(@PathVariable("name") String name) {
		return fServ.getFoodByName(name);
	}
	
}
