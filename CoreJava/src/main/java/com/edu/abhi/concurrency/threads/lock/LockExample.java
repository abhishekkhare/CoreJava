package com.edu.abhi.concurrency.threads.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample extends Thread {
	PrintDemo printDemo;

	LockExample(String name, PrintDemo printDemo) {
		super(name);
		this.printDemo = printDemo;
	}

	@Override
	public void run() {
		System.out.printf("%s starts printing a document\n", Thread.currentThread().getName());
		printDemo.print();
	}

	public static void main(String args[]) {
		PrintDemo PD = new PrintDemo();

		LockExample t1 = new LockExample("Thread - 1 ", PD);
		LockExample t2 = new LockExample("Thread - 2 ", PD);
		LockExample t3 = new LockExample("Thread - 3 ", PD);
		LockExample t4 = new LockExample("Thread - 4 ", PD);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class PrintDemo {
	private final Lock queueLock = new ReentrantLock();

	public void print() {
		queueLock.lock();

		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + "  Time Taken " + (duration / 1000) + " seconds.");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("%s printed the document successfully.\n", Thread.currentThread().getName());
			queueLock.unlock();
		}
	}
}
