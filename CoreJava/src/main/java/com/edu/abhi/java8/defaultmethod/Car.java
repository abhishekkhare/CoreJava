package com.edu.abhi.java8.defaultmethod;

public class Car implements Moveable{

	@Override
	public void moveNow() {
		System.out.println("Vehicle is on the move now!1");
		
	}

	public  static void Stream1 () {
		System.out.println("This is a static stream");
	}
	
	@Override
	public void test() {
		System.out.println("CAR TEST");
		
	}

}
