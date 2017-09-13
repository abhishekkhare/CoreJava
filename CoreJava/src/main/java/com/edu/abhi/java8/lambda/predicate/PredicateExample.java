package com.edu.abhi.java8.lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntPredicate;

public class PredicateExample {

	/**
	 * Returns a predicate Object, with this comparison 
	 * @param n
	 * @return
	 */
	public static IntPredicate isGreater(int n) {
		return p -> p > n;
	}

	public static IntPredicate isLesser(int n) {
		return p -> p < n;
	}

	public static void main(String[] args) {
		int i = 8;
		int j = 20;
		int[] intArray = { 4, 16, 19, 30, 72, 16, 11, 3, 7 };
		List<Integer> tempList = new ArrayList<Integer>();
		for (int k : intArray) {
			if(k>i)
				tempList.add(k);
		}
		
		System.out.println(Arrays.toString(tempList.toArray()));
		System.out.println("Before Java 8");
		// WIthout predicate
		/**
		 * Arrays.toString
		 * Arrays.stream(intArray).filter(p -> p > i)
		 */
		
		System.out.println(Arrays.toString(Arrays.stream(intArray).toArray()));
		/**
		 * filter takes a predicate in this case we are providing an inline predicate  
		 */
		System.out.println(Arrays.toString(Arrays.stream(intArray).filter(p -> p > i).toArray()));
		System.out.println("Without Predicate Object");
		
		// Using Predicate
		/**
		 * Using an Predicate object returned by the method
		 */
		System.out.println(isGreater(i).test(10));
		System.out.println(Arrays.toString(Arrays.stream(intArray).filter(isGreater(i)).toArray()));
		System.out.println("Using Predicates");
		
		// Using Predicate- and
		System.out.println(Arrays.toString(
				Arrays.stream(intArray).filter(isGreater(i).and(isLesser(j))).toArray()));

		System.out.println(Arrays.toString(
				Arrays.stream(intArray).filter(isGreater(i).and(isLesser(j))).toArray()));
		System.out.println("Using Predicates with AND");
		// Using Predicate- or
		System.out.println(Arrays.toString(
				Arrays.stream(intArray).filter(isGreater(j).or(isLesser(i))).toArray()));

		System.out.println("Using Predicates with OR");
		// Using Predicate- negate
		System.out.println(
				Arrays.toString(Arrays.stream(intArray).filter(isGreater(i).negate()).toArray()));
		System.out.println("Using Predicates with NOT");
		// Testing predicate on an arg - test
		System.out.println(isGreater(10).test(72));
		System.out.println(isGreater(10).test(5));
		System.out.println("Using Predicates with TEST");
		
		// Using BiPredicate
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		BiPredicate<Integer, Integer> bi2 = (x, y) -> x==5;
		System.out.println(bi.test(4, 3));
		System.out.println(bi.and(bi2).test(4, 3));
		System.out.println(bi.or(bi2).test(4, 3));
		System.out.println(bi2.negate().test(4, 3));
		System.out.println("Using BiPredicate with AND OR NEGATE and TEST");
		{
			Consumer<String> c = x -> System.out.println("1 "+x.toLowerCase());
			c.accept("JAVA");
			Consumer<String> c1 = x -> System.out.println("2 "+x.toUpperCase());
			c.accept("Java Again");
			c.andThen(c1).accept("Java Again");	
		}
		
		{
			Consumer<Integer> c = x -> System.out.println("1 "+(x+12));
			c.accept(1);
			Consumer<Integer> c1 = x -> System.out.println("2 "+(x+8));
			c.accept(2);
			c.andThen(c1).accept(3);	
		}
		

	}

}
