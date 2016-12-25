package com.edu.abhi.concurrency.threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WaitAndNotify {
	private List<String> synchedList;

	public WaitAndNotify() {
		// create a new synchronized list to be used
		synchedList = Collections.synchronizedList(new LinkedList<String>());
	}

	// method used to remove an element from the list
	public String removeElement() throws InterruptedException {
		synchronized (synchedList) {
			// while the list is empty, wait
			while (synchedList.isEmpty()) {
				System.out.println("List is empty...  " + Thread.currentThread().getName());
				synchedList.wait();
				System.out.println("Waiting..." + Thread.currentThread().getName());
			}
			String element = synchedList.remove(0);

			return element;
		}
	}

	// method to add an element in the list
	public void addElement(String element) {
		System.out.println("Opening...");
		synchronized (synchedList) {
			// add an element and notify all that an element exists
			synchedList.add(element);
			System.out.println("New Element:'" + element + "'");
			synchedList.notifyAll();
			//synchedList.notify();
			System.out.println("notifyAll called!");
		}
		//Notice once the lock is free, the other thread sitting on wait starts to execute.
		System.out.println("Out of syncronized block");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Closing...");
	}

	public static void main(String[] args) {
		final WaitAndNotify demo = new WaitAndNotify();

		Runnable runA = new Runnable() {
			public void run() {
				try {
					String item = demo.removeElement();
					System.out.println("--- " + item);
				} catch (InterruptedException ix) {
					System.out.println("--- Interrupted Exception! " + Thread.currentThread().getName());
				} catch (Exception x) {
					System.out.println("--- Exception thrown. " + Thread.currentThread().getName());
				}
			}
		};

		Runnable runB = new Runnable() {
			// run adds an element in the list and starts the loop
			public void run() {
				demo.addElement("Hello!");
			}
		};

		try {
			Thread threadA1 = new Thread(runA, "A");
			threadA1.start();
			Thread.sleep(500);
			Thread threadA2 = new Thread(runA, "B");
			threadA2.start();
			Thread.sleep(500);

			Thread threadB = new Thread(runB, "C");
			threadB.start();

			Thread.sleep(1000);			
			System.out.println("Lets interrupt the hanging thread");
			
			//if you comment the below interrupt requests, one of the thread A or B will be left dangling. The dangling thread will have no way
			// to come out of the wait state. Same thing would occur if we would have called notify instead of notifyAll.
			threadA1.interrupt();
			threadA2.interrupt();
		} catch (InterruptedException x) {
			System.out.println(x.getMessage());
		}
	}
}
