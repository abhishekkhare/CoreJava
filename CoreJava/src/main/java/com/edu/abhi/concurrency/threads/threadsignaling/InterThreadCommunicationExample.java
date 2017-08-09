package com.edu.abhi.concurrency.threads.threadsignaling;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunicationExample {
	final static Integer queueSize = 4;
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

		for (int i = 0; i < InterThreadCommunicationExample.queueSize; i++) {
			synchronized (sharedQ) {
				// waiting condition - wait until Queue is not empty
				while (sharedQ.size() >= InterThreadCommunicationExample.queueSize-1) {
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
				if (number == InterThreadCommunicationExample.queueSize-1) {
					break;
				}
			}
		}
	}
}
