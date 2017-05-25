package com.edu.abhi.concurrency.inpractice.threadsafety2;

public class UnsafeCountingFactorizer implements Runnable {
	private long count = 0;

	public long getCount() {
		return count;
	}

	

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - " + getCount());
		++count;
	}

}
