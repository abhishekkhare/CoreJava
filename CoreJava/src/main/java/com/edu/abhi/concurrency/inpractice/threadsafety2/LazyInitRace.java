package com.edu.abhi.concurrency.inpractice.threadsafety2;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace implements Runnable{
	private ExpensiveObject instance = null;

	private ExpensiveObject getInstance() {
		if (instance == null)
			instance = new ExpensiveObject();
		return instance;
	}

	@Override
	public void run() {
		System.out.println("Object::" +getInstance());
	}
	
	
	private static void testLazyInitRace() throws InterruptedException {
		LazyInitRace object = new LazyInitRace();
		for (int i = 1; i <= 10; i++) {
			Thread t = new Thread(object,"Thread"+i);
			Thread.sleep(4);
			t.start();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		testLazyInitRace();
	}
}
