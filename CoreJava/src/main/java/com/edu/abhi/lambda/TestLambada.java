package com.edu.abhi.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestLambada {

	public static void main(String[] args) {

		{
			// Before Java 8:
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Before Java8, too much code for too little to do");
				}
			}).start();

			// Java 8 way:
			new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
		}
		{
			// Prior Java 8 :

			List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
			for (String feature : features) {
				System.out.println(feature);
			}

			// In Java 8:
			features.forEach(n -> System.out.println(n));

		}

		{
			List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jira");
			System.out.println("Languages which starts with J :");
			filter(languages, (str) -> str.startsWith("J"));
			System.out.println("Languages which ends with a ");
			filter(languages, (str) -> str.endsWith("a"));
			System.out.println("Print all languages :");
			filter(languages, (str) -> true);
			System.out.println("Print no language : ");
			filter(languages, (str) -> false);
			System.out.println("Print language whose length greater than 4:");
			filter(languages, (str) -> str.length() > 4);

			System.out.println("Name, which starts with 'J' and four letter long");
			filter1(languages, (str) -> str.startsWith("J"));
		}
		{
			// applying 12% VAT on each purchase // Without lambda expressions:
			List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
			for (Integer cost : costBeforeTax) {
				double price = cost + .12 * cost;
				System.out.println(price);
			}

			// With Lambda expression:
			costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

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
			double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost)
					.get();
			System.out.println("Total : " + bill);

		}

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
			// Convert String to Uppercase and join them using coma
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
			//Get count, min, max, sum, and average for numbers
			List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
			IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
			System.out.println("Highest prime number in List : " + stats.getMax());
			System.out.println("Lowest prime number in List : " + stats.getMin());
			System.out.println("Sum of all prime numbers : " + stats.getSum());
			System.out.println("Average of all prime numbers : " + stats.getAverage());

		}
		
		{
			List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
			 
	        System.out.println("Print all numbers:");
	        evaluate(list, (n)->true);
	 
	        System.out.println("Print no numbers:");
	        evaluate(list, (n)->false);
	 
	        System.out.println("Print even numbers:");
	        evaluate(list, (n)-> n%2 == 0 );
	 
	        System.out.println("Print odd numbers:");
	        evaluate(list, (n)-> n%2 == 1 );
	 
	        System.out.println("Print numbers greater than 5:");
	        evaluate(list, (n)-> n > 5 );
		}
	}

	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list)  {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
	
	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

	public static void filter1(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			Predicate<String> fourLetterLong = (n) -> n.length() == 4;
			if (condition.and(fourLetterLong).test(name)) {
				System.out.println(name + " ");
			}
		}
	}

}
