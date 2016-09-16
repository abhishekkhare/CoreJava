package com.edu.abhi.Generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * T – used to denote type
 * E – used to denote element
 * K – keys
 * V - values
 * N – for numbers
 * @author abhishekkhare
 *
 */
public class Basics {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		list.add("abc");
		list.add(new Integer(5)); //OK
		 
		for(Object obj : list){
		        String str=(String) obj; //type casting leading to ClassCastException at runtime
		}
		
		List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>(); 
		list1.add("abc");
		//list1.add(new Integer(5)); //compiler error
		 
		for(String str : list1){
		     //no type casting needed, avoids ClassCastException
		}
		
		/**
		 * Parametrized type like Set<T> is subtype of raw type Set and you can
		 * assign Set<T> to Set
		 */
		@SuppressWarnings({ "unused", "rawtypes" })
		Set setOfRawType = new HashSet<String>();
		setOfRawType = new HashSet<Integer>();

		/**
		 * Set<Object> is setOfAnyType, it can store String, Integer but you can
		 * not assign setOfString or setOfInteger to setOfObject using Generics
		 * in Java
		 */

		Set<Object> setOfAnyType = new HashSet<Object>();
		setOfAnyType.add("abc"); // legal
		setOfAnyType.add(new Float(3.0f)); // legal - <Object> can accept any
											// type

		/**
		 * Set<?> represents SetOfUnknownType and you can assign SetOfString or
		 * SetOfInteger to Set<?>
		 */

		@SuppressWarnings("unused")
		Set<?> setOfUnknownType = new LinkedHashSet<String>();
		setOfUnknownType = new LinkedHashSet<Integer>();
		setOfUnknownType = new HashSet<Object>();
		
		/**
		 * Parametrized Type also follow Inheritance at main Type level means
		 * both HashSet<String> and LinkedHashSet<String> are sub types of
		 * Set<String> and legal by compiler as shown in following Generics
		 * example in Java
		 */

		@SuppressWarnings("unused")
		Set<String> setOfString = new HashSet<String>(); // valid in Generics
		setOfString = new LinkedHashSet<String>(); // Ok
		// setOfString = new LinkedHashSet<Integer>(); // Not Ok

		/**
		 * But Inheritance on type parameter is not supported means Set<Object>
		 * will not accept Set<String>
		 */

		// Set<Object> SetOfObject = new HashSet<String>(); //compiler error -
		// incompatible type
		// Set<String> SetOfObject = new HashSet<Object>();

		/**
		 * Set<? extends Number> will store either Number or sub type of Number
		 * like Integer, Float. This is an example of bounded wildcards in
		 * Generics
		 */
		@SuppressWarnings("unused")
		Set<? extends Number> setOfAllSubTypeOfNumber = new HashSet<Integer>(); //legal - Integer extends Number
		setOfAllSubTypeOfNumber = new HashSet<Float>(); //legal - because Float extends Number
		
		/**
		 * Set<? super Integer> is another example of bounded wildcards, which
		 * will store instances of Integer or super class of Integer.
		 */
		@SuppressWarnings("unused")
		Set<? super Integer> setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Integer>(); //legal because Integer is superType of itself

		setOfAllSuperTypeOfTreeMap = new HashSet<Number>(); //legal because Number is super class of Integer
		setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Object>(); //legal since Object is super type of Integer		
		
	}
	
	/**
	 * If you are writing Generics method than you need to declare type
	 * parameters in method signature between method modifiers and return type
	 */
	public static <T> T identical(T source) {
		return source;
	}


}
