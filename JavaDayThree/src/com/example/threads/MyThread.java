package com.example.threads;

public class MyThread extends Thread{
	
	//The only way to create some custom logic that this thread will be running is to override the run method
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("\t" + Thread.currentThread().getName());
		}
	}
	
}
