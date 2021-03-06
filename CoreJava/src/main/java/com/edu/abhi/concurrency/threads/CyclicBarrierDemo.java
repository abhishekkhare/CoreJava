package com.edu.abhi.concurrency.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * The java.util.concurrent.CyclicBarrier class is a synchronization mechanism
 * that can synchronize threads progressing through some algorithm. In other
 * words, it is a barrier that all threads must wait at, until all threads reach
 * it, before any of the threads can continue.
 * 
 * @author abhishekkhare
 *
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) throws InterruptedException {
		Runnable barrier1Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 1 executed ");
			}
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 2 executed ");
			}
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(5, barrier2Action);

		// CyclicBarrierRunnable barrierRunnable1 =
		// new CyclicBarrierRunnable(barrier1, barrier2);
		//
		// CyclicBarrierRunnable barrierRunnable2 =
		// new CyclicBarrierRunnable(barrier1, barrier2);
		//
		// new Thread(barrierRunnable1).start();
		// new Thread(barrierRunnable2).start();

		for (int i = 0; i < 100; i++) {
			CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
			new Thread(barrierRunnable1, "Thread" + i).start();
			Thread.sleep(10);
		}

	}

}

class CyclicBarrierRunnable implements Runnable {

	CyclicBarrier barrier1 = null;
	CyclicBarrier barrier2 = null;

	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {

		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
			this.barrier1.await();

			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
			this.barrier2.await();

			System.out.println(Thread.currentThread().getName() + " done!");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}