package com.edu.abhi.concurrency.threads;

public class AddShutDownHookTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread started");

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					System.out.println("executing shutdown hook");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("shutdown hook executed successfully");
			}
		});

		Thread.sleep(4000); // Optional delay
		System.out.println("main thread ended");
	}

}
