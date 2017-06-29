package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueA {

	private List<Object> queue = new LinkedList<Object>();
	private int limit = 10;

	public BlockingQueueA(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		System.out.println("EN:" + item + " Queue Size" + this.queue.size());
		//Thread.sleep(1000);
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		Object temp  = this.queue.remove(0);
		
		System.out.println("DQ:" +temp + " Queue Size" + this.queue.size());
		return temp;
	}

	public static void main(String [] args){
		BlockingQueueA b = new BlockingQueueA(20);
		for (int i = 0; i < 100; i++) {
			EnqueueRunnable e = new EnqueueRunnable(b,""+i);
			DqueueRunnable d = new DqueueRunnable(b);
			Thread t1 = new Thread(e);
			Thread t2 = new Thread(d);
			t1.start();
			t2.start();
		}
	}
}


class EnqueueRunnable implements Runnable{
	BlockingQueueA b;
	Object o;
	
	public EnqueueRunnable(BlockingQueueA b,Object o){
		this.b=b;
		this.o=o;
	}
	@Override
	public void run() {
		try {
			//Thread.sleep(1000);
			b.enqueue(o);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class DqueueRunnable implements Runnable{
	BlockingQueueA b;
	public DqueueRunnable(BlockingQueueA b){
		this.b=b;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
			b.dequeue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}