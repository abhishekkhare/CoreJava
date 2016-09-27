package com.edu.abhi.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
 * @author abhishekkhare
 * 
 * The number of lines might increase but forEach method helps in having
 * the logic for iteration and business logic at separate place
 * resulting in higher separation of concern and cleaner code.
 *
 */
public class Java8ForEachExample {
	public static void main(String[] args) {
		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);

		// traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Value::" + i);
		}

		System.out.println("**** Before Java 8");
		/**
		 * traversing through forEach method of Iterable with anonymous class
		 */

		myList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::" + t);
			}

		});
		System.out.println("**** After Java 8 Type 1");
		/**
		 * traversing with Consumer interface implementation
		 */
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		System.out.println("**** After Java 8 Type 2");

	}

}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {
	public void accept(Integer t) {
		System.out.println("Consumer impl Value::" + t);
	}
}
