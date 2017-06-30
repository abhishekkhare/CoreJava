package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {
	public static void main(String[] args) throws Exception {

        BlockingQueue <String>queue = new ArrayBlockingQueue<String>(1024);

        ProducerA producer = new ProducerA(queue);
        ConsumerA consumer = new ConsumerA(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}

class ProducerA implements Runnable{

    protected BlockingQueue<String> queue = null;

    public ProducerA(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerA implements Runnable{

    protected BlockingQueue<String> queue = null;

    public ConsumerA(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
        	System.out.println(queue.element());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}