package com.edu.abhi.concurrency.threads.starvationandfairness;

public class Lock {
	private boolean isLocked = false;
	private Thread lockingThread = null;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			System.out.println("Current Thread*" + Thread.currentThread().getName() + " Locking Thread*" + lockingThread.getName());
			wait();
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
		System.out.println("Current Thread#" + Thread.currentThread().getName() + " Locking Thread#:" + lockingThread.getName());
	}

	public synchronized void unlock() {
		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		System.out.println("Unlocking Thread" + Thread.currentThread().getName());
		isLocked = false;
		lockingThread = null;
		
		notify();
	}
}