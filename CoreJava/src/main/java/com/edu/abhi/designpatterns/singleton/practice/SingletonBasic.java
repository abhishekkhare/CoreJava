package com.edu.abhi.designpatterns.singleton.practice;

public class SingletonBasic {

	private static SingletonBasic instance;

	private SingletonBasic() {

	}

	public static SingletonBasic getInstance() {
		if (instance == null) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("++ "+Thread.currentThread().getName());
			instance = new SingletonBasic();
		}
		return instance;
	}

	public static void main(String[] args) throws InterruptedException {
		TestRunnable t1 = new TestRunnable();
		TestRunnable t2 = new TestRunnable();
		Thread x1 = new Thread(t1,"T1");
		Thread x2 = new Thread(t2,"T2");
		x1.start();
		x2.start();
		x1.join();
		x2.join();
		
		System.out.println(t1.getA());
		System.out.println(t2.getA());
		
		if(t1.getA()==t2.getA())
			System.out.println("TRUE");
		System.out.println("DONE");
	}
}

class TestRunnable implements Runnable {
	SingletonBasic a;

	@Override
	public void run() {
		a = SingletonBasic.getInstance();
	}

	public SingletonBasic getA() {
		return a;
	}
}