package com.edu.abhi.concurrency.inpractice.threadsafety2;

import java.math.BigInteger;
import java.util.Random;

public class StatelessFactorizer implements Runnable{
	public void service(BigInteger i) {
		Float f = i.floatValue();
		System.out.println(f);
	}

	@Override
	public void run() {
		service(BigInteger.probablePrime(5, new Random()));
		
	}
}
