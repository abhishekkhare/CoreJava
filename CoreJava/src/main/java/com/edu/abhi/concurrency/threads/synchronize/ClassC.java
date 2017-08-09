package com.edu.abhi.concurrency.threads.synchronize;

public class ClassC extends ClassB{
	private String name;
	public synchronized void someMethod() throws InterruptedException {
		super.someMethod();
		Thread.currentThread();
		System.out.println("ThreadC:" + Thread.currentThread().getName() + " - "+ Thread.holdsLock(this) + " - " +this);
		Thread.currentThread();
		Thread.sleep(10);
	}

	public synchronized  static void someStaticMethod() throws InterruptedException {
		ClassB.someStaticMethod();
		//Thread.currentThread().sleep(10);
	}

	public ClassC(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassC [name=" + name + "]";
	}
}
