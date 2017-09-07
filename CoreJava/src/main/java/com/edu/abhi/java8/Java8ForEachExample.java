package com.edu.abhi.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
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
		listExample();
		//mapExample();
		
		
		
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
		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		System.out.println("**** After Java 8 Type 1");
		
		/**
		 * traversing with Consumer interface implementation
		 */
		BiConsumer<String,Integer> action = new MyConsumer1();
		items.forEach(action);
		System.out.println("**** After Java 8 Type 2");
		
		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		System.out.println("**** After Java 8 Type 3");
		
		
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
				
				myList.forEach(item->System.out.println(item));
				System.out.println("**** After Java 8 Type 3");
				
				myList.forEach(item->{
					if(item%2==0){
						System.out.println(item);
					}
				});
				System.out.println("**** After Java 8 Type 3");
				
				myList.stream().filter(s->s%3==0).forEach(action);
				System.out.println("**** After Java 8 Type 4");
		
	}

	public static void consumerIterator(){}
}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {
	public void accept(Integer t) {
		System.out.println("Consumer impl Value::" + t);
	}
}

class MyConsumer1 implements BiConsumer<String, Integer> {

	@Override
	public void accept(String t, Integer u) {
		System.out.println("Consumer impl Key::" + t + " Value::" + u);
		
	}
	
}
