package com.example.myapp;

import org.springframework.stereotype.Component;

@Component("appProxy")
public class ProxyApp {
	
	public ProxyApp() {
		
	}
	
	public int drawCartoon(char a, int b) {
		System.out.println("----- Drawing Cartoon -__-(T.T)-__- -----");
		System.out.println();
		return 5;
	}
	
	public void drawRickAndMorty(int b) {
		System.out.println("----- I'm Mr. Meeseeks look at me!");
		System.out.println();
	}
	
	public void drawNature() {
		System.out.println("----- Drawing some happy little trees :) -----");
		System.out.println("----- No mistakes, just Happy Little Accidents :) -----");
		System.out.println();
	}
	
	public void drawSpace() {
		System.out.println("-----        -----");
		throw new NullPointerException();
	}
	
	public void sculpPottery() {
		System.out.println("----- making a mug -----");
		System.out.println();
		return;
	}

}
