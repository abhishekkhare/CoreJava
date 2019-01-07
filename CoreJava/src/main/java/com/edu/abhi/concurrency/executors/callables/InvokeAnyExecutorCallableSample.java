package com.edu.abhi.concurrency.executors.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyExecutorCallableSample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> callables = new ArrayList<Callable<String>>();
		for (int i = 0; i < 10; i++) {
			CallableTask3 task = new CallableTask3(i+"");
			callables.add(task);			
		}
		
		
		try {
			String temp = executor.invokeAny(callables);
			System.out.println(temp);
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Done with Main");
		executor.shutdown();
	}
}

class CallableTask3 implements Callable<String> {
	private String name;
	CallableTask3(String name){
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