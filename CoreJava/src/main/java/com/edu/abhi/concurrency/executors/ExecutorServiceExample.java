package com.edu.abhi.concurrency.executors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * When you are done using the ExecutorService you should shut it down, so the
 * threads do not keep running.
 * 
 * For instance, if your application is started via a main() method and your
 * main thread exits your application, the application will keep running if you
 * have an active ExexutorService in your application. The active threads inside
 * this ExecutorService prevents the JVM from shutting down.
 * 
 * To terminate the threads inside the ExecutorService you call its shutdown()
 * method. The ExecutorService will not shut down immediately, but it will no
 * longer accept new tasks, and once all threads have finished current tasks,
 * the ExecutorService shuts down. All tasks submitted to the ExecutorService
 * before shutdown() is called, are executed.
 * 
 * If you want to shut down the ExecutorService immediately, you can call the
 * shutdownNow() method. This will attempt to stop all executing tasks right
 * away, and skips all submitted but non-processed tasks. There are no
 * guarantees given about the executing tasks. Perhaps they stop, perhaps the
 * execute until the end. It is a best effort attempt.
 * 
 * @author abhishekkhare
 *
 */
public class ExecutorServiceExample {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		// execute();
		// submit();
		// submitC();
		// invokeAny();
		invokeAll();

	}

	/**
	 * The invokeAll() method invokes all of the Callable objects you pass to it
	 * in the collection passed as parameter. The invokeAll() returns a list of
	 * Future objects via which you can obtain the results of the executions of
	 * each Callable.
	 * 
	 * Keep in mind that a task might finish due to an exception, so it may not
	 * have "succeeded". There is no way on a Future to tell the difference
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static void invokeAll() throws InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Set<CallableTask> taskSet = new HashSet<CallableTask>();
		for (int i = 0; i < 100; i++) {
			System.out.println("Adding task " + i);
			taskSet.add(new CallableTask(i));
		}
		List<Future<String>> futures = service.invokeAll(taskSet);
		boolean flag = true;
		while (flag) {
			flag = false;
			for (Future<String> future : futures) {
				if (!future.isDone()) {
					flag = true;
				} else {
					try {
						System.out.println(future.get());
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
			Thread.sleep(100);
		}
		System.out.println("DONE DONE DONE");
		service.shutdown();

	}

	/**
	 * The invokeAny() method takes a collection of Callable objects, or
	 * subinterfaces of Callable. Invoking this method does not return a Future,
	 * but returns the result of one of the Callable objects. You have no
	 * guarantee about which of the Callable's results you get. Just one of the
	 * ones that finish.
	 * 
	 * If one of the tasks complete (or throws an exception), the rest of the
	 * Callable's are cancelled.
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static void invokeAny() throws InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();

		Set<CallableTask> taskSet = new HashSet<CallableTask>();
		for (int i = 0; i < 100; i++) {
			System.out.println("Adding task " + i);
			taskSet.add(new CallableTask(i));
		}
		String result = "";
		try {
			result = service.invokeAny(taskSet);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		System.out.println("DONE DONE DONE");
		service.shutdown();
	}

	/**
	 * The submit(Callable) method is similar to the submit(Runnable) method
	 * except for the type of parameter it takes. The Callable instance is very
	 * similar to a Runnable except that its call() method can return a result.
	 * The Runnable.run() method cannot return a result. The Callable's result
	 * can be obtained via the Future object returned by the submit(Callable)
	 * method.
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static void submitC() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future[] futures = new Future[100];
		for (int i = 0; i < 100; i++) {
			System.out.println("Submitting task " + i);
			futures[i] = service.submit(new CallableTask(i));
		}
		boolean flag = true;
		while (flag) {
			flag = false;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < futures.length; i++) {
				if (!futures[i].isDone()) {
					sb.append(i + ",");
					flag = true;
				} else {
					try {
						System.out.println(futures[i].get());
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(sb + " task is pending");
			Thread.sleep(100);
		}
		System.out.println("DONE DONE DONE");
		service.shutdown();
	}

	/**
	 * The submit(Runnable) method also takes a Runnable implementation, but
	 * returns a Future object. This Future object can be used to check if the
	 * Runnable as finished executing.
	 * 
	 * @throws InterruptedException
	 */
	private static void submit() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future[] futures = new Future[100];
		for (int i = 0; i < 100; i++) {
			System.out.println("Submitting task " + i);
			futures[i] = service.submit(new Task(i));
		}
		boolean flag = true;
		while (flag) {
			flag = false;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < futures.length; i++) {
				if (!futures[i].isDone()) {
					sb.append(i + ",");
					flag = true;
				}
			}
			System.out.println(sb + " task is pending");
			Thread.sleep(100);
		}
		System.out.println("DONE DONE DONE");
		service.shutdown();
	}

	/**
	 * The execute(Runnable) method takes a java.lang.Runnable object, and
	 * executes it asynchronously.
	 * 
	 * @throws InterruptedException
	 */
	private static void execute() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			System.out.println("Submitting task " + i);
			service.execute(new Task(i));
		}
		System.out.println("DONE DONE DONE");
		service.shutdown();
	}

}

final class Task implements Runnable {
	private int taskId;

	public Task(int id) {
		this.taskId = id;
	}

	@Override
	public void run() {
		System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

final class CallableTask implements Callable<String> {
	private int taskId;

	public CallableTask(int id) {
		this.taskId = id;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		if (this.taskId == 97)
			throw new RuntimeException("Sending Exception");
		return "Task " + this.taskId + " has completed";
	}

}
