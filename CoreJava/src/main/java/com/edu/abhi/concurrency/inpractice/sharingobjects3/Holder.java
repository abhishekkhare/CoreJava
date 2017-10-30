package com.edu.abhi.concurrency.inpractice.sharingobjects3;

public class Holder {
	private int n;

	public Holder(int n) {
		System.out.println("START");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.n = n;
		System.out.println("END");
	}

	public void assertSanity() {
		if (n != n)
			throw new AssertionError("This statement is false.");
	}
}