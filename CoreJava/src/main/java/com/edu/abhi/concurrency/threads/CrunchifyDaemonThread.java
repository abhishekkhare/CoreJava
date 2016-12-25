package com.edu.abhi.concurrency.threads;

public class CrunchifyDaemonThread extends Thread {
	public static void main(String[] args) {
		System.out.println("Main Method Entry");

		CrunchifyDaemonThread t = new CrunchifyDaemonThread();
		t.setDaemon(true);
		// When false, (i.e. when it's a user thread), the Worker thread
		// continues to run.
		// When true, (i.e. when it's a daemon thread), the Worker thread
		// terminates when the main thread terminates.
		t.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException x) {
		}

		System.out.println("Main Method Exit");
	}

	public void run() {
		System.out.println("run Method Entry");

		try {
			System.out.println("In run Method: currentThread() is"
					+ Thread.currentThread());

			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException x) {
				}

				System.out.println("In run method.." + Thread.currentThread());
			}
		} finally {
			System.out.println("run Method Exit");
		}
	}
}
