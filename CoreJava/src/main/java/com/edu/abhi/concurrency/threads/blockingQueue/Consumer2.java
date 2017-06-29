package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer2 implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Consumer2(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed2: " + sharedQueue.take());
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
