package com.edu.abhi.concurrency.inpractice.threadsafety2;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;
import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		//testStatelessFactorizer();
		//testUnsafeCountingFactorizer();
		//testCountingFactorizer();
		//testLazyInitRace();
		//testUnsafeCachingFactorizer();
		testSynchronizedFactorizer();
	}

	/**
	 * Notice in this example, unless we make sure that the Thread-0 has the lock in the object for both getLastFactors and getLastNumber the values read might be different.
	 * This is an important example, try following options:
	 * 1 - Make SynchronizedFactorizer completely unsynchronized as see how the result changes
	 * 2 - make only the run block synchronized.
	 * 3 - make run and the methods synchronized 
	 * 4 - add sleep to the synchronized get methods. 
	 */
	@ThreadSafe
	private static void testSynchronizedFactorizer() {
		SynchronizedFactorizer object = new SynchronizedFactorizer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() +"**"+ i+"**"+object.getLastFactors() + "  " + object.getLastNumber());
							
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			}
		}).start();
		for (int i = 1; i <= 100; i++) {
			Thread t = new Thread(object,"Thread"+i);
			t.start();
			//System.out.println(t.getName() +"::"+object.getLastFactors() + "  " + object.getLastNumber());
		}
	
		
	}

	@NotThreadSafe
	private static void testUnsafeCachingFactorizer() throws InterruptedException {
		UnsafeCachingFactorizer object = new UnsafeCachingFactorizer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() +"**"+ i+"**"+object.getLastFactors() + "  " + object.getLastNumber());	
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			}
		}).start();
		for (int i = 1; i <= 100; i++) {
			Thread t = new Thread(object,"Thread"+i);
			t.start();
			System.out.println(t.getName() +"::"+object.getLastFactors() + "  " + object.getLastNumber());
		}
	}


	@NotThreadSafe
	private static void testLazyInitRace() throws InterruptedException {
		LazyInitRace object = new LazyInitRace();
		for (int i = 1; i <= 10; i++) {
			Thread t = new Thread(object,"Thread"+i);
			Thread.sleep(4);
			t.start();
		}
		
	}

	@NotThreadSafe
	private static void testUnsafeCountingFactorizer() throws InterruptedException {
		UnsafeCountingFactorizer object = new UnsafeCountingFactorizer();
		for (int i = 1; i <= 100; i++) {
			Thread t = new Thread(object,"Thread"+i);
			t.start();
			t.join();
		}
		System.out.println("Object Count::" + object.getCount());		
	}
	
	@ThreadSafe
	private static void testCountingFactorizer() throws InterruptedException {
		CountingFactorizer object = new CountingFactorizer();
		for (int i = 1; i <= 100; i++) {
			Thread t = new Thread(object,"Thread"+i);
			t.start();
			t.join();
		}
		System.out.println("Object Count::" + object.getCount());
		
	}
	
	@ThreadSafe
	private static void testStatelessFactorizer() {
		StatelessFactorizer object = new StatelessFactorizer();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(object,"Thread"+i);
			t.start();
		}
		
	}

}
