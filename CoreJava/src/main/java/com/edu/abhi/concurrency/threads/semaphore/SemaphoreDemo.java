package com.edu.abhi.concurrency.threads.semaphore;

import java.util.concurrent.Semaphore;

/**
 * The counting semaphore is initialized with a given number of "permits". For
 * each call to acquire() a permit is taken by the calling thread. For each call
 * to release() a permit is returned to the semaphore. Thus, at most N threads
 * can pass the acquire() method without any release() calls, where N is the
 * number of permits the semaphore was initialized with. The permits are just a
 * simple counter. Nothing fancy here.
 * 
 * 
 * @author abhishekkhare
 *
 */
public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		// creating a Semaphore object
		// with number of permits 3 and fairness true
		Semaphore sem = new Semaphore(3, true);
		// Semaphore sem = new Semaphore(0, true); - see drainPermits
		// Semaphore sem = new Semaphore(15, true);- see drainPermits

		// isFair() method - Returns true if this semaphore has fairness set
		// true.
		System.out.println("is Fairness enabled : " + sem.isFair());

		// Main thread try to acquire 2 permits
		// tryAcquire(int permits) method - Acquires a permit from this
		// semaphore, only if one is available at the time of invocation.
		sem.tryAcquire(2);

		// availablePermits() method - Returns the current number of permits
		// available in this semaphore.
		System.out.println("Available permits : " + sem.availablePermits());

		// drainPermits() method - Acquires and returns all permits that are
		// immediately available.
		System.out.println("number of permits drain by Main thread : " + sem.drainPermits());

		// permit released by Main thread
		sem.release(1);

		// availablePermits() method
		System.out.println("Available permits : " + sem.availablePermits());

		// creating two threads with name A and B
		MyThread mt1 = new MyThread(sem, "A");
		MyThread mt2 = new MyThread(sem, "B");

		// starting threads A
		mt1.start();

		// starting threads B
		mt2.start();

		// toString method
		System.out.println(sem.toString());

		// waiting for threads A and B
		mt1.join();
		mt2.join();

	}

}

class MyThread extends Thread {
	Semaphore sem;
	String threadName;

	public MyThread(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {

		// First, get a permit.
		System.out.println(threadName + " is waiting for a permit.");

		try {
			// acquire method - Acquires a permit from this semaphore, blocking
			// until one is available, or the thread is interrupted.
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(threadName + " gets a permit");

		// Now, critical section other waiting threads will wait, until this
		// thread release the lock
		for (int i = 0; i < 2; i++) {
			// hasQueuedThreads() methods - Queries whether any threads are
			// waiting to acquire.
			boolean b = sem.hasQueuedThreads();
			if (b) {
				// getQueuedLength() methods
				System.out.println("Length of Queue : " + sem.getQueueLength()); // Returns
																					// an
																					// estimate
																					// of
																					// the
																					// number
																					// of
																					// threads
																					// waiting
																					// to
																					// acquire.
			}
			// Now, allowing a context switch -- if possible.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Release the permit.
		System.out.println(threadName + " releases the permit.");
		// release() method
		sem.release(); // Releases a permit, returning it to the semaphore.
	}
}
