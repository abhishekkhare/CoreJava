package com.edu.abhi.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
/**
 * http://www.studytrails.com/java/java8/java8_collections_new_methods/
 * @author abhishekkhare
 *
 */
public class Java8CollectionsAPI {
	public static void main(String[] args) {
		forEachRemaining();
		removeIf();
		spliterator();
		mapReplaceAllCompute();
	}

	private static void mapReplaceAllCompute() {
		Map<String,Integer> authorBooks = new HashMap<String,Integer>();
		authorBooks.put("Book1", 30);
		authorBooks.put("Book4234", 10);
		authorBooks.put("Book", 70);
		
		authorBooks.forEach((k,v)->System.out.println("Book Name : " + k + " Copies Sold : " + v));
		
		System.out.println("After Replace all,we are trying to replace the count of books by the letters in authors words + original count");
		authorBooks.replaceAll((a,b)->a.length()+b);
		authorBooks.forEach((k,v)->System.out.println("Book Name : " + k + " Copies Sold : " + v));
		authorBooks.compute("Book4234", (a, b) -> b * 5);
		System.out.println("After applying the compute");
		authorBooks.forEach((k,v)->System.out.println("Book Name : " + k + " Copies Sold : " + v));
		System.out.println("GetOrDefault::" + authorBooks.getOrDefault("AuthorA", 0));
		System.out.println("GetOrDefault1::" + authorBooks.getOrDefault("Book4234", 0));
		
	}

	private static void spliterator() {
		List<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++)
			items.add(i);
		Spliterator<Integer> s = items.spliterator();
		Spliterator<Integer> s1 = s.trySplit();
		Spliterator<Integer> s2 = s1.trySplit();
		Spliterator<Integer> s3 = s2.trySplit();
		s.forEachRemaining(System.out::println);
		System.out.println("-- traversing the other half of the spliterator --- ");
		s1.forEachRemaining(System.out::println);
		
		System.out.println("-- traversing the other half-1/2 of the spliterator --- ");
		s2.forEachRemaining(System.out::println);
		
		System.out.println("-- traversing the other half-1/4 of the spliterator --- ");
		s3.forEachRemaining(System.out::println);

	}

	private static void removeIf() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "Mahesh"));
		list.add(new Person(2, "Ram"));
		list.add(new Person(3, "Krishna"));
		Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getPid() + ", Name:" + p.getName());
		System.out.println("---Before delete---");
		list.forEach(style);
		int pid = 2;
		Predicate<Person> personPredicate = p -> p.getPid() == pid;
		list.removeIf(personPredicate);
		System.out.println("---After delete---");
		list.forEach(style);

	}

	private static void forEachRemaining() {
		List<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++)
			items.add(i);

		Iterator<Integer> nameIterator = items.iterator();
		int count = 0;
		for (; nameIterator.hasNext();) {
			Integer integer = (Integer) nameIterator.next();
			if (count > 300) {
				break;
			}
			System.out.println("integer::" + integer);
			count++;
		}
		nameIterator.forEachRemaining(System.out::println);

	}

	static class Person {
		int pid;
		String name;

		public Person(int pid, String name) {
			this.pid = pid;
			this.name = name;
		}

		public int getPid() {
			return pid;
		}

		public String getName() {
			return name;
		}

	}
}
