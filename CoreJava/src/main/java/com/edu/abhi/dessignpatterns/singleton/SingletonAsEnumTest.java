package com.edu.abhi.dessignpatterns.singleton;

public class SingletonAsEnumTest {

	public static void main(String [] args) throws InterruptedException{
		Runnable1 r1 = new Runnable1();
		Runnable1 r2 = new Runnable1();
		Runnable1 r3 = new Runnable1();
		Runnable1 r4 = new Runnable1();
		Thread t1 = new Thread(r1,"1");
		Thread t2 = new Thread(r2,"2");
		Thread t3 = new Thread(r3,"3");
		Thread t4 = new Thread(r4,"4");
		
		t1.start();
		Thread.sleep(1000);
		t3.start();
		Thread.sleep(1000);
		t4.start();
		Thread.sleep(1000);
		t2.start();
		
		
	}
	
	
	static class Runnable1 implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"- "+SingletonAsEnum.INSTANCE.getConnection());
			
		}
		
	}
}
