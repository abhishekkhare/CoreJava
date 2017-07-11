package com.edu.abhi.concurrency.threads.concurrent;

import java.util.concurrent.Exchanger;

/**
 * The java.util.concurrent.Exchanger class represents a kind of rendezvous
 * point where two threads can exchange objects.
 * 
 * @author abhishekkhare
 *
 */
public class ExchangerRunnable implements Runnable {

	Exchanger<Object> exchanger = null;
	Object object = null;

	public ExchangerRunnable(Exchanger<Object> exchanger, Object object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	public void run() {
		try {
			Object previous = this.object;

			this.object = this.exchanger.exchange(this.object);

			System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		System.out.println("Start");
		Exchanger<Object> exchanger = new Exchanger<Object>();

		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");

		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

		new Thread(exchangerRunnable1,"A").start();
		new Thread(exchangerRunnable2,"B").start();
		System.out.println("End");
	}
}
