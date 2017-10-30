package com.edu.abhi.concurrency.threads;

public class JavaUncaughtExceptionHandlerExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new TestThread1());
		myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			public void uncaughtException(Thread myThread, Throwable e) {
				System.out.println(myThread.getName() + " throws exception: " + e);
			}
		});
		// this will call run() function
		myThread.start();

	}

}

class TestThread1 implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();

	}
}
