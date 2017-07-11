package com.edu.abhi.concurrency.threads;

import java.util.concurrent.CountDownLatch;

/**
 * A java.util.concurrent.CountDownLatch is a concurrency construct that allows
 * one or more threads to wait for a given set of operations to complete.
 * 
 * A CountDownLatch is initialized with a given count. This count is decremented
 * by calls to the countDown() method. Threads waiting for this count to reach
 * zero can call one of the await() methods. Calling await() blocks the thread
 * until the count reaches zero.
 * 
 * @author abhishekkhare
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter waiter1 = new Waiter(latch);
		Waiter waiter2 = new Waiter(latch);
		Waiter waiter3 = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		Thread tw1 = new Thread(waiter1, "1");
		Thread tw2 = new Thread(waiter2, "2");
		Thread tw3 = new Thread(waiter3, "3");
		Thread td = new Thread(decrementer);
		tw1.start();
		tw2.start();
		tw3.start();
		td.start();
		tw1.join();
		tw2.join();
		tw3.join();
		td.join();

		System.out.println("Done");

	}

}

class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			System.out.println("Starting to Wait!! " + Thread.currentThread().getName());
			latch.await();
			System.out.println("Wait is finally over " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released " + Thread.currentThread().getName());
	}
}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			System.out.println("Wait!!!");
			Thread.sleep(3000);
			this.latch.countDown();
			System.out.println("Wait!!");
			Thread.sleep(2000);
			this.latch.countDown();
			System.out.println("Wait!");
			Thread.sleep(1000);
			this.latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}