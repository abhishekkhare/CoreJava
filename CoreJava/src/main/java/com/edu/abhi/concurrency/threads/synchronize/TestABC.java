package com.edu.abhi.concurrency.threads.synchronize;

public class TestABC {

	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			Myrunnable r = new Myrunnable(i+"");
			Thread t = new Thread(r,i+"");
			t.start();
			//Thread.sleep(1000);
		}
	}

}

class Myrunnable implements Runnable{
	ClassC c =null;
	
	
	
	public Myrunnable(String name) {
		c = new ClassC(name);
	}



	@Override
	public void run() {
		try {
			c.someMethod();			
			ClassC.someStaticMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}