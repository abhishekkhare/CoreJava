package com.edu.abhi.concurrency;

import java.io.IOException;

public class TerminatingThread {

	public static void main(String[] args) throws IOException {
		MyRunnable obj = new MyRunnable();
        Thread t = new Thread(obj,"Thread-1");
        t.start();

        System.out.println(Thread.currentThread().getName()
                 +" thread waiting for user to press enter");
        System.in.read();
        obj.continueThread = false;

        System.out.println(Thread.currentThread().getName()+" thread ENDED");

	}

}

class MyRunnable implements Runnable {

	boolean continueThread = true;

	public void run() {
		int i = 0;
		while (true)

			if (continueThread) {
				try {
					System.out.println(i++);
					Thread.sleep(1000);
					System.out.println("Please press enter key to stop " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " ENDED");
				break;
			}
	}

}