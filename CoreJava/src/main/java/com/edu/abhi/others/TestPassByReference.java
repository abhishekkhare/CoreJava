package com.edu.abhi.others;

public class TestPassByReference {

	PassByReference ps = new PassByReference("Abhi",11);
	Runnable1 r1 = new Runnable1();
	Runnable2 r2 = new Runnable2();
	public static void main(String[] args) {
		TestPassByReference tt = new TestPassByReference();
		
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(tt.r1);
			Thread t2 = new Thread(tt.r2);
			t1.start();
			t2.start();
		}

	}

	class Runnable1 implements Runnable{

		@Override
		public void run() {
			POJO pojo =ps.getPojo(); 
			pojo.setName("Hello");
			pojo.setId(1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1" + pojo.getName() + " " +pojo.getId());
		}
		
	}
	
	class Runnable2 implements Runnable{

		@Override
		public void run() {
			POJO pojo =ps.getPojo(); 
			pojo.setName("Hi");
			pojo.setId(2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2" + pojo.getName() + " " +pojo.getId());
		}
		
	}
}

