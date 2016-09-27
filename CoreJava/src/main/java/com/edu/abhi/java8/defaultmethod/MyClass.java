package com.edu.abhi.java8.defaultmethod;

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	// MyClass won't compile without having it's own log() implementation, this is to circumvent the diamond problem
	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
		Interface1.print("abc");
	}

}
