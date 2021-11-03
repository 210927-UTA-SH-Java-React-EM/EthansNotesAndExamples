package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Food;

@Transactional
@Repository("foodDao")
public class FoodRepo {
	
	private SessionFactory sesFact;
	
	public FoodRepo() {
		super();
	}
	
	@Autowired
	public FoodRepo(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	public void insert(Food food) {
		sesFact.getCurrentSession().save(food);
	}
	
	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	public List<Food> selectAll(){
		return sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
	}
	
	public Food selectByName(String name) {
		List<Food> fList = sesFact.getCurrentSession().createQuery("from Food where food_name=:name", Food.class).setParameter("name", name).list();
		if(fList.size() == 0) {
			System.out.println("No food of this name exists");
			return null;
		}
		return fList.get(0);
	}
	
}