package com.edu.abhi.threads;

public class ThreadLocalExample {

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
			@Override protected Integer initialValue() {
		        return 10;
		    }
		};

		@Override
		public void run() {
			threadLocal.set(threadLocal.get() * 100);
			System.out.println("Before"+threadLocal.get());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("After" +threadLocal.get());
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}