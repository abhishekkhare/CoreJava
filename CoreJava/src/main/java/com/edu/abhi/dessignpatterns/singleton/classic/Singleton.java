package com.edu.abhi.dessignpatterns.singleton.classic;

// NOTE: This is not thread safe!

public class Singleton {
	private static Singleton uniqueInstance;
 
	// other useful instance variables here
 
	private Singleton() {}
 
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("" + Thread.currentThread().getName());
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
}
