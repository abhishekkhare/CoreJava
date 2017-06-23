package com.edu.abhi.concurrency.threads.racecondition;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class CounterTS {
	protected long count = 0;

	public synchronized void add(long value) {
		this.count = this.count + value;
		System.out.println(this.count);
	}

	public static void main(String[] args) {

		CounterTS c = new CounterTS();
		for (int i = 0; i < 10; i++) {
			R1Runnable r = new R1Runnable(c,i);
			Thread t = new Thread(r,i+"");
			t.start();
		}
	}

	static class R1Runnable implements  Runnable{
		CounterTS cc;
		Integer ii;
		R1Runnable(CounterTS c,Integer i){
			this.cc=c;
			this.ii=i;
		}
		public void run() {
			this.cc.add(ii);
		}
	}
	
}
