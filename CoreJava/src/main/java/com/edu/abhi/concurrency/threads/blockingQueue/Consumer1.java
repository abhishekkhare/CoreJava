package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer1 implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Consumer1(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed1: " + sharedQueue.take());
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
