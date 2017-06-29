package com.edu.abhi.concurrency.threads.lock;

public class ReadWriteLock {

	private int readers = 0;
	private int writers = 0;
	private int writeRequests = 0;

	public synchronized void lockRead() throws InterruptedException {
		while (writers > 0 || writeRequests > 0) {
			System.out.println("READ::Current Thread Going to wait::" + Thread.currentThread().getName() + " writers::" +writers + " writeRequests::" + writeRequests);
			wait();
			System.out.println("READ::Current Thread awaken::" + Thread.currentThread().getName());
		}
		readers++;
	}

	public synchronized void unlockRead() throws InterruptedException {
		readers--;
		System.out.println("READ::Unlocking Thread::" + Thread.currentThread().getName());
		Thread.sleep(10);
		notifyAll();
	}

	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		while (readers > 0 || writers > 0) {
			System.out.println("WRITE::Current Thread Going to wait::" + Thread.currentThread().getName() + " readers::" + readers+ " writers::" + writers);
			wait();
			System.out.println("WRITE::Current Thread awaken::" + Thread.currentThread().getName());
		}
		writeRequests--;
		writers++;
	}

	public synchronized void unlockWrite() throws InterruptedException {
		writers--;
		System.out.println("WRITE::Unlocking Thread::" + Thread.currentThread().getName());
		Thread.sleep(10);
		notifyAll();
	}
}