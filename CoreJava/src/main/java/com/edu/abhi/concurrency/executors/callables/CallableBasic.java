package com.edu.abhi.concurrency.executors.callables;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableBasic {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// execution1();
		execution2();

	}

	private static void execution2() throws InterruptedException, ExecutionException {
		// ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor = Executors.newCachedThreadPool();

		Map<String, Future<Long>> resultMap = new ConcurrentHashMap<String, Future<Long>>();
		System.out.println("Factorial Service called for 10!");
		Future<Long> result = executor.submit(new FactorialService(10));
		resultMap.put("10", result);

		System.out.println("Factorial Service called for 2!");
		result = executor.submit(new FactorialService(5));
		resultMap.put("2", result);
		System.out.println("Factorial Service called for 20!");
		result = executor.submit(new FactorialService(20));
		resultMap.put("20", result);

		System.out.println("Wating for Result");
		while (true) {
			Set<String> keySet = resultMap.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
				String key = iterator.next();
				Future<Long> future = resultMap.get(key);
				if (future.isDone()) {
					System.out.println(key + "!=" + future.get());
					resultMap.remove(key);
				}
			}
			if (resultMap.isEmpty()) {
				break;
			}
		}

		System.out.println("DONE");

	}

	private static void execution1() throws InterruptedException, ExecutionException {
		// ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor = Executors.newCachedThreadPool();

		System.out.println("Factorial Service called for 10!");
		Future<Long> result10 = executor.submit(new FactorialService(10));

		System.out.println("Factorial Service called for 2!");
		Future<Long> result2 = executor.submit(new FactorialService(5));

		System.out.println("Factorial Service called for 20!");
		Future<Long> result20 = executor.submit(new FactorialService(20));

		System.out.println("Wating for Result of 10!");
		Long factorial10 = result10.get();
		System.out.println("10! = " + factorial10);

		System.out.println("Wating for Result of 20!");
		Long factorial20 = result20.get();
		System.out.println("20! = " + factorial20);
		System.out.println("Wating for Result of 2!");
		Long factorial2 = result2.get();
		System.out.println("2! = " + factorial2);
		executor.shutdown();
		System.out.println("DONE");

	}

	static class FactorialService implements Callable<Long> {
		private int number;
		private int threadNumber;

		public FactorialService(int number) {
			this.number = number;
			this.threadNumber = number;
		}

		@Override
		public Long call() throws Exception {
			return factorial();
		}

		private Long factorial() throws InterruptedException {
			long result = 1;

			while (number != 0) {
				System.out.println("Thread Wroking ::" + threadNumber);
				result = number * result;
				number--;
				Thread.sleep(500);
			}
			System.out.println("****Thread Done**** " + threadNumber);
			return result;
		}
	}
}
