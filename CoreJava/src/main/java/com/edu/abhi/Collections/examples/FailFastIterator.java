package com.edu.abhi.Collections.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIterator {

	public List<Integer> list = new ArrayList<Integer>();
	public AddItem addItem = new AddItem();
	public IterateItems iterateItems = new IterateItems();
	public RemoveItem removeItem = new RemoveItem();
	public RemoveIteratorItem removeIteratorItem = new RemoveIteratorItem();
	public static void main(String[] args) {
		//failFastAdd();
		//failFastRemove();
		//failFastIteratorRemove();
		failSafeIteratorRemove();
	}

	private static void failSafeIteratorRemove() {
		FailFastIterator f = new FailFastIterator();
		for (int i = 0; i < 20; i++) {
			f.list.add(i*1000);
		}
		Thread t1 = new Thread(f.removeIteratorItem);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Iterator <Integer>iterator = f.list.iterator(); iterator.hasNext();) {
			Integer type =  iterator.next();
			System.out.println(type);
		
		}
		
	}

	private static void failFastIteratorRemove() {
		FailFastIterator f = new FailFastIterator();
		for (int i = 0; i < 20; i++) {
			f.list.add(i*1000);
		}
		Thread t1 = new Thread(f.removeIteratorItem);
		Thread t2 = new Thread(f.iterateItems);
		t2.start();
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
	}

	private static void failFastRemove() {
		FailFastIterator f = new FailFastIterator();
		for (int i = 0; i < 20; i++) {
			f.list.add(i*1000);
		}
		Thread t1 = new Thread(f.removeItem);
		Thread t2 = new Thread(f.iterateItems);
		t2.start();
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
	}

	private static void failFastAdd() {
		FailFastIterator f = new FailFastIterator();
		f.list.add(5000);
		f.list.add(6000);
		f.list.add(7000);
		f.list.add(9000);
		Thread t1 = new Thread(f.addItem);
		Thread t2 = new Thread(f.iterateItems);
		t2.start();
		t1.start();
		
	}

	class RemoveIteratorItem implements Runnable {
		@Override
		public void run() {
			for (Iterator<Integer> iterator = list.iterator(); iterator
					.hasNext();) {
				if(iterator.next()%2000==0)
					iterator.remove();
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class RemoveItem implements Runnable {
		@Override
		public void run() {
			//System.out.println("Removing");
			list.remove(2);
		}
	}
	class AddItem implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.currentThread().sleep(100);
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
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
