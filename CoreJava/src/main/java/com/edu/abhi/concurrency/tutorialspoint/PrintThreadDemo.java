package com.edu.abhi.concurrency.tutorialspoint;

class PrintDemo {
	public void printCount() {
		try {

			for (int i = 5; i > 0; i--) {
				System.out.println(Thread.currentThread().getName() + " --- Counter   ---   " + i);
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}
}

public class PrintThreadDemo extends Thread {
	private String threadName;
	PrintDemo PD;

	PrintThreadDemo(String name, PrintDemo pd) {
		threadName = name;
		PD = pd;
	}

	public void run() {
		//PD.printCount();
		synchronized (PD) {
			PD.printCount();
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

//	public void start() {
//		System.out.println("Starting " + threadName);
//		super.start();
//	}

	public static void main(String args[]) {
		PrintDemo PD = new PrintDemo();

		PrintThreadDemo T1 = new PrintThreadDemo("Thread - 1 ", PD);
		PrintThreadDemo T2 = new PrintThreadDemo("Thread - 2 ", PD);

		T1.start();
		T2.start();
		
		// wait for threads to end
		try {
			//Thread.sleep(1000);
			T1.join();
			System.out.println("join1");
			T2.join();
			System.out.println("join2");
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
		System.out.println("Main Thread Ending!!!");
	}
}