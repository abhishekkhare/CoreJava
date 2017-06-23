package com.edu.abhi.concurrency.threads.synchronize;

public class TestABC {

	
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			Myrunnable r = new Myrunnable();
			Thread t = new Thread(r,i+"");
			t.start();
		}
	}

}

class Myrunnable implements Runnable{
	ClassC c = new ClassC();
	
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