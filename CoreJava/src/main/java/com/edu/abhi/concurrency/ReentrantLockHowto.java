package com.edu.abhi.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * A java.util.concurrent.locks.Lock is a thread synchronization mechanism just
 * like synchronized blocks. A Lock is, however, more flexible and more
 * sophisticated than a synchronized block.
 * 
 * Lock implementations provide more extensive locking operations than can be
 * obtained using synchronized methods and statements. They allow more flexible
 * structuring, may have quite different properties, and may support multiple
 * associated Condition objects. A lock is a tool for controlling access to a
 * shared resource by multiple threads. Commonly, a lock provides exclusive
 * access to a shared resource: only one thread at a time can acquire the lock
 * and all access to the shared resource requires that the lock be acquired
 * first. However, some locks may allow concurrent access to a shared resource,
 * such as the read lock of a ReadWriteLock.
 * 
 * The use of synchronized methods or statements provides access to the implicit
 * monitor lock associated with every object, but forces all lock acquisition
 * and release to occur in a block-structured way: when multiple locks are
 * acquired they must be released in the opposite order, and all locks must be
 * released in the same lexical scope in which they were acquired.
 * 
 * While the scoping mechanism for synchronized methods and statements makes it
 * much easier to program with monitor locks, and helps avoid many common
 * programming errors involving locks, there are occasions where you need to
 * work with locks in a more flexible way. For example, some algorithms for
 * traversing concurrently accessed data structures require the use of
 * "hand-over-hand" or "chain locking": you acquire the lock of node A, then
 * node B, then release A and acquire C, then release B and acquire D and so on.
 * Implementations of the Lock interface enable the use of such techniques by
 * allowing a lock to be acquired and released in different scopes, and allowing
 * multiple locks to be acquired and released in any order.
 * 
 * In Simple English, the lock  allows user to get and release lock in any order they desire. 
 * 
 * @author abhishekkhare
 *
 */
public class ReentrantLockHowto {

	private final ReentrantLock lock = new ReentrantLock();
	private int count = 0;

	// Locking using Lock and ReentrantLock
	public int getCount() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
			return count++;
		} finally {
			lock.unlock();
		}
	}

	// Implicit locking using synchronized keyword
	public synchronized int getCountTwo() {
		return count++;
	}

	public static void main(String args[]) {
		final ReentrantLockHowto counter = new ReentrantLockHowto();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (counter.getCount() < 6) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (counter.getCount() < 6) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();

	}
}
