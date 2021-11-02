package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.SuperVillain;

@Repository()
public class SuperVillainDao {

	/*
	 * 
	 * This method is a mod Dao implementation
	 * Instead of going to a database it has a hardcoded list of villains
	 * 
	 */
	
	public List<SuperVillain> selectAll(){
		
		List<SuperVillain> vills = new ArrayList<SuperVillain>();
		
		vills.add(new SuperVillain("Danny Boy", "Technopath", 280_000));
		vills.add(new SuperVillain("Aster", "FireBreath", 100_000));
		vills.add(new SuperVillain("Claire", "Tranformation", 220_000));
		vills.add(new SuperVillain("Rain Man", "SuperSpeed", 210_000));
		
		return vills;
	}
	
}
