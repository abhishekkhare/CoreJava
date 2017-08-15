package com.edu.abhi.java8.defaultmethod;

public class Car implements Moveable{

	@Override
	public void moveNow() {
		System.out.println("Vehicle is on the move now!1");
		
	}

	public  static void Stream1 () {
		System.out.println("This is a car static stream1");
	}
	
	public  static void Stream () {
		System.out.println("This is a car static stream");
	}
	
	@Override
	public void test() {
		System.out.println("CAR TEST");
		
	}
	
	public static void main(String [] args){
		Car a = new Car();
		Moveable b = new Car();
		a.moveFast();
		b.moveFast();
		System.out.println("111111111111");
		a.moveNow();
		b.moveNow();
		System.out.println("2222222222222");
		a.run();
		b.run();
		System.out.println("33333333333333");
		a.test();
		b.test();
		System.out.println("44444444444444");
		Car.Stream1();
		Moveable.Stream();
		System.out.println("Done");
	}

}
