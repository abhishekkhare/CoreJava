package com.edu.abhi.threads;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunicationExample {

	public static void main(String args[]) {

		final Queue<Integer> sharedQ = new LinkedList<Integer>();

		Thread producer = new Producer1(sharedQ);
		Thread consumer = new Consumer(sharedQ);

		producer.start();
		consumer.start();

	}
}

class Producer1 extends Thread {
	private final Queue<Integer> sharedQ;

	public Producer1(Queue<Integer> sharedQ) {
		super("Producer");
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {

		for (int i = 0; i < 4; i++) {

			synchronized (sharedQ) {
				// waiting condition - wait until Queue is not empty
				while (sharedQ.size() >= 3) {
					try {
						System.out.println("Queue is full, waiting");
						sharedQ.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				System.out.println("producing : " + i);
				sharedQ.add(i);
				sharedQ.notify();
			}
		}
	}
}

class Consumer extends Thread {
	private final Queue<Integer> sharedQ;

	public Consumer(Queue<Integer> sharedQ) {
		super("Consumer");
		this.sharedQ = sharedQ;
	}

	@Override
	public void run() {
		while (true) {

			synchronized (sharedQ) {
				// waiting condition - wait until Queue is not empty
				while (sharedQ.size() == 0) {
					try {
						System.out.println("Queue is empty, waiting");
						sharedQ.wait();
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				int number = sharedQ.poll();
				System.out.println("consuming : " + number);
				sharedQ.notify();

				// termination condition
				if (number == 3) {
					break;
				}
			}
		}
	}
}
