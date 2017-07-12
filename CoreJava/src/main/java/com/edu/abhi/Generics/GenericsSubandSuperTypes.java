package com.edu.abhi.Generics;

import java.util.List;

public class GenericsSubandSuperTypes {
	/**
	 * List<?> means a list typed to an unknown type. This could be a List<A>, a
	 * List<B>, a List<String> etc.
	 * 
	 * @param elements
	 */
	public void processElements(List<?> elements) {
		for (Object o : elements) {
			System.out.println(o);
		}
	}

	/**
	 * List<? extends A> means a List of objects that are instances of the class
	 * A, or subclasses of A (e.g. B and C).
	 * 
	 * @param elements
	 */
	public void processElements1(List<? extends A> elements) {
		for (A a : elements) {
			System.out.println(a.i);
		}
	}

	/**
	 * List<? super A> means that the list is typed to either the A class, or a
	 * superclass of A.
	 * 
	 * @param list
	 */
	public static void insertElements(List<? super A> list) {
		list.add(new A());
		list.add(new B());
		list.add(new C());
	}
}

class A {
	public Integer i;
}

class B extends A {
	public String s;
}

class C extends A {
	public long l;
}