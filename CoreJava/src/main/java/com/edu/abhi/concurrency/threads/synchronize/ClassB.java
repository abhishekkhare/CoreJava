package com.edu.abhi.concurrency.threads.synchronize;

public class ClassB extends ClassA{
	public synchronized void someMethod() throws InterruptedException {
		super.someMethod();
		System.out.println("ThreadB:" + Thread.currentThread().getName() + " - "+ Thread.currentThread().holdsLock(this));
		//Thread.currentThread().sleep(10);
	}

	public synchronized  static void someStaticMethod() throws InterruptedException {
		ClassA.someStaticMethod();
		//Thread.currentThread().sleep(10);
	}
}
