package com.edu.abhi.concurrency.threads.synchronize;

public class ClassC extends ClassB{
	public synchronized void someMethod() throws InterruptedException {
		super.someMethod();
		System.out.println("ThreadC:" + Thread.currentThread().getName() + " - "+ Thread.currentThread().holdsLock(this));
		//Thread.currentThread().sleep(10);
	}

	public synchronized  static void someStaticMethod() throws InterruptedException {
		ClassB.someStaticMethod();
		//Thread.currentThread().sleep(10);
	}
}
