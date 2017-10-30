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

	Exchanger<String> exchanger = null;
	String object = null;

	public ExchangerRunnable(Exchanger<String> exchanger, String object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	public void run() {
		try {
			String previous = this.object;

			this.object = this.exchanger.exchange(this.object);

			System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		System.out.println("Start");
		Exchanger<String> exchanger = new Exchanger<String>();

		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");

		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

		new Thread(exchangerRunnable1,"A").start();
		new Thread(exchangerRunnable2,"B").start();
		System.out.println("End");
	}
}
