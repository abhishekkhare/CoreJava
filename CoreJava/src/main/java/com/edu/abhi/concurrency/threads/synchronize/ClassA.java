package com.edu.abhi.concurrency.threads.synchronize;

public class ClassA {

	public synchronized void someMethod() throws InterruptedException {
		Thread.currentThread();
		System.out.println("ThreadA:" + Thread.currentThread().getName() + " - "+ Thread.holdsLock(this) + " - " +this);
		
		//Thread.currentThread().sleep(10);
	}

	public synchronized  static void someStaticMethod() throws InterruptedException {
		Thread.currentThread();
		System.out.println("ThreadSAA:" + Thread.currentThread().getName() + " - "+ Thread.holdsLock(ClassA.class));
		System.out.println("ThreadSAB:" + Thread.currentThread().getName() + " - "+ Thread.holdsLock(ClassB.class));
		System.out.println("ThreadSAC:" + Thread.currentThread().getName() + " - "+ Thread.holdsLock(ClassC.class));
		//Thread.currentThread().sleep(10);
	}
}
