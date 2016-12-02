package com.edu.abhi.threads;

/**
 * 
 * @author abhishekkhare
 *
 */
public class TestInterrupt {

	public static void main(String[] args) {
		//interrupting a thread that doesn't stop working
		Thread t1 = new Thread(new InterruptRunnable1());
		t1.setName("Thread 1");
		t1.start();  
		t1.interrupt();
		System.out.println("1111111111111111111111111111111111");
		//interrupting thread that behaves normally
		Thread t2 = new Thread(new InterruptRunnable2());
		t2.setName("Thread 2");
		t2.start();  
		t2.interrupt();
		System.out.println("222222222222222222222222222222222");
		// interrupting a thread that stops working
		Thread t3 = new Thread(new InterruptRunnable3());
		t3.setName("Thread 3");
		t3.start();
		try {
			t3.interrupt();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("3333333333333333333333333333333333");
		//isInterrupted and interrupted method
		Thread t41=new Thread(new InterruptRunnable4());
		t41.setName("Thread 4-1");
		Thread t42=new Thread(new InterruptRunnable4());  
		t42.setName("Thread 4-2");
		
		t41.start();  
		t41.interrupt();  
		  
		t42.start();  
	}

}

class InterruptRunnable1 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Thread Started - " + Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("Thread Ended - " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("thread is running...");
	}
}

class InterruptRunnable2 implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread Started - " + Thread.currentThread().getName());
		for (int i = 1; i <= 5; i++)
			System.out.println(i);
		System.out.println("Thread Ended - " + Thread.currentThread().getName());
	}
}

class InterruptRunnable3 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Thread Started - " + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("Thread Ended - " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted..." + e);
		}
	}
}

class InterruptRunnable4 implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread Started - " + Thread.currentThread().getName());
		for (int i = 1; i <= 2; i++) {
			if (Thread.interrupted()) {
				System.out.println("code for interrupted thread"  + Thread.currentThread().getName());
			} else {
				System.out.println("code for normal thread"  + Thread.currentThread().getName());
			}
		} // end of for loop
		System.out.println("Thread Ended - " + Thread.currentThread().getName());
	}
}