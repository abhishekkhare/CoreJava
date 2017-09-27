package com.edu.abhi.java8.lambda.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestBiConsumer {

	public static void main(String[] args) {
		biConsumer();
		mapExample();

	}

	private static void biConsumer() {
		BiConsumer<String, Integer> action = (x,y) -> System.out.println(x + " = " + y);
		action.accept("2*3", 2*3);
		BiConsumer<Person, Integer> action1 = (x,y) -> System.out.println(x.name + " " + x.pid + " " +y);
		action1.accept(new Person(1, "Abhi"), 9);
		
	}

	private static void mapExample() {
		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}

		System.out.println("**** Before Java 8");
		items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
		System.out.println("**** After Java 8 Type 1");

		/**
		 * traversing with Consumer interface implementation
		 */
		BiConsumer<String, Integer> action = new MyBiConsumer();
		items.forEach(action);
		System.out.println("**** After Java 8 Type 2");

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});

		System.out.println("**** After Java 8 Type 3");

	}
}

class MyBiConsumer implements BiConsumer<String, Integer> {

	@Override
	public void accept(String t, Integer u) {
		System.out.println("BiConsumer impl Key::" + t + " Value::" + u);

	}

}