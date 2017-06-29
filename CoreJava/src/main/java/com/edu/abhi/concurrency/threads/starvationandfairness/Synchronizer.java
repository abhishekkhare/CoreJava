package com.edu.abhi.concurrency.threads.starvationandfairness;

public class Synchronizer {

	public synchronized void doSynchronized() {
		// do a lot of work which takes a long time
	}

	Lock lock = new Lock();

	public void doSynchronizedLock() throws InterruptedException {
		this.lock.lock();
		// critical section, do a lot of work which takes a long time
		this.lock.unlock();
	}
}