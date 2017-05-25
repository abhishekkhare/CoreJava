package com.edu.abhi.concurrency.inpractice.threadsafety2;

public class ExpensiveObject {

	public ExpensiveObject() {
		System.out.println("Starting Object Build....");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Object Build Completed");
	}

}
