package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue is an unbounded time-based scheduling BlockingQueue of Delayed
 * elements backed by a heap where an element can only be taken when its delay
 * has expired. If multiple elements have expired delays, the element with the
 * longest delay expiration will be taken first.
 * 
 * @author abhishekkhare
 *
 */
public class DelayQueueExample {

	public static void main(String[] args) throws InterruptedException {
		// Creates an instance of blocking queue using the DelayQueue.
		BlockingQueue<DelayObject> queue = new DelayQueue<DelayObject>();

		// Starting DelayQueue Producer to push some delayed objects to the
		// queue
		new DelayQueueProducer(queue).start();

		// Starting DelayQueue Consumer to take the expired delayed objects from
		// the queue
		new DelayQueueConsumer("Consumer Thread-1", queue).start();
	}

}

class DelayObject implements Delayed {
	private String data;
	private long startTime;

	public DelayObject(String data, long delay) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + delay;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.startTime < ((DelayObject) o).startTime) {
			return -1;
		}
		if (this.startTime > ((DelayObject) o).startTime) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "{" + "data='" + data + '\'' + ", startTime=" + startTime + '}';
	}
}

class DelayQueueProducer {

	// Creates an instance of blocking queue using the DelayQueue.
	private BlockingQueue<DelayObject> queue;


	public DelayQueueProducer(BlockingQueue<DelayObject> queue) {
		super();
		this.queue = queue;
	}

	private Thread producerThread = new Thread(new Runnable() {
		@Override
		public void run() {
			int count=0;
			while(true) {
				try {

					// Put some Delayed object into the DelayQueue.
					int delay = 10000;//random.nextInt(10000);
					DelayObject object = new DelayObject(++count+"", delay);

					System.out.printf("Put object = %s%n", object);
					queue.put(object);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}, "Producer Thread");

	public void start() {
		this.producerThread.start();
	}

}

class DelayQueueConsumer {

	private String name;

	private BlockingQueue<DelayObject> queue;

	public DelayQueueConsumer(String name, BlockingQueue<DelayObject> queue) {
		super();
		this.name = name;
		this.queue = queue;
	}

	private Thread consumerThread = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				try {
					// Take elements out from the DelayQueue object.
					DelayObject object = queue.take();
					System.out.printf("[%s] - Take object = %s%n", Thread.currentThread().getName(), object);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	public void start() {
		this.consumerThread.setName(name);
		this.consumerThread.start();
	}

}