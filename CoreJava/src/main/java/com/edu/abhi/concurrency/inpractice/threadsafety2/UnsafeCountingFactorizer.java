package com.edu.abhi.concurrency.inpractice.threadsafety2;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeCountingFactorizer {
	private long count = 0;

	public long getCount() {
		return count;
	}

	public void run() {
		//synchronized (this) {// if we make the block synchronized the answer is same every time otherwise it changes with each execution.xw 
			for (int i = 0; i < 20; i++) {
				if(i%10==0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				++count;	
			}	
		//}
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		UnsafeCountingFactorizer seq = new UnsafeCountingFactorizer();
		UnsafeCountingFactorizerRunnable r1 = new UnsafeCountingFactorizerRunnable(seq);
		UnsafeCountingFactorizerRunnable r2 = new UnsafeCountingFactorizerRunnable(seq);
		UnsafeCountingFactorizerRunnable r3 = new UnsafeCountingFactorizerRunnable(seq);
		Thread t1 = new Thread(r1, "1");
		Thread t2 = new Thread(r2, "2");
		Thread t3 = new Thread(r3, "3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println(Thread.currentThread().getName() + " - " + seq.getCount());
	}

}

class UnsafeCountingFactorizerRunnable implements Runnable {
	UnsafeCountingFactorizer obj;

	UnsafeCountingFactorizerRunnable(UnsafeCountingFactorizer obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		this.obj.run();
		System.out.println(Thread.currentThread().getName() + " - " + this.obj.getCount());

	}

}