package com.edu.abhi.threads;

public class DeadLockDemo {
	/**
	 * * This method request two locks, first String and then Integer
	 */
	public void method1() {
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName()+" : Aquired lock on String.class object");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" : I am up");
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName()+" : Aquired lock on Integer.class object");
			}
		}
	}

	/**
	 * * This method also requests same two lock but in exactly * Opposite order
	 * i.e. first Integer and then String. * This creates potential deadlock, if
	 * one thread holds String lock * and other holds Integer lock and they wait
	 * for each other, forever.
	 */

	public void method2() {
		synchronized (Integer.class) {
			System.out.println(Thread.currentThread().getName()+" : Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName()+" : Aquired lock on String.class object");
			}
		}
	}

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				DeadLockDemo dd = new DeadLockDemo();
				dd.method1();
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				DeadLockDemo dd = new DeadLockDemo();
				dd.method2();
			}
		};
		
		new Thread(r1,"T1").start();
		new Thread(r2,"T2").start();
		
	}
}
