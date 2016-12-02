package com.edu.abhi.threads;

/**
 * 
 * @author abhishekkhare
 * 
 *         1. Any thread created by main thread, which runs main method in Java
 *         is by default non daemon because Thread inherits its daemon nature
 *         from the Thread which creates it i.e. parent Thread and since main
 *         thread is a non daemon thread, any other thread created from it will
 *         remain non-daemon until explicitly made daemon by calling
 *         setDaemon(true).
 * 
 *         2. Thread.setDaemon(true) makes a Thread daemon but it can only be
 *         called before starting Thread in Java. It will throw
 *         IllegalThreadStateException if corresponding Thread is already
 *         started and running.
 * 
 *         3. Daemon Threads are suitable for doing background jobs like
 *         housekeeping, Though I have yet to use it for any practical purpose
 *         in application code. let us know if you have used daemon thread in
 *         your java application for any practical purpose.
 */
public class DaemonThreadExample {

	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		System.out.println("START THE TEST");
		Thread daemonThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 100; i++) {
						System.out.println("Daemon thread is running before sleep:"+i);
						try {
							Thread.currentThread().sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out
								.println("Daemon thread is running after sleep:"+i);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println("Daemon Thread exiting");//Never Called
				}
			}
		}, "Daemon-Thread");

		Thread nonDaemonThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						System.out.println("Non Daemon thread is running before sleep:" + i);
						try {
							Thread.currentThread().sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out
								.println("Non Daemon thread is running after sleep:" +i);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println("Non Daemon Thread exiting"); 
				}
			}
		}, "Daemon-Thread");

		daemonThread.setDaemon(true); // making this thread daemon
		daemonThread.start();
		nonDaemonThread.start();
		System.out.println("Both Threads have started");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("********* Going to terminate Notice the Finally of daemon thread is never called ********");
	}
}
