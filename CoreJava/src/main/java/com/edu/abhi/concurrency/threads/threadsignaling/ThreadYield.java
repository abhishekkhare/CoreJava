package com.edu.abhi.concurrency.threads.threadsignaling;

/**
 * 
 * @author abhishekkhare
 * 
 * 
 */
public class ThreadYield {
	public static void main(String[] args) {
		new ThreadDemo("Thread 1");
		new ThreadDemo("Thread 2");
		new ThreadDemo("Thread 3");
	}

}

class ThreadDemo implements Runnable {

	Thread t;

	ThreadDemo(String str) {

		t = new Thread(this, str);
		// this will call run() function
		if("Thread 2".equals(str)){
			t.setPriority(Thread.MAX_PRIORITY);
		}else{
			t.setPriority(Thread.MIN_PRIORITY);
		}
		t.start();
	}

	public void run() {

		for (int i = 1; i <=20; i++) {
			System.out.println(Thread.currentThread().getName() + ":"+i);
			
			// yields control to another thread every 5 iterations
			if ((i % 5) == 0) {
				System.out.println(Thread.currentThread().getName() + "yielding control...");

				/*
				 * causes the currently executing thread object to temporarily
				 * pause and allow other threads to execute
				 */
				Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " has finished executing.");
	}
}
