package com.edu.abhi.Collections.examples;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {

	public List<Integer> list = new CopyOnWriteArrayList<Integer>();
	public AddItem addItem = new AddItem();
	public IterateItems iterateItems = new IterateItems();
	public static void main(String[] args) throws InterruptedException {
		FailSafeIterator f = new FailSafeIterator();
		f.list.add(5000);
		f.list.add(6000);
		f.list.add(7000);
		f.list.add(9000);
		Thread t1 = new Thread(f.addItem);
		Thread t2 = new Thread(f.iterateItems);
		t2.start();
		t1.start();
		t1.join();
		t2 = new Thread(f.iterateItems);
		System.out.println("Again");
		t2.start();
	}

	class AddItem implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list.add(i);
			}
		}
	}

	class IterateItems implements Runnable {
		@Override
		public void run() {
			for (Iterator<Integer> iterator = list.iterator(); iterator
					.hasNext();) {
				System.out.println(iterator.next());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
