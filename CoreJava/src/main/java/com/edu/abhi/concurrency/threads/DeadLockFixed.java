package com.edu.abhi.concurrency.threads;

public class DeadLockFixed {
	/**
	 * * Both method are now requesting lock in same order, first Integer and
	 * then String. * You could have also done reverse e.g. first String and
	 * then Integer, * both will solve the problem, as long as both method are
	 * requesting lock * in consistent order.
	 */

	public void method1() {
		System.out.println("Mehtod 1");
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " : Aquired lock on String.class object");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : I am up");
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " : Aquired lock on Integer.class object");
			}
		}
	}

	public void method2() {
		System.out.println("Mehtod 2");
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName()
					+ " : Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName()+ " : Aquired lock on Integer.class object");
			}
		}
	}

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				DeadLockFixed dd = new DeadLockFixed();
				dd.method1();
			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				DeadLockFixed dd = new DeadLockFixed();
				dd.method2();
			}
		};

		new Thread(r1, "T1").start();
		new Thread(r2, "T2").start();

	}
}
