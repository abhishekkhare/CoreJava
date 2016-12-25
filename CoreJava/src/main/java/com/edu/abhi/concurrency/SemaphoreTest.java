package com.edu.abhi.concurrency;

import java.util.concurrent.Semaphore;

/**
 * The java.util.concurrent.Semaphore class is a counting semaphore. That means
 * that it has two main methods:
 * 
 * acquire() release() The counting semaphore is initialized with a given number
 * of "permits". For each call to acquire() a permit is taken by the calling
 * thread. For each call to release() a permit is returned to the semaphore.
 * Thus, at most N threads can pass the acquire() method without any release()
 * calls, where N is the number of permits the semaphore was initialized with.
 * The permits are just a simple counter. Nothing fancy here.
 * 
 * http://tutorials.jenkov.com/java-util-concurrent/semaphore.html 
 * @author abhishekkhare
 *
 */
public class SemaphoreTest {

	Semaphore binary = new Semaphore(3);

	public static void main(String args[]) {
		final SemaphoreTest test = new SemaphoreTest();
		for (int i = 0; i < 10; i++) {
			new Thread("Thread-" + i) {
				@Override
				public void run() {
					test.mutualExclusion();
				}
			}.start();
		}

	}

	private void mutualExclusion() {
		try {
			System.out.println(Thread.currentThread().getName() + " before mutual exclusive region");
			Thread.sleep(1000);
			binary.acquire();

			// mutual exclusive region
			System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
