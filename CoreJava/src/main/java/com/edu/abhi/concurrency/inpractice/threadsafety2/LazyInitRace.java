package com.edu.abhi.concurrency.inpractice.threadsafety2;

public class LazyInitRace implements Runnable{
	private ExpensiveObject instance = null;

	private ExpensiveObject getInstance() {
		if (instance == null)
			instance = new ExpensiveObject();
		return instance;
	}

	@Override
	public void run() {
		System.out.println(getInstance());
	}
}
