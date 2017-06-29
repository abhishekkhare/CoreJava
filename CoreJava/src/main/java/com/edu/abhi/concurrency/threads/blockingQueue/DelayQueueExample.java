package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Delayed> queue = new DelayQueue<Delayed>();

		Delayed element1 = new DelayedElement();

		queue.put(element1);

		Delayed element2 = queue.take();

	}

}

class DelayedElement implements Delayed {

	@Override
	public int compareTo(Delayed o) {
		return this.compareTo(o);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return 2;
	}

}
