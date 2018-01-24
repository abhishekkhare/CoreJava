package com.edu.abhi.concurrency.inpractice.threadsafety2;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.Random;
@ThreadSafe
public class StatelessFactorizer implements Runnable{
	public void service(BigInteger i) {
		Float f = i.floatValue();
		System.out.println(Thread.currentThread().getName() + " -- " +f);
	}

	@Override
	public void run() {
		service(BigInteger.probablePrime(5, new Random()));
		
	}
	
	private static void testStatelessFactorizer() {
		StatelessFactorizer object = new StatelessFactorizer();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(object,"Thread"+i);
			t.start();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		testStatelessFactorizer();
	}
}
