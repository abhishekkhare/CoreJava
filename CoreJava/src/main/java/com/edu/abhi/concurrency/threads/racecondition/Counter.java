package com.edu.abhi.concurrency.threads.racecondition;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class Counter {
	protected long count = 0;

	public void add(long value) {
		this.count = this.count + value;
		System.out.println(this.count);
	}

	public static void main(String[] args) {

		Counter c = new Counter();
		for (int i = 0; i < 10; i++) {
			R1Runnable r = new R1Runnable(c,i);
			Thread t = new Thread(r,i+"");
			t.start();
		}
	}

	static class R1Runnable implements  Runnable{
		Counter cc;
		Integer ii;
		R1Runnable(Counter c,Integer i){
			this.cc=c;
			this.ii=i;
		}
		public void run() {
			this.cc.add(ii);
		}
	}
	
}
