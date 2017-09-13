package com.edu.abhi.java8.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {

	public static void main(String[] args) {

		System.out.println("Static Method Reference");
		List<Integer> integers = Arrays.asList(1, 12, 433, 5);

		Optional<Integer> max1 = integers.stream().reduce((x, y) -> Math.max(x, y));
		max1.ifPresent(System.out::println);

		Optional<Integer> max = integers.stream().reduce(Math::max);
		max.ifPresent(value -> System.out.println(value));

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 29, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20);

		List<Integer> primeNumbers = findPrimeNumbers(numbers, (number) -> isPrime(number));
		System.out.println("Prime Numbers are " + primeNumbers);

		primeNumbers = findPrimeNumbers(numbers, MethodReferenceExample::isPrime);
		System.out.println("Prime Numbers are " + primeNumbers);

		System.out.println("Constructor Method Reference");

		numbers = Arrays.asList(4, 9, 16, 25, 36);
		List<Double> squaredNumbers = findSquareRoot(numbers, Double::new);
		System.out.println("Square root of numbers = " + squaredNumbers);

		List<String> country = Arrays.asList("India", "China", "Russia", "Brazil", "South Africa");
		List<String> countryUpper = toUpperCase(country, String::new);
		System.out.println("Country To Upper = " + countryUpper);

		System.out.println("Instance Method Reference");

		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Albert", 80));
		persons.add(new Person("Ben", 15));
		persons.add(new Person("Charlote", 20));
		persons.add(new Person("Dean", 6));
		persons.add(new Person("Elaine", 17));

		List <Integer>allAges = listAllAges(persons, Person::getAge);
		System.out.println("Printing out all ages \n" + allAges);
		
		
		List <String>names = new ArrayList<String>();
        names.add("David");
        names.add("Richard");
        names.add("Samuel");
        names.add("Rose");
        names.add("John");
		printNames(names,System.out::println);
		
	}

	private static void printNames(List<String> names, Consumer <String>c) {
		names.forEach(x -> c.accept(x));
		
	}

	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i < number / 2 + 1; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> findPrimeNumbers(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> sortedNumbers = new ArrayList<Integer>();
		list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
			sortedNumbers.add(i);
		});
		return sortedNumbers;

	}

	private static List<Double> findSquareRoot(List<Integer> numbers, Function<Integer, Double> f) {
		List<Double> result = new ArrayList<Double>();
		numbers.forEach(x -> result.add(Math.sqrt(f.apply(x))));
		return result;
	}

	private static List<String> toUpperCase(List<String> strings, Function<String, String> f) {
		List<String> result = new ArrayList<String>();
		strings.forEach(x -> result.add(f.apply(x.toUpperCase())));
		return result;
	}

	private static List<Integer> listAllAges(List<Person> person, Function<Person, Integer> f) {
		List <Integer> result = new ArrayList<Integer>();
		person.forEach(x -> result.add(f.apply((Person) x)));
		return result;
	}
}

class Person {

	private final String name;
	private final int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}