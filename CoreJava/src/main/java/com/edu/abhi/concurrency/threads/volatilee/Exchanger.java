package com.edu.abhi.concurrency.threads.volatilee;

public class Exchanger {
	private String object = "default";
	private volatile boolean hasNewObject = false;

	public void put(String newObject) {
		while (hasNewObject) {
			System.out.println("PUT::Waiting for volatile to be written::" + object);
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		object = newObject;
		System.out.println("PUT:volatile write1::" + object);
		hasNewObject = true; // volatile write
		System.out.println("PUT:volatile write2::" + object);
		

	}

	public Object take() {
		System.out.println("volatile read");
		while (!hasNewObject) { // volatile read
			System.out.println("TAKE::Waiting for volatile to be written::" + object);
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String obj = object;
		System.out.println("TAKE:volatile write1::" + object);
		hasNewObject = false; // volatile write
		System.out.println("TAKE:volatile write2::" + object);
		
		return obj;
	}
	
	public static void main(String [] args){
		Exchanger e = new Exchanger();
		Myrunnable1 r1 = new Myrunnable1(e);
		Myrunnable2 r2 = new Myrunnable2(e);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
	}

}

class Myrunnable1 implements Runnable {
	Exchanger e;

	Myrunnable1(Exchanger ee) {
		this.e = ee;
	}

	@Override
	public void run() {
		e.put("Test");
	}

}

class Myrunnable2 implements Runnable {
	Exchanger e;

	Myrunnable2(Exchanger ee) {
		this.e = ee;
	}

	@Override
	public void run() {
		System.out.println(e.take() + Thread.currentThread().getName());
	}

}