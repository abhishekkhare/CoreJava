package com.edu.abhi.concurrency.threads.racecondition;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

/**
 * Now two threads can execute the add() method at the same time. One thread
 * inside the first synchronized block, and another thread inside the second
 * synchronized block. The two synchronized blocks are synchronized on different
 * objects, so two different threads can execute the two blocks independently.
 * This way threads will have to wait less for each other to execute the add()
 * method.
 * 
 * @author abhishekkhare
 *
 */
@ThreadSafe
public class TwoSumsTSEnhanced {
	private int sum1 = 0;
	private int sum2 = 0;

	private Integer sum1Lock = new Integer(1);
	private Integer sum2Lock = new Integer(2);

	public void add(int val1, int val2) {
		synchronized (this.sum1Lock) {
			System.out.println("*************" + Thread.currentThread().getName() + "**********************");
			this.sum1 += val1;
			System.out.println(this.sum1);
		}
		synchronized (this.sum2Lock) {
			System.out.println("##############" + Thread.currentThread().getName() + "#################");
			this.sum2 += val2;
			System.out.println(" - " + this.sum2);
		}
	}

	public static void main(String[] args) {

		TwoSumsTSEnhanced ts = new TwoSumsTSEnhanced();
		for (int i = 0; i < 10; i++) {
			R1Runnable r = new R1Runnable(ts, i);
			Thread t = new Thread(r, i + "");
			t.start();
		}
	}

	static class R1Runnable implements Runnable {
		TwoSumsTSEnhanced ttss;
		Integer ii;

		R1Runnable(TwoSumsTSEnhanced ts, Integer i) {
			this.ttss = ts;
			this.ii = i;
		}

		public void run() {
			this.ttss.add(ii, ii * 10);
		}
	}
}