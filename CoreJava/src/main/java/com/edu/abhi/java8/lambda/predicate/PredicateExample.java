package com.edu.abhi.java8.lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	/**
	 * Returns a predicate Object, with this comparison
	 * 
	 * @param n
	 * @return
	 */
	public static IntPredicate isGreater(int n) {
		return p -> p > n;
	}

	public static Predicate<Integer> isGreater(Integer n) {
		return p -> p > n;
	}

	public static IntPredicate isLesser(int n) {
		return p -> p < n;
	}

	public static Predicate<Integer> isLesser(Integer n) {
		return p -> p < n;
	}

	public static void main(String[] args) {
		int[] intArray = { 4, 16, 19, 30, 72, 16, 11, 3, 7 };
		Integer[] intArray1 = { 4, 16, 19, 30, 72, 16, 11, 3, 7 };
		int i = 8;
		int j = 20;
		predicateArrays(intArray, i, j);
		List<Integer> intList = Arrays.asList(intArray1);
		predicateArrays(intList, i, j);
		biPredicate();

	}

	private static void biPredicate() {
		// Using BiPredicate
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		BiPredicate<Integer, Integer> bi2 = (x, y) -> x == 5;
		System.out.println(bi.test(4, 3));
		System.out.println(bi.and(bi2).test(4, 3));
		System.out.println(bi.or(bi2).test(4, 3));
		System.out.println(bi2.negate().test(4, 3));
		System.out.println("Using BiPredicate with AND OR NEGATE and TEST");

	}

	private static void predicateArrays(List<Integer> intList, Integer i, Integer j) {
		System.out.println(intList + " i=" + i + " j=" + j);
		System.out.println("less than i::" + intList.stream().filter(p -> p < i).collect(Collectors.toList()));
		System.out.println("greater than i and less than j:"
				+ intList.stream().filter(p -> i < p).filter(p -> p < j).collect(Collectors.toList()));
		System.out.println("greater than i and less than j:"
				+ intList.stream().filter(isGreater(i).and(isLesser(j))).collect(Collectors.toList()));
		System.out.println("greater than i or less than j:"
				+ intList.stream().filter(isGreater(i).or(isLesser(j))).collect(Collectors.toList()));

	}

	private static void predicateArrays(int[] intArray, int i, int j) {
		List<Integer> tempList = new ArrayList<Integer>();
		for (int k : intArray) {
			if (k > i)
				tempList.add(k);
		}

		System.out.println(Arrays.toString(tempList.toArray()));
		System.out.println("Before Java 8");
		// WIthout predicate
		/**
		 * Arrays.toString Arrays.stream(intArray).filter(p -> p > i)
		 */

		System.out.println(Arrays.toString(Arrays.stream(intArray).toArray()));
		/**
		 * filter takes a predicate in this case we are providing an inline
		 * predicate
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
		System.out.println(Arrays.toString(Arrays.stream(intArray).filter(isGreater(i).and(isLesser(j))).toArray()));

		System.out.println(Arrays.toString(Arrays.stream(intArray).filter(isGreater(i).and(isLesser(j))).toArray()));
		System.out.println("Using Predicates with AND");
		// Using Predicate- or
		System.out.println(Arrays.toString(Arrays.stream(intArray).filter(isGreater(j).or(isLesser(i))).toArray()));

		System.out.println("Using Predicates with OR");
		// Using Predicate- negate
		System.out.println(Arrays.toString(Arrays.stream(intArray).filter(isGreater(i).negate()).toArray()));
		System.out.println("Using Predicates with NOT");
		// Testing predicate on an arg - test
		System.out.println(isGreater(10).test(72));
		System.out.println(isGreater(10).test(5));
		System.out.println("Using Predicates with TEST");

	}

}
