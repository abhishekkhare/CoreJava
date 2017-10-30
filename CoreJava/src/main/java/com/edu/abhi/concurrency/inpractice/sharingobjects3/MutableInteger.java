package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class MutableInteger {
	private int value;

	public int get() {
		System.out.println(Thread.currentThread().getName() +"y="+value);
		return value;
	}

	public void set(int value) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value = value;
		System.out.println(Thread.currentThread().getName()+"x="+get());
	}
	
	public static void main(String [] args){
		MutableInteger object = new MutableInteger();
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
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final Value::::" + object.get());
	}
}


