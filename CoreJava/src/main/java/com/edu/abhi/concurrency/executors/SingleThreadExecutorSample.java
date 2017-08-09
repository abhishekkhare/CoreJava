package com.edu.abhi.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutorSample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			RunnableTask task = new RunnableTask(i+"");
			executor.submit(task);			
		}
		System.out.println("Done with Main");
		
		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(4, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    System.out.println("shutdown finished");
		}
	}
}

class RunnableTask implements Runnable {
	private String name;
	RunnableTask(String name){
		this.name =name;
	}
	public void run() {
		String threadName = Thread.currentThread().getName();
	    System.out.println("Start " + name + " --- "+ threadName);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("End " + name + " --- "+ threadName);
	}
}