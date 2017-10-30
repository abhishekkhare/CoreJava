package com.edu.abhi.concurrency.inpractice.threadsafety2;

public class Widget {
	protected String name;

	Widget(String name){
		this.name=name;
	}
	public synchronized void doSomething() {
		System.out.println(Thread.currentThread().getName() + " Super " + this.name);
	}
	
	public static void main(String [] args){
		LoggingWidget l = new LoggingWidget("Test");
		for (int i = 0; i < 10; i++) {
			
			Thread t = new Thread(new Runnable() {				
				@Override
				public void run() {
					l.doSomething();
					
				}
			},"" +i);
			t.start();
		}
	}
}

class LoggingWidget extends Widget {
	LoggingWidget(String name) {
		super(name);
		
	}

	public synchronized void doSomething() {
		System.out.println(Thread.currentThread().getName() + " Extended " + this.name);
		super.doSomething();
	}
}