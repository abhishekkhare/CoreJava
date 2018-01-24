package com.edu.abhi.concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SingleThreadExecutorCallableSample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<Future<String>> list =  new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			CallableTask1 task = new CallableTask1(i+"");
			list.add(executor.submit(task));			
		}
		
		for (Future<String> future : list) {
			while(!future.isDone()){
				Thread.sleep(1000);
			}
			
			try {
				System.out.println("Future::" +future.get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Done with Main");
		executor.shutdown();
	}
}

class CallableTask1 implements Callable<String> {
	private String name;
	CallableTask1(String name){
		this.name =name;
	}

	@Override
	public String call() throws Exception {
		String threadName = Thread.currentThread().getName();
	    System.out.println("Start " + name + " --- "+ threadName);
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("End " + name + " --- "+ threadName);
	    
	    return "Thread " + name + " completed.";
	}
}