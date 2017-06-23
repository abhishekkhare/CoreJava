package com.edu.abhi.concurrency.threads.threadsignaling;

/**
 * @author abhishekkhare
 * 
 *         Main difference between wait and sleep is that wait() method release
 *         the acquired monitor when thread is waiting while Thread.sleep()
 *         method keeps the lock or monitor even if thread is waiting.
 * 
 * 
 *         wait method in java should be called from synchronized method or
 *         block while there is no such requirement for sleep() method.
 * 
 *         Another difference is Thread.sleep() method is a static method and
 *         applies on current thread, while wait() is an instance specific
 *         method and only got wake up if some other thread calls notify method
 *         on same object.
 * 
 * 
 *         also in case of sleep, sleeping thread immediately goes to Runnable
 *         state after waking up while in case of wait, waiting thread first
 *         acquires the lock and then goes into Runnable state.
 * 
 * 
 *         if you require a specified second of pause use sleep() method or if
 *         you want to implement inter-thread communication use wait method.
 * 
 */
public class WaitAndSleep {
	public static void main(String[] args) {
		/**
		 * When synchronized is Used
		 * 
		 */
		synchronizedCall();

		/**
		 * When synchronized is not Used
		 */
		//unSynchronizedCall();

	}

	private static void unSynchronizedCall() {
		ThreadC c = new ThreadC();
		c.start();

		System.out.println("Total is C : " + c.total);

	}

	private static void synchronizedCall() {
		ThreadB b = new ThreadB();
		b.start();
		//Uncomment B1 related code to see the difference between notify and notifyall
		/*ThreadB b1 = new ThreadB();
		b1.start();*/
		
		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is B : " + b.total);
		}
		
		/*synchronized (b1) {
			try {
				System.out.println("Waiting for b1 to complete...");
				b1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is B1 : " + b.total);
		}*/

	}

	static class ThreadB extends Thread {
		int total;

		@Override
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 100; i++) {
					total += i;
					System.out.println("b is running" + i);
				}
				//notifyAll();
				notify();
			}
		}
	}

	static class ThreadC extends Thread {
		int total;

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				total += i;
			}
		}
	}
}