package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeExample {
	public static void main(String[] args) {
        final BlockingDeque<String> priorityBlockingQueue = new LinkedBlockingDeque<String>();

        LinkedBlockingDequeProducer queueProducer = new LinkedBlockingDequeProducer(
                priorityBlockingQueue);
        new Thread(queueProducer).start();

        LinkedBlockingDequeConsumer queueConsumer1 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer1).start();

        LinkedBlockingDequeConsumer queueConsumer2 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer2).start();
    }
}

class LinkedBlockingDequeProducer implements Runnable {
    protected BlockingDeque<String> blockingDeque;
    final Random random = new Random();

    public LinkedBlockingDequeProducer(BlockingDeque<String> queue) {
        this.blockingDeque = queue;
    }

    @Override
    public void run() {
    	int count=0;
        while (true) {
            try {
            	//for (int i = 0; i < 20; i++) {
            		String data = "Abhi-" + ++count;
                    System.out.println("Put: " + data);
                    blockingDeque.addFirst(data);
                    Thread.sleep(500);	
				//}
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class LinkedBlockingDequeConsumer implements Runnable {

	protected BlockingDeque<String> blockingDeque;

	public LinkedBlockingDequeConsumer(BlockingDeque<String> queue) {
		this.blockingDeque = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				String first = blockingDeque.takeFirst();
				String last = blockingDeque.takeLast();
				System.out.println(Thread.currentThread().getName() + " takeFirst(): " + first + " takeLast():" + last);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}