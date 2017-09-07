package com.edu.abhi.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamExample {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 10000000; i++)
			myList.add(i);

		// sequential stream - Returns a sequential Stream with this collection
		// as its source.
		{
			long before = System.currentTimeMillis();
			Stream<Integer> sequentialStream = myList.stream();
			Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p % 100000 == 0);
			// highNumsSeq.forEach(item->System.out.println(item));
			long after = System.currentTimeMillis();
			System.out.println("Diff Seq::" + (after - before));
		}
		// parallel stream - Returns a possibly parallel Stream with
		// this collection as its source. It is allowable for this method to
		// return a sequential stream.
		{
			long before = System.currentTimeMillis();
			Stream<Integer> parallelStream = myList.parallelStream();
			Stream<Integer> highNumsSeq1 = parallelStream.filter(p -> p % 100000 == 0);
			// highNumsSeq1.forEach(item->System.out.println(item));
			long after = System.currentTimeMillis();
			System.out.println("Diff Parallel::" + (after - before));

		}
		
		/**
		 * In most cases for system with multi core, the parallelStream would
		 * have better performance.
		 */

		{
			// applying 12% VAT on each purchase // Without lambda expressions:
			List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
			for (Integer cost : costBeforeTax) {
				double price = cost + .12 * cost;
				System.out.println(price);
			}

			System.out.println("------Java 8-----");
			// With Lambda expression:
			//map - Returns a stream consisting of the results of applying the given function to the elements of this stream.
			costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
			System.out.println("Break it Down");
			
			Stream<Integer> stream = costBeforeTax.stream();
			Stream<Double>stream2 = stream.map((cost) -> cost + .12 * cost);
			stream2.forEach(y -> System.out.println(y));
			//  if we try to iterate the same stream more than once we get java.lang.IllegalStateException: stream has already been operated upon or closed
			//stream2.forEach(System.out::println);

		}
		
		{
			// Applying 12% VAT on each purchase // Old way:
			List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
			double total = 0;
			for (Integer cost : costBeforeTax) {
				double price = cost + .12 * cost;
				total = total + price;
			}
			System.out.println("Total : " + total);

			// New way: List costBeforeTax = Arrays.asList(100, 200, 300, 400,
			// 500);
			double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
			
			
			
			System.out.println("Total : " + bill);
			
			System.out.println("Break it Down");
			Stream<Integer> stream = costBeforeTax.stream();
			System.out.println(stream);
			Stream<Double>stream2 = stream.map((cost) -> cost + .12 * cost);
			System.out.println(stream);
			double bill1 = stream2.reduce((sum, cost) -> sum + cost).get();
			System.out.println("Total : " + bill1);

		}
		System.exit(0);
		{
			List<String> strList = new ArrayList<String>();
			strList.add("abc");
			strList.add("bcd");
			strList.add("pq");
			strList.add("defg");
			strList.add("jk");
			strList.add("rs");
			// Create a List with String more than 2 characters
			List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
			System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

		}
		{
			// Convert String to Uppercase and join them using comma
			List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
			String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
			System.out.println(G7Countries);

		}
		{
			// Create List of square of all distinct numbers
			List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
			List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
			System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);
		}
		{
			// Get count, min, max, sum, and average for numbers
			List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
			IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
			System.out.println("Highest prime number in List : " + stats.getMax());
			System.out.println("Lowest prime number in List : " + stats.getMin());
			System.out.println("Sum of all prime numbers : " + stats.getSum());
			System.out.println("Average of all prime numbers : " + stats.getAverage());

		}
	}
}
