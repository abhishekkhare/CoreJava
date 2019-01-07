package com.edu.abhi.concurrency.executors.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExecutorCallableSample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Future<String>> list =  new ArrayList<Future<String>>();
		List<Callable<String>> callables = new ArrayList<Callable<String>>();
		for (int i = 0; i < 10; i++) {
			CallableTask2 task = new CallableTask2(i+"");
			callables.add(task);			
		}
		
		
		list = executor.invokeAll(callables);
		
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

class CallableTask2 implements Callable<String> {
	private String name;
	CallableTask2(String name){
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