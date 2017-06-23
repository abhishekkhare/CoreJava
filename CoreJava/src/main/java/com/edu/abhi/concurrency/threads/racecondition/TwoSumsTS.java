package com.edu.abhi.concurrency.threads.racecondition;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class TwoSumsTS {
	private int sum1 = 0;
	private int sum2 = 0;

	public void add(int val1, int val2) {
		synchronized (this) {
			this.sum1 += val1;
			this.sum2 += val2;
			System.out.println("Sum1:" + sum1 + " Sum2:" + sum2);
		}
	}

	public static void main(String[] args) {

		TwoSumsTS ts = new TwoSumsTS();
		for (int i = 0; i < 10; i++) {
			R1Runnable r = new R1Runnable(ts, i);
			Thread t = new Thread(r, i + "");
			t.start();
		}
	}

	static class R1Runnable implements Runnable {
		TwoSumsTS ttss;
		Integer ii;

		R1Runnable(TwoSumsTS ts, Integer i) {
			this.ttss = ts;
			this.ii = i;
		}

		public void run() {
			this.ttss.add(ii, ii * 10);
		}
	}
}