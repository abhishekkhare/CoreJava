package com.edu.abhi.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorUsage {

	private static ExecutorService executor = null;
	private static volatile Future<?> taskOneResults = null;
	private static volatile Future<?> taskTwoResults = null;

	public static void main(String[] args) {
		executor = Executors.newFixedThreadPool(2);
			try {
				checkTasks();
				Thread.sleep(1000);
				System.out.println("1 or 2 should be done by now");
				//this indicates that the same executor can be reused, same is not possible with threads, see the DemoThreadUsage
				if (taskTwoResults == null || taskTwoResults.isDone() || taskTwoResults.isCancelled()) {
					taskTwoResults = executor.submit(new TestThree());
				}
			} catch (Exception e) {
				System.err.println("Caught exception: " + e.getMessage());
			}

	}

	private static void checkTasks() throws Exception {
		if (taskOneResults == null || taskOneResults.isDone() || taskOneResults.isCancelled()) {
			taskOneResults = executor.submit(new TestOne());
		}

		if (taskTwoResults == null || taskTwoResults.isDone() || taskTwoResults.isCancelled()) {
			taskTwoResults = executor.submit(new TestTwo());
		}
		
		
	}
}

class TestOne implements Runnable {
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

class TestTwo implements Runnable {
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

class TestThree implements Runnable {
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
