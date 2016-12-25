package com.edu.abhi.concurrency.threads;

public class TestHoldsLock {
	private static String lockString = new String("LockString");

	public void method1() {
		System.out.println("Mehtod 1");
		synchronized (lockString) {
			System.out.println(Thread.currentThread().getName() + " : Aquired lock on lockString");
			System.out.println(Thread.currentThread().getName()+ " --- " + Thread.holdsLock(lockString));
			Thread.dumpStack();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : I am up");
		}
	}

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				TestHoldsLock dd = new TestHoldsLock();
				dd.method1();
			}
		};
		
		Thread t = new Thread(r1, "T1");
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.dumpStack();
		
		System.out.println(Thread.currentThread().getName()+ " --- " + Thread.holdsLock(lockString));
	}

}
