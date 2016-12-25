package com.edu.abhi.concurrency.threads;

/**
 * 
 * @author abhishekkhare
 * 
 *         Main difference between notify and notifyAll is that notify method
 *         will only notify one Thread and notifyAll method will notify all
 *         Threads which are waiting on that monitor or lock
 * 
 * 
 *         When you call notify only one of waiting thread will be woken and its
 *         not guaranteed which thread will be woken, it depends upon Thread
 *         scheduler. While if you call notifyAll method, all threads waiting on
 *         that lock will be woken up, but again all woken thread will fight for
 *         lock before executing remaining code and that's why wait is called on
 *         loop because if multiple threads are woken up, the thread which will
 *         get lock will first execute and it may reset waiting condition, which
 *         will force subsequent threads to wait. So key difference between
 *         notify and notifyAll is that notify() will cause only one thread to
 *         wake up while notifyAll method will make all thread to wake up.
 * 
 *         if we don't call wait () or notify () method from synchronized
 *         context we will receive IllegalMonitorStateException in java.
 * 
 * 
 *         We use wait () and notify () or notifyAll () method mostly for
 *         inter-thread communication. One thread is waiting after checking a
 *         condition
 *         
 *         Read more:
 *         http://javarevisited.blogspot.com/2011/05/wait-notify-and-notifyall
 *         -in-java.html#ixzz3mPcVKpLo
 */
public class NotifyAndNotifyAll {
	private volatile boolean go = false;

	public static void main(String args[]) throws InterruptedException {

		final NotifyAndNotifyAll test = new NotifyAndNotifyAll();

		Runnable waitTask = new Runnable() {

			@Override
			public void run() {
				try {
					test.shouldGo();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.out.println(Thread.currentThread()
						+ " finished Execution WWW");
			}
		};

		Runnable notifyTask = new Runnable() {

			@Override
			public void run() {
				/*for (int i = 0; i < 1000; i++) { // if this is not run in loop only one thread will finish and the other threads will never come out of wait.
					test.go();	
				}*/
				test.go();	
				System.out.println(Thread.currentThread()
						+ " finished Execution NN");
			}
		};

		Thread t1 = new Thread(waitTask, "WT1"); // will wait
		Thread t2 = new Thread(waitTask, "WT2"); // will wait
		Thread t3 = new Thread(waitTask, "WT3"); // will wait
		Thread t4 = new Thread(notifyTask, "NT1"); // will notify

		// starting all waiting thread
		t1.start();
		t2.start();
		t3.start();

		// pause to ensure all waiting thread started successfully
		Thread.sleep(200);

		// starting notifying thread
		t4.start();

	}

	/**
	 * wait and notify can only be called from synchronized method or block
	 */
	private synchronized void shouldGo() throws InterruptedException {
		while (go != true) {
			System.out.println(Thread.currentThread()
					+ " is going to wait on this object");
			wait(); // release lock and re acquires on wakeup
			System.out.println(Thread.currentThread() + " is woken up");
		}
		go = false; // resetting condition
	}

	/**
	 * both shouldGo() and go() are locked on current object referenced by
	 * "this" keyword
	 */
	private synchronized void go() {
		while (go == false) {
			System.out
					.println(Thread.currentThread()
							+ " is going to notify all or one thread waiting on this object");

			go = true; // making condition true for waiting thread
			// notify(); // only one out of three waiting thread WT1, WT2,WT3
			// will woke up
			notifyAll(); // all waiting thread WT1, WT2,WT3 will woke up
		}

	}

}
