package com.edu.abhi.concurrency.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorBasic {

	public static void main(final String[] arguments) throws InterruptedException {
		simpleCase();
		awaitCase();
		periodicCase();
	}

	private static void periodicCase() {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final ScheduledFuture<?> beepHandler = scheduler.scheduleAtFixedRate(new BeepTask(), 2, 1, TimeUnit.SECONDS);

		scheduler.schedule(new Runnable() {

			@Override
			public void run() {
				beepHandler.cancel(true);
				scheduler.shutdown();
			}
		}, 10, TimeUnit.SECONDS);

	}

	private static void awaitCase() {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		try {
			executor.submit(new Task());
			System.out.println("Shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {

			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}

	}

	private static void simpleCase() {
		Executor executor = Executors.newCachedThreadPool();
		executor.execute(new Task());
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
		pool.shutdown();
	}

	static class Task implements Runnable {
		public void run() {

			try {
				Long duration = (long) (Math.random() * 20);
				// Long duration = (long) (Math.random() * 5*10000);
				System.out.println("Running Task! for " + duration / 1000 + " seconds");
				TimeUnit.SECONDS.sleep(duration);
				System.out.println("Task Completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class BeepTask implements Runnable {
		public void run() {
			System.out.println("beep");
		}
	}
}
