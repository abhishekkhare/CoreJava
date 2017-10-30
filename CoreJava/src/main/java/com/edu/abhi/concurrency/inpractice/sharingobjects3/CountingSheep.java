package com.edu.abhi.concurrency.inpractice.sharingobjects3;

public class CountingSheep {
	volatile boolean asleep;

	void tryToSleep() {
		while (!asleep)
			countSomeSheep();
		System.out.println(Thread.currentThread().getName() + " -- "+asleep);
	}

	void countSomeSheep() {
		System.out.println(Thread.currentThread().getName() + " -- "+asleep);
	}



	public static void main(String[] args) throws InterruptedException {
		CountingSheep cs = new CountingSheep();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					cs.tryToSleep();
				}
			} , "Thread"+i).start();
			if(i==6)
				cs.asleep=true;
			Thread.sleep(2);
		}

	}

}
