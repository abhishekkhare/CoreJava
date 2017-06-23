package com.edu.abhi.concurrency.threads.threadlocal;

public class ThreadLocalExample {

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
			@Override protected Integer initialValue() {
		        return 10;
		    }
		};
		Integer notLocal = 10;

		@Override
		public void run() {
			notLocal=notLocal*100;
			threadLocal.set(threadLocal.get() * 100);
			System.out.println("Before::" + Thread.currentThread().getName() + " - "+threadLocal.get() + " :: "+notLocal);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("After::"  + Thread.currentThread().getName() + "  - "+threadLocal.get() + " :: "+notLocal);
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance,"1");
		Thread thread2 = new Thread(sharedRunnableInstance,"2");

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}