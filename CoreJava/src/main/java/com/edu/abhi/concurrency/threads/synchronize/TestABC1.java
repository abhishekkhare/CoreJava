package com.edu.abhi.concurrency.threads.synchronize;

public class TestABC1 {
	public static void main(String[] args) {
		ClassC c = new ClassC();
		for (int i = 0; i < 4; i++) {
			Myrunnable1 r = new Myrunnable1(c);
			Thread t = new Thread(r,i+"");
			t.start();
		}
	}

}

class Myrunnable1 implements Runnable{
	ClassC c;
	Myrunnable1(ClassC cc){
		this.c = cc;
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