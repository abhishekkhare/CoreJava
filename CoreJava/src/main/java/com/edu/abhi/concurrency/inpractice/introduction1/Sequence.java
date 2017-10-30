package com.edu.abhi.concurrency.inpractice.introduction1;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {
	private int value;

	/** Returns a unique value. */
	public synchronized int getNext() {
		System.out.println(Thread.currentThread().getName() + " ** "+this.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value++;
	}

	public static void main(String[] args) {
		
		Sequence seq = new Sequence();
		SequenceRunnable r1 = new SequenceRunnable(seq);
		SequenceRunnable r2 = new SequenceRunnable(seq);
		SequenceRunnable r3 = new SequenceRunnable(seq);
		Thread t1 = new Thread(r1,"1");
		Thread t2 = new Thread(r2,"2");
		Thread t3 = new Thread(r3,"3");
		t1.start();
		t2.start();
		t3.start();
	}

}

class SequenceRunnable implements Runnable{
	Sequence seq;
	SequenceRunnable(Sequence seq){
		this.seq = seq;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " -- "+this.seq.getNext());
		}
		
	}
	
}