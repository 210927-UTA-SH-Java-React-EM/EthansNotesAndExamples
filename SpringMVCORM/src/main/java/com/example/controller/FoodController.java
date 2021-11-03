package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Food;
import com.example.repository.FoodRepo;

//Mark this class as a controller bean
@Controller
//Map the class to a specific uri
@RequestMapping(path="/food")
//CORS aka cross origin resource sharing is a way to restrict access from resources outside of the server domain, we want
// to allow CORS
@CrossOrigin(origins="*")
public class FoodController {

	private FoodRepo fDao;
	
	@Autowired
	public FoodController(FoodRepo fDao) {
		this.fDao = fDao;
	}
	
	@RequestMapping(value="/")
	public @ResponseBody List<Food> getAllFoods(){
		System.out.println("In get all foods");
		return fDao.selectAll();
	}
	
	//Instead of RequestMapping there are individual mapping annotations for each http method
	@PostMapping(value="/")
	public @ResponseBody String createFood(@RequestBody Food f) {
		System.out.println("In the create food method");
		fDao.insert(f);
		return "Food created successfuly";
	}
	
	@GetMapping(value="/id")
	//You can also use ResponseEntity to manually set the reponsebody and status
	public ResponseEntity<Food> getFoodById(@RequestParam("id")int id){
		return new ResponseEntity<Food>(fDao.selectById(id), HttpStatus.OK);
	}
	
	@GetMapping(value="/{name}")
	public ResponseEntity<Food> getFoodByName(@PathVariable("name")String name){
		Food food = fDao.selectByName(name);
		if(food == null) {
			return new ResponseEntity<Food>(new Food(0,"",0.0), HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		}
	}
	
}
