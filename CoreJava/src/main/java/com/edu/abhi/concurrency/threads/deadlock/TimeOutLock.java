package com.edu.abhi.concurrency.threads.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeOutLock {
	public static void main(String[] args) throws Exception {
		final ReentrantLock lock1 = new ReentrantLock();
		final ReentrantLock lock2 = new ReentrantLock();
		Runnable try1_2 = getRunnable(lock1, "lock 1", lock2, "lock 2");
		Runnable try2_1 = getRunnable(lock2, "lock 2", lock1, "lock 1");
		new Thread(try1_2,"A").start();
		new Thread(try2_1,"B").start();
	}

	private static Runnable getRunnable(final ReentrantLock lock1, final String lock1Name, final ReentrantLock lock2,
			final String lock2Name) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					if (lock1.tryLock(60, TimeUnit.SECONDS)) {
						System.out.println(lock1Name + " acquired in thread " + Thread.currentThread());
						if (lock2.tryLock(30, TimeUnit.SECONDS)) {
							System.out.println(lock2Name + " acquired in thread " + Thread.currentThread());
							Thread.sleep(200);
						} else {
							System.out
									.println("Could not acquire " + lock2Name + " in thread " + Thread.currentThread());
							lock1.unlock();
							System.out.println(lock1Name + " released in thread " + Thread.currentThread());
						}
					} else {
						System.out.println("Could not acquire " + lock1Name + " in thread " + Thread.currentThread());
					}
				} catch (InterruptedException e) {
					// you should not ignore it
				} finally {
					if (lock1.isHeldByCurrentThread())
						lock1.unlock();
					if (lock2.isHeldByCurrentThread())
						lock2.unlock();
				}
			}
		};
	}
}
