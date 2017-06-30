package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
	public static void main(String args[]) {
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		Thread producer = new Thread("PRODUCER") {
			public void run() {
				for (int i = 0; i < 5; i++) {
					String event = "STRING" +i;
					try {
						//Thread.sleep(10);
						queue.put(event);
						// thread will block here
						System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		producer.start(); // starting publisher thread
		Thread consumer = new Thread("CONSUMER") {
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(3000);
						String event = queue.take(); // thread will block here
						System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
				
			}
		};
		consumer.start(); // starting consumer thread
	}
}
