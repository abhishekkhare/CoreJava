package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import com.edu.abhi.concurrency.inpractice.annotations.GuardedBy;
import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedInteger {
	@GuardedBy("this") private int value;

	public synchronized int get() {
		System.out.println(Thread.currentThread().getName() +"y="+value);
		return value;
	}

	public synchronized void set(int value) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value = value;
		System.out.println(Thread.currentThread().getName()+"x="+get());
	}
	
	public static void main(String [] args){
		SynchronizedInteger object = new SynchronizedInteger();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int x = (int)(Math.random()*10);
					object.set(x);
					
				}
			},"SET"+i).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					object.get();
					
				}
			},"GET"+i).start();
		}
		System.out.println("Final Value::" + object.get());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final Value::::" + object.get());
	}
}


