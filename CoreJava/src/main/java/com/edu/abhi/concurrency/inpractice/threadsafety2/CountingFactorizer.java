package com.edu.abhi.concurrency.inpractice.threadsafety2;

import java.util.concurrent.atomic.AtomicLong;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class CountingFactorizer{
	private final AtomicLong count = new AtomicLong(0);

	public long getCount() {
		return count.get();
	}

	public void run() {
		count.incrementAndGet();
	}

	public static void main(String[] args) throws InterruptedException {
		CountingFactorizer seq = new CountingFactorizer();
		CountingFactorizerRunnable r1 = new CountingFactorizerRunnable(seq);
		CountingFactorizerRunnable r2 = new CountingFactorizerRunnable(seq);
		CountingFactorizerRunnable r3 = new CountingFactorizerRunnable(seq);
		Thread t1 = new Thread(r1, "1");
		Thread t2 = new Thread(r2, "2");
		Thread t3 = new Thread(r3, "3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println(Thread.currentThread().getName() + " - " + seq.getCount());
	}

}

class CountingFactorizerRunnable implements Runnable {
	CountingFactorizer obj;

	CountingFactorizerRunnable(CountingFactorizer obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		this.obj.run();
		System.out.println(Thread.currentThread().getName() + " - " + this.obj.getCount());

	}

}
