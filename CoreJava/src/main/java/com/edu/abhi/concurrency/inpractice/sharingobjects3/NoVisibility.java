package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().start();
		 Thread.sleep(2000); // if the time is increased, the ReaderThread
		// will keep yeilding
		ready = true;
		 Thread.sleep(10); // this shows that ready became true but the value
		// of number does not change but ReaderThread starts executing since
		// ready=true
		number = 42;

	}
}
