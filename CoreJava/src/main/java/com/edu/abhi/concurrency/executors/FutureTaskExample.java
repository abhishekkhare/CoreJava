package com.edu.abhi.concurrency.executors;

import java.util.concurrent.*;

public class FutureTaskExample {

	public static void main(String[] args) {
		MyFutureCallable callable1 = new MyFutureCallable(3000);
		MyFutureCallable callable2 = new MyFutureCallable(5000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		
		while (true) {
			try {
				if(futureTask1.isDone() && futureTask2.isDone()){
					System.out.println("Done");
					//shut down executor service
					executor.shutdown();
					return;
				}
				
				if(!futureTask1.isDone()){
					System.out.println("wait indefinitely for future task to complete");
					System.out.println("FutureTask1 output="+futureTask1.get());
				}
				
				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
				if(s !=null){
					System.out.println("FutureTask2 output="+s);
				}
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}catch(TimeoutException e){
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		}
		
	}

}

class MyFutureCallable  implements Callable<String> {

	private long waitTime;
	
	public MyFutureCallable(int timeInMillis){
		this.waitTime=timeInMillis;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName() + " --- "+waitTime;
	}
}


