package com.edu.abhi.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestLambada {

	public static double integrate(DoubleFunction arg,double x){
		return arg.f(x);
		
	}
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
			
			//Practical Usage
			DoubleFunction sine1 = (double x) -> Math.sin(x);
			System.out.println("1 - "+integrate(sine1,10));
			DoubleFunction sine2 = (double x) -> x*100;
			System.out.println("2 - "+integrate(sine2,10));
			DoubleFunction sine3 = (double x) -> x*9;
			System.out.println("3 - "+integrate(sine3,10));
			
		}
		
		//List Iteration with Lambda
		{
			// Prior Java 8 :

			List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
			for (String feature : features) {
				System.out.println(feature);
			}

			// In Java 8:
			features.forEach(n -> System.out.println("Java8::" + n));

		}
		
		//List Iteration with Lambda and Predicate
		
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
		System.exit(0);
		System.out.println("**************************************************************");
		{
			List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

			System.out.println("Print all numbers:");
			evaluate(list, (n) -> true);

			System.out.println("Print no numbers:");
			evaluate(list, (n) -> false);

			System.out.println("Print even numbers:");
			evaluate(list, (n) -> n % 2 == 0);

			System.out.println("Print odd numbers:");
			evaluate(list, (n) -> n % 2 == 1);

			System.out.println("Print numbers greater than 5:");
			evaluate(list, (n) -> n > 5);
		}
	}

	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
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

interface DoubleFunction {
	public double f(double x);
}