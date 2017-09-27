package com.edu.abhi.java8.lambda.consumer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {

	public static void main(String[] args) {
		consumer();
		listExample();
	}

	private static void consumer() {
		{
			Consumer<String> c = x -> System.out.println("1 " + x.toLowerCase());
			c.accept("JAVA");
			Consumer<String> c1 = x -> System.out.println("2 " + x.toUpperCase());
			c.accept("Java Again");
			c.andThen(c1).accept("Java Again");
		}

		{
			Consumer<Integer> c = x -> System.out.println("1 " + (x + 12));
			c.accept(1);
			Consumer<Integer> c1 = x -> System.out.println("2 " + (x + 8));
			c.accept(2);
			c.andThen(c1).accept(3);// notice both operation occur on 3
		}
		{
			List<Person> list = new ArrayList<Person>();
			list.add(new Person(1, "Mahesh"));
			list.add(new Person(2, "Ram"));
			list.add(new Person(3, "Krishna"));
			Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getPid() + ", Name:" + p.getName());
			Consumer<Person> style1 = (Person p) -> p.name = p.name + " hello";
			list.forEach(style);
			list.forEach(style1);
		}

	}

	private static void listExample() {
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
				System.out.println("forEach anonymous class Value:: with 9*" + t + " = " + t * 9);
			}

		});
		System.out.println("**** After Java 8 Type 1");
		/**
		 * traversing with Consumer interface implementation
		 */
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		System.out.println("**** After Java 8 Type 2");

		myList.forEach(item -> System.out.println("forEach as functional programming 7*" + item + " = " + item * 7));
		System.out.println("**** After Java 8 Type 3");

		myList.forEach(item -> {
			if (item % 2 == 0) {
				System.out.println("forEach as functional programming only even::" + item);
			}
		});
		System.out.println("**** After Java 8 Type 3");

		myList.stream().filter(s -> s % 3 == 0).forEach(action);
		System.out.println("**** After Java 8 Type 4");

	}

}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {
	public void accept(Integer t) {
		System.out.println("Consumer impl Value with 8*" + t + " = " + t * 8);
	}
}
