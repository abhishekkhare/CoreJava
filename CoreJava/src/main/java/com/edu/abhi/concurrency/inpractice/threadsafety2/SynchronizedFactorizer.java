package com.edu.abhi.concurrency.inpractice.threadsafety2;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import com.edu.abhi.concurrency.inpractice.GuardedBy;

public class SynchronizedFactorizer implements Runnable{

	@GuardedBy("this") private final AtomicReference<BigInteger> lastNumber= new AtomicReference<BigInteger>();
	@GuardedBy("this") private final AtomicReference<BigInteger> lastFactors = new AtomicReference<BigInteger>();
	@Override
	public void run() {
		BigInteger i = BigInteger.probablePrime(5, new Random());
		synchronized (this) {
			System.out.println("Lock with:" + Thread.currentThread().getName());
			lastNumber.set(i);
			for (int j = 0; j < 50000; j++) {
				
			}
			lastFactors.set(i);	
			System.out.println("Lock released by :" + Thread.currentThread().getName());
		}
		
	}

	public AtomicReference<BigInteger> getLastNumber() {
		synchronized (this) {
			System.out.println("LockL with:" + Thread.currentThread().getName());
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return lastNumber;	
		}
		
	}

	public AtomicReference<BigInteger> getLastFactors() {
		synchronized (this) {
			System.out.println("LockLF with:" + Thread.currentThread().getName());
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return lastFactors;	
		}
		
	}
	
	
}
