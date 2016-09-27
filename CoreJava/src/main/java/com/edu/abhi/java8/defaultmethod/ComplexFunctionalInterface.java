package com.edu.abhi.java8.defaultmethod;

/**
 * 
 * @author abhishekkhare
 *
 *         Interface can extend another interface and in case the Interface it
 *         is extending in functional and it doesn’t declare any new abstract
 *         methods then the new interface is also functional. But an interface
 *         can have one abstract method and any number of default methods and
 *         the interface would still be called an functional interface.
 */

@FunctionalInterface
public interface ComplexFunctionalInterface extends SimpleFuncInterface {
	default public void doSomeWork() {
		System.out.println("Doing some work in interface impl...");
	}

	default public void doSomeOtherWork() {
		System.out.println("Doing some other work in interface impl...");
	}
}
