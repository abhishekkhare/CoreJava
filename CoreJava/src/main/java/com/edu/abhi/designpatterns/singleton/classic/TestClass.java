package com.edu.abhi.designpatterns.singleton.classic;

public class TestClass {

	public static void main(String[] args) {
		//testBasic();
		//testThread();
		testThreadSafe();

	}

	

	private static void testThreadSafe() {
		MyRunnableThreadSafe r1 = new MyRunnableThreadSafe();
		MyRunnableThreadSafe r2 = new MyRunnableThreadSafe();
		
		Thread t1 = new Thread(r1,"1");
		Thread t2 = new Thread(r2,"2");
		
		t1.start();
		t2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Singleton = " + (r1.s.hashCode() == r2.s.hashCode()));
	}
		
	
	
	private static class MyRunnableThreadSafe implements Runnable{

		public SingletonThreadSafe s;
		@Override
		public void run() {
			s = SingletonThreadSafe.getInstance();
			
		}
	}

	private static class MyRunnable implements Runnable{

		public Singleton s;
		@Override
		public void run() {
			s = Singleton.getInstance();
			
		}
		
	}
	private static void testThread() {
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		
		Thread t1 = new Thread(r1,"1");
		Thread t2 = new Thread(r2,"2");
		
		t1.start();
		t2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Singleton = " + (r1.s.hashCode() == r2.s.hashCode()));
	}

	private static void testBasic() {
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println("Singleton = " + (s1.hashCode() == s2.hashCode()));
		
	}

}
