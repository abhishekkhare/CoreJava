package com.edu.abhi.concurrency.inpractice.threadsafety2;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;


@NotThreadSafe
public class UnsafeCachingFactorizer implements Runnable {
	/**
	 * Not thread safe class because the state is dependent on 2 variables. Both are individually thread safe but not thread safe together. 
	 */
	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
	private final AtomicReference<BigInteger> lastFactors = new AtomicReference<BigInteger>();

	@Override
	public void run() {
		BigInteger i = BigInteger.probablePrime(5, new Random());
		lastNumber.set(i);
		for (int j = 0; j < 50000; j++) {

		}
		lastFactors.set(i);
	}

	public AtomicReference<BigInteger> getLastNumber() {
		return lastNumber;
	}

	public AtomicReference<BigInteger> getLastFactors() {
		return lastFactors;
	}

	
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
		testUnsafeCachingFactorizer();
	}
}
