package com.edu.abhi.concurrency.inpractice.introduction1;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
	private int value;

	/** Returns a unique value. */
	public int getNext() {
		System.out.println(Thread.currentThread().getName() + " ** "+this.value);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value++;
	}

	public static void main(String[] args) {
		
		UnsafeSequence seq = new UnsafeSequence();
		UnsafeSequenceRunnable r1 = new UnsafeSequenceRunnable(seq);
		UnsafeSequenceRunnable r2 = new UnsafeSequenceRunnable(seq);
		UnsafeSequenceRunnable r3 = new UnsafeSequenceRunnable(seq);
		Thread t1 = new Thread(r1,"1");
		Thread t2 = new Thread(r2,"2");
		Thread t3 = new Thread(r3,"3");
		t1.start();
		t2.start();
		t3.start();
	}

}

class UnsafeSequenceRunnable implements Runnable{
	UnsafeSequence seq;
	UnsafeSequenceRunnable(UnsafeSequence seq){
		this.seq = seq;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " -- "+this.seq.getNext());
		}
		
	}
	
}