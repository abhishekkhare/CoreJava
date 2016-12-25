package com.edu.abhi.concurrency.executors;
/**
 * Does the same job, but two problems, 
 * 1. it cannot implement the runnable class and have same Thread class use different runnable.
 * 2. Extending the thread object we can achieve the same result, however each task would need its own thread object, in case of Executioner, it could be reused. 
 * @author abhishekkhare
 *
 */
public class DemoThreadUsage {
	public static void main(String[] args) {
			try {
				checkTasks();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("Caught exception: " + e.getMessage());
			}

	}

	private static void checkTasks() throws Exception {
		TestOne1 t1 = new TestOne1();
		t1.start();
		
		
		TestTwo2 t2 = new TestTwo2();
		t2.start();
		
		TestThree3 t3 = new TestThree3();
		t3.start();
	}
}

class TestOne1 extends Thread {
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("Executing task one:"+i);
			try {
				Thread.sleep(10);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}

class TestTwo2 extends Thread {
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Executing task two"+i);
			try {
				Thread.sleep(10);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}

class TestThree3 extends Thread {
	public void run() {
		for (int i = 0; i < 25; i++) {
			System.out.println("Executing task three"+i);
			try {
				Thread.sleep(100);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
