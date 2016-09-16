package com.edu.abhi.threads;

/**
 * 
 * @author abhishekkhare
 * 
 *         Major difference between yield and sleep in Java is that yield()
 *         method pauses the currently executing thread temporarily for giving a
 *         chance to the remaining waiting threads of the same priority to
 *         execute. If there is no waiting thread or all the waiting threads
 *         have a lower priority then the same thread will continue its
 *         execution. The yielded thread when it will get the chance for
 *         execution is decided by the thread scheduler whose behavior is vendor
 *         dependent. Yield method doesn’t guarantee that current thread will
 *         pause or stop but it guarantee that CPU will be relinquish by current
 *         Thread as a result of call to Thread.yield() method in java.
 * 
 *         Read more:
 *         http://javarevisited.blogspot.com/2011/12/difference-between
 *         -wait-sleep-yield.html#ixzz3mPdAMMtm
 */
public class SleepAndYeild {
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
		t.start();
	}

	public void run() {

		for (int i = 1; i <=10; i++) {
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
