package com.edu.abhi.concurrency.inpractice.threadsafety2;

import java.util.concurrent.atomic.AtomicLong;

public class CountingFactorizer implements Runnable {
	private final AtomicLong count = new AtomicLong(0);

	public long getCount() {
		return count.get();
	}

	

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - " + getCount());
		count.incrementAndGet();
	}

}
