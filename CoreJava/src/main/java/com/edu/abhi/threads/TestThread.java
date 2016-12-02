package com.edu.abhi.threads;

class ThreadDemo1 extends Thread {
	private Thread t;
	private String threadName;

	ThreadDemo1(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				 //Try the below code, you will see that the thread 1 starts before thread 2, however the thread 2 ends before
	            if("Thread-1".equals(threadName))
	            	Thread.sleep(100);
	            else
	            	Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

public class TestThread {

	public static void main(String args[]) {
		ThreadDemo1 T1 = new ThreadDemo1("Thread-1");
		T1.start();

		ThreadDemo1 T2 = new ThreadDemo1("Thread-2");
		T2.start();
	}
}
