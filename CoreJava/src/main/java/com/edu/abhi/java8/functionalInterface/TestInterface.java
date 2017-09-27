package com.edu.abhi.java8.functionalInterface;

public class TestInterface {
	public static void main(String[] args) {
		carryOutWork((x) -> System.out.println("I1:" + x));
		carryOutWork(() -> System.out.println("I2:"));
		carryOutWork((x,y)-> System.out.println("I3:" + x + " - " + y));
	}
	
	private static void carryOutWork(Interface1 i) {
		i.method1("Hello");
		
	}
	private static void carryOutWork(Interface2 i) {
		i.method2();
		
	}
	
	private static void carryOutWork(Interface3 i) {
		i.method3("Hi", "Hello");
		
	}

}


class I1 implements Interface1 {
	@Override
	public void method1(String str) {
		System.out.println("I1:" + str);
	}
}

class I2 implements Interface2 {
	@Override
	public void method2() {
		System.out.println("I2:");
	}
}

class I3 implements Interface3 {

	@Override
	public void method3(String str1, String str2) {
		System.out.println("I3:" + str1 + " - " + str2);
		
	}
	
}
