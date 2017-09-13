package com.edu.abhi.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class CreateStreams {
	private static Stream<String> streamOfStrings;
	private static Stream<String> streamWithCharset;

	public static void main(String[] args) {
		// 1. Stream of integer values
		Stream<Integer> intStream = Stream.of(3, 6, 1, 8, 2, 9, 4, 5, 7);
		intStream.forEach(i -> System.out.print(i));
		System.out.println("Insertion Order");
		intStream = Stream.of(3, 6, 1, 8, 2, 9, 4, 5, 7).sorted();
		intStream.forEach(i -> System.out.print(i));
		System.out.println("Natural Order");
		// 2. Stream of array

		Stream<String> strStream = Stream.of(new String[] { "Cat", "Dog", "Pig", "Horse", "Mouse" });
		strStream.forEach(p -> System.out.println("Here's a " + p));

		// 3. Stream of list Collections
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			al.add(i);
		}
		Stream<Integer> listStream = al.stream();
		listStream.forEach(p -> System.out.print(p));

		// 4. Using Stream.generate()
		Stream<Date> dtStream = Stream.generate(() -> new Date()).limit(5);
		dtStream.forEach(p -> System.out.println(p));

		Stream<String> randomStream = Stream.generate(new MySupplier()).limit(6);
		randomStream.forEach(p -> System.out.print(p));
		System.out.println();
		// 5. Using Stream.iterate()
		Stream<Integer> itStream = Stream.iterate(20, n -> n + 2).limit(10);
		itStream.forEach(p -> System.out.println(p));
		System.out.println();
		itStream = Stream.iterate(20, new MyUnaryOperator()).limit(7);
		itStream.forEach(p -> System.out.println(p));

		Stream<Long[]> fibStream = Stream.iterate(new Long[] { 1L, 1L }, new FibonacciUnaryOperator()).limit(15);
		fibStream.forEach(p -> System.out.println(p[0]));

		// 6. Using Stream.builder

		Stream<String> streamBuilder = Stream.<String> builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(p -> System.out.println(p));

		MyBuilder<String> builderString = new MyBuilder<String>();
		builderString.accept("a");
		builderString.accept("b");
		builderString.accept("c");
		
		builderString.add("K");
		builderString.build().forEach(p -> System.out.print(p));
		System.out.println();
		
		Stream<Integer> intStreamBuilder = Stream.<Integer> builder().add(23).add(12).add(21).build();
		intStreamBuilder.forEach(p -> System.out.println(p));

		// 7. Stream of Strings
		// Since there is no interface CharStream in JDK, the IntStream is used
		// to represent a stream of chars instead.
		IntStream charStream = "abc".chars();
		charStream.forEach(p -> System.out.print(p));
		System.out.println();

		// 8. Stream of Strings using Regex
		Stream<String> regStream = Pattern.compile(", ").splitAsStream("Cat, Dog, Cow");
		regStream.forEach(p -> System.out.println(p));

		Stream<String> regStream2 = Stream.of("A$B$C".split("\\$"));
		regStream2.forEach(p -> System.out.println(p));

		// Stream of file
		//
		Path path = Paths.get(
				"/Users/abhishekkhare/Documents/myGITWorkspace/CoreJava/CoreJava/src/main/java/com/edu/abhi/java8/lambda/file.txt");
		try {
			streamOfStrings = Files.lines(path);
			Consumer<String> action = x -> System.out.println(x + " " + x.length());
			streamOfStrings.forEach(action);
			streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
			streamWithCharset.forEach(action);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			streamOfStrings.close();
			streamWithCharset.close();
		}
	}

}

class MySupplier implements Supplier<String> {
	String text;

	MySupplier() {
		text = Math.random() + " ||";
	}

	@Override
	public String get() {
		return this.text;
	}
}

class MyUnaryOperator implements UnaryOperator<Integer> {

	@Override
	public Integer apply(Integer t) {
		return t * 5;
	}

}

class FibonacciUnaryOperator implements UnaryOperator<Long[]> {
	@Override
	public Long[] apply(Long[] p) {
		return new Long[] { p[1], p[0] + p[1] };
	}

}

class MyBuilder<T> implements Builder<T> {
	List<T> streamList = new ArrayList<T>();

	@Override
	public void accept(T t) {
		streamList.add(t);
	}

	@Override
	public Stream<T> build() {
		return streamList.stream();
	}

}
