package com.example.models;

public class SuperVillain {
	
	private String name;
	private String superPower;
	private int bounty;
	
	public SuperVillain() {
		
	}
	
	public SuperVillain(String name, String sp, int bounty) {
		this.name = name;
		this.superPower = sp;
		this.bounty = bounty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public int getBounty() {
		return bounty;
	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

	@Override
	public String toString() {
		return "SuperVillain [name=" + name + ", superPower=" + superPower + ", bounty=" + bounty + "]";
	}
}
