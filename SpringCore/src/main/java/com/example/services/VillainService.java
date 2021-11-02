package com.example.services;

import java.util.List;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.SuperVillainDao;
import com.example.models.SuperVillain;

@Component("villServ")
public class VillainService {
	
	//Old way, withour DI
	//private SuperVillainDao vDao = new SuperVillainDao();
	
	//@Autowired //using @Autowired over a property tells spring to attempt byName
	private SuperVillainDao sDao;
	
	public static int counter = 0;
	
	//Used for setting injection
	public VillainService() {
		System.out.println("In the service later no args constructor");
		counter++;
	}
	
	//Used for constructor injection
	@Autowired
	public VillainService(SuperVillainDao sDao) {
		System.out.println("In service layer one args constructor");
		counter++;
		this.sDao = sDao;
	}
	
	//We can also inject values into constructors using spring
	public VillainService(SuperVillainDao sDao, int num) {
		System.out.println("In service layer di constructor with int argument: " + num);
		counter++;
		this.sDao = sDao;
	}
	
	public List<SuperVillain> getAllVills(){
		return sDao.selectAll();
	}
	
	public SuperVillainDao getVillainDao() {
		return sDao;
	}
	
	//@Autowired
	public void setsDao(SuperVillainDao sDao) {
		System.out.println("Setter injection");
		this.sDao = sDao;
	}
	
}
