package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import java.math.BigInteger;

import javax.servlet.ServletRequest;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class VolatileCachedFactorizer {
	private volatile OneValueCache cache = new OneValueCache(new BigInteger("4"),
			new BigInteger[] { new BigInteger("1"), new BigInteger("2") });

	public void service(BigInteger i) {
		BigInteger[] factors = cache.getFactors(i);
		if (factors == null) {
			factors = factor(i);
			cache = new OneValueCache(i, factors);
		}
		encodeIntoResponse(factors);
		System.out.println();
	}

	void encodeIntoResponse(BigInteger[] factors) {
		for (int i = 0; i < factors.length; i++) {
			System.out.print(factors[i] + ",");
		}
	}

	BigInteger extractFromRequest(ServletRequest req) {
		return new BigInteger("7");
	}

	BigInteger[] factor(BigInteger i) {
		// Doesn't really factor
		return new BigInteger[] { i };
	}

	public static void main(String[] args) {
		VolatileCachedFactorizer v = new VolatileCachedFactorizer();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int temp = (int)(Math.random()*10);
					if(temp%2==0)
						v.service(BigInteger.TEN);
					else
						v.service(BigInteger.ONE);
				}
			}).start();
		}
		v.service(new BigInteger("2"));
	}
}
