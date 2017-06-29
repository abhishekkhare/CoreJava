package com.edu.abhi.concurrency.threads.lock;

import com.edu.abhi.concurrency.threads.starvationandfairness.Lock;

public class Counter {

	private Lock lock = new Lock();
	private int count = 0;

	public int inc() throws InterruptedException {
		lock.lock();
		int newCount = ++count;
		Thread.sleep(100);
		lock.unlock();
		return newCount;
	}
	
	public static void main(String [] args){
		Counter c = new Counter();
		for (int i = 0; i < 10; i++) {
			MyRunnable m = new MyRunnable(c);
			Thread t = new Thread(m, ""+i);
			t.start();
		}
	}
	
}

class MyRunnable implements Runnable{
	Counter c;
	public MyRunnable(Counter cc){
		this.c =cc;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " ---  count="+c.inc());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}