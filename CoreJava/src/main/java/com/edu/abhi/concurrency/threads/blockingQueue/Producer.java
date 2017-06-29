package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Producer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				System.out.println("Produced: " + i);
				Thread.sleep(200);
				sharedQueue.put(i);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
