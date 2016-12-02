package com.edu.abhi.threads;

public class TestSleepWithLock {
	public void method1() {
		System.out.println("Mehtod 1");
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " : Aquired lock on String.class object");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : I am up");
		}
		synchronized (Integer.class) {
			System.out.println(Thread.currentThread().getName() + " : Aquired lock on Integer.class object");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : I am up");
		}
	}

	public void method2() {
		System.out.println("Mehtod 2");
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " : Aquired lock on String.class object");
		}
	}

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				TestSleepWithLock dd = new TestSleepWithLock();
				dd.method1();
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				TestSleepWithLock dd = new TestSleepWithLock();
				dd.method2();
			}
		};

		new Thread(r1, "T1").start();
		new Thread(r2, "T2").start();
		System.out.println(
				"Notice that T1 goes to sleep with the String lock, as soon as T1 releases the String lock, T2 can continue, it does not need to wait for T1 to complete");
	}
}
