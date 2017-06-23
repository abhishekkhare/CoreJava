package com.edu.abhi.concurrency;

public class ThreadCost implements Runnable {

	public static void main(String[] args) {
		System.out.println("Start");
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(new ThreadCost(),""+i);
			t.start();
		}

		System.out.println("Done");
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "Start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End");
	}

}
