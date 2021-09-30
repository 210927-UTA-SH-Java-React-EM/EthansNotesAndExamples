package com.example.threads;

public class ThreadDriver {

	public static void main(String[] args) {
		
		//You can create a new thread like this
		Thread th = new Thread();
		
		//You can get the currently running thread
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		try {
			mainThread.sleep(3000);
			System.out.println(mainThread.getPriority());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		MyThread th1 = new MyThread();
		th1.setName("First thread");
		th1.setPriority(10);
		
		MyRunnable r1 = new MyRunnable();
		Thread th2 = new Thread(r1);
		th2.setName("Second  Thread");
		
		th1.start();
		th2.start();
		
		for(int i=0; i<200; i++) {
			System.out.println(Thread.currentThread().getName());
		}

	}

}
