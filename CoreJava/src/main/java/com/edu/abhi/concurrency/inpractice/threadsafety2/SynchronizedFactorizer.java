package com.edu.abhi.concurrency.inpractice.threadsafety2;

import com.edu.abhi.concurrency.inpractice.annotations.GuardedBy;
import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class SynchronizedFactorizer implements Runnable{

	@GuardedBy("this") private final AtomicReference<BigInteger> lastNumber= new AtomicReference<BigInteger>();
	@GuardedBy("this") private final AtomicReference<BigInteger> lastFactors = new AtomicReference<BigInteger>();
	@Override
	public void run() {
		BigInteger i = BigInteger.probablePrime(5, new Random());
		synchronized (this) {
			//System.out.println("Lock with:" + Thread.currentThread().getName());
			lastNumber.set(i);
			for (int j = 0; j < 50000; j++) {
				
			}
			lastFactors.set(i);	
			//System.out.println("Lock released by :" + Thread.currentThread().getName());
		}
		
	}

	public AtomicReference<BigInteger> getLastNumber() {
		synchronized (this) {
			//System.out.println("LockL with:" + Thread.currentThread().getName());
//			try {
//				Thread.sleep(2);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			return lastNumber;	
		}
		
	}

	public AtomicReference<BigInteger> getLastFactors() {
		synchronized (this) {
			//System.out.println("LockLF with:" + Thread.currentThread().getName());
//			try {
//				Thread.sleep(2);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			return lastFactors;	
		}
		
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
			AtomicReference<BigInteger> lastNumberTemp =object.getLastFactors();
			AtomicReference<BigInteger> lastFactorsTemp = 	object.getLastNumber();
			if(lastNumberTemp !=null && lastFactorsTemp!=null){
				if(lastFactorsTemp.get() !=null && lastNumberTemp.get()!=null){
					System.out.println(lastFactorsTemp.get() + " -- " +lastNumberTemp.get()+ " BB " + lastFactorsTemp.get().equals(lastNumberTemp.get()));	
				}
			} 
		}		
	}
	
	public static void main(String[] args) throws InterruptedException {
		testSynchronizedFactorizer();
	}
	
}
