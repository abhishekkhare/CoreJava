package com.edu.abhi.concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiTaskExecutor {

	public static void main(String[] args) {
		BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
		RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandelerImpl();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MILLISECONDS, worksQueue, rejectionHandler);

		executor.prestartAllCoreThreads();

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		List<Runnable> taskGroup = new ArrayList<Runnable>();
		taskGroup.add(new TestOne());
		taskGroup.add(new TestTwo());
		taskGroup.add(new TestThree());

		worksQueue.add(new MultiRunnable(taskGroup));
		executor.shutdown();
		System.out.println("Done with Main");
	}
}

class RejectedExecutionHandelerImpl implements RejectedExecutionHandler {
	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		System.out.println(runnable.toString() + " : I've been rejected ! ");
	}
}