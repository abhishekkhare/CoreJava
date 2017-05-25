package com.edu.abhi.concurrency.inpractice.threadsafety2;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class UnsafeCachingFactorizer implements Runnable{

	private final AtomicReference<BigInteger> lastNumber= new AtomicReference<BigInteger>();
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
	
	
}
