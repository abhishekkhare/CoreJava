package com.edu.abhi.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

	      // Cast the object to its class type
	      ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

	      //Stats before tasks execution
	      System.out.println("Largest executions: "
	         + pool.getLargestPoolSize());
	      System.out.println("Maximum allowed threads: "
	         + pool.getMaximumPoolSize());
	      System.out.println("Current threads in pool: "
	         + pool.getPoolSize());
	      System.out.println("Currently executing threads: "
	         + pool.getActiveCount());
	      System.out.println("Total number of threads(ever scheduled): "
	         + pool.getTaskCount());

	      executor.submit(new Task(1));
	      executor.submit(new Task(2));
	      executor.submit(new Task(3));
	      executor.submit(new Task(4));

	      //Stats after tasks execution
	      System.out.println("Core threads: " + pool.getCorePoolSize());
	      System.out.println("Largest executions: "
	         + pool.getLargestPoolSize());
	      System.out.println("Maximum allowed threads: "
	         + pool.getMaximumPoolSize());
	      System.out.println("Current threads in pool: "
	         + pool.getPoolSize());
	      System.out.println("Currently executing threads: "
	         + pool.getActiveCount());
	      System.out.println("Total number of threads(ever scheduled): "
	         + pool.getTaskCount());

	      executor.shutdown();
	}

	static class Task implements Runnable {
		int i;
		Task(int i){
			this.i =i;
		}
	      public void run() {
	         
	         try {
	            Long duration = (long) (Math.random() * 5);
	            System.out.println("Running Task! Thread Name: " +
	               Thread.currentThread().getName() + " --- " +i);
	               TimeUnit.SECONDS.sleep(duration);
	            
	            System.out.println("Task Completed! Thread Name: " +
	               Thread.currentThread().getName() + " --- " +i);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }
	   }

}
