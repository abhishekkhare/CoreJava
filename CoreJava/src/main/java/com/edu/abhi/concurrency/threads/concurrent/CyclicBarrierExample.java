package com.edu.abhi.concurrency.threads.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Java program to demonstrate how to use CyclicBarrier in Java. CyclicBarrier
 * is a new Concurrency Utility added in Java 5 Concurrent package.
 * 
 * @author abhishekkhare
 */
public class CyclicBarrierExample {

	// Runnable task for each thread
	private static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (BrokenBarrierException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {

		// creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call
		// await()
		final CyclicBarrier cb = new CyclicBarrier(10, new Runnable() {
			@Override
			public void run() {
				// This task will be executed once all thread reaches barrier
				System.out.println("All parties are arrived at barrier, lets play");
			}
		});

		for (int i = 0; i <50; i++) {
			Thread t = new Thread(new Task(cb), "Thread "+i);
			// starting each of thread
			t.start();
		}
		
		
		
	}
}
