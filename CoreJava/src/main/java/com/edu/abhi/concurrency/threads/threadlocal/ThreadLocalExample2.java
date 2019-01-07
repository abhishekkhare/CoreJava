package com.edu.abhi.concurrency.threads.threadlocal;

public class ThreadLocalExample2 {

	public static class MyRunnable implements Runnable {
		int counter;
		ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<Integer>();

		public void run() {
			counter++;

			if (threadLocalCounter.get() != null) {
				threadLocalCounter.set(threadLocalCounter.get().intValue() + 1);
			} else {
				threadLocalCounter.set(0);
			}
			System.out.println("Counter: " + counter);
			System.out.println("threadLocalCounter: " + threadLocalCounter.get());
		}

	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable commonInstance = new MyRunnable();

		Thread t1 = new Thread(commonInstance);
		Thread t2 = new Thread(commonInstance);
		Thread t3 = new Thread(commonInstance);
		Thread t4 = new Thread(commonInstance);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// wait for threads to end
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}

}