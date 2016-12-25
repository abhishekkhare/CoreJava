package com.edu.abhi.concurrency.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author abhishekkhare
 * 
 *         the producer and the consumer, who share a common, fixed-size buffer
 *         used as a queue. The producer’s job is to generate a piece of data,
 *         put it into the buffer and start again. At the same time, the
 *         consumer is consuming the data (i.e., removing it from the buffer)
 *         one piece at a time. The problem is to make sure that the producer
 *         won’t try to add data into the buffer if it’s full and that the
 *         consumer won’t try to remove data from an empty buffer.
 * 
 *         Producer doesn't need to know about who is consumer or how many
 *         consumers are there. Same is true with Consumer. Producer and
 *         Consumer can work with different speed. There is no risk of Consumer
 *         consuming half-baked item. In fact by monitoring consumer speed one
 *         can introduce more consumer for better utilization. Separating
 *         producer and Consumer functionality result in more clean, readable
 *         and manageable code.
 * 
 * 
 */
public class ProducerConsumerPattern {

	public static void main(String args[]) {

		// Creating shared object
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>(100);

		// Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new Producer(sharedQueue));
		Thread prodThread1 = new Thread(new Producer(sharedQueue));
		Thread consThread1 = new Thread(new Consumer1(sharedQueue));
		Thread consThread2 = new Thread(new Consumer2(sharedQueue));

		// Starting producer and Consumer thread
		prodThread.start();
		consThread1.start();
		consThread2.start();
		prodThread1.start();
	}
}
