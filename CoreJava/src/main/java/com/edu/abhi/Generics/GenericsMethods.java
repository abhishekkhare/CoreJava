package com.edu.abhi.Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsMethods {

	// Generics in method
	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
		return g1.get().equals(g2.get());
	}

	public static <T> T addAndReturn(T element, Collection<T> collection) {
		collection.add(element);
		return element;
	}

	public static <T> T getInstance(Class<T> theClass) throws IllegalAccessException, InstantiationException {
		return theClass.newInstance();
	}

	public static void main(String args[]) throws IllegalAccessException, InstantiationException {
		GenericsType<String> g1 = new GenericsType<>();
		g1.set("Pankaj");

		GenericsType<String> g2 = new GenericsType<>();
		g2.set("Pankaj");

		boolean isEqual = GenericsMethods.<String> isEqual(g1, g2);
		// above statement can be written simply as
		isEqual = GenericsMethods.isEqual(g1, g2);
		System.out.println(isEqual);
		// This feature, known as type inference, allows you to invoke a generic
		// method as an ordinary method, without specifying a type between angle
		// brackets.
		// Compiler will infer the type that is needed
		// isEqual = GenericsMethods.isEqual(g1, g3);//compiler error

		List<String> stringList = new ArrayList<String>();
		List<Integer> intList = new ArrayList<Integer>();
		String theElement = addAndReturn("Test", stringList);
		// Integer theElement1 = addAndReturn("Test", stringList);//compiler
		// error since response expected is String
		Integer theInt = addAndReturn(1, intList);
		// String theInt = addAndReturn(1, intList);//compiler error since
		// response expected is Integer

		System.out.println(theElement + " - " + theInt);
		
		String string   = getInstance(String.class);

		MyClass myClass = getInstance(MyClass.class);
		System.out.println(string + " - " + myClass);
		

	}
}

class MyClass{
	public MyClass(){
		System.out.println("MyClass Instance has been created");
	}
}
