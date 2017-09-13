package com.edu.abhi.java8.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		System.out.println("Static Method Reference");
		List<Integer> integers = Arrays.asList(1,12,433,5);
		
		Optional<Integer> max1 = integers.stream().reduce((x,y) -> Math.max(x, y));
		max1.ifPresent(System.out::println);
		
		Optional<Integer> max = integers.stream().reduce( Math::max );
		max.ifPresent(value -> System.out.println(value));
		max.ifPresent(System.out::println);
		
	}

}
