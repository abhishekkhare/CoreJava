package com.edu.abhi.java8.defaultmethod;

public class Animal implements Moveable {

	@Override
	public void moveNow() {
		System.out.println("Animal is on the move now!!");	
	}

	@Override
	public void moveFast() {
		System.out.println("Animal is moving fast now!!");
	}

	@Override
	public void test() {
		System.out.println("Animal TEST");
		
	}
	public  static void Stream () {
		System.out.println("This is an Animal static stream");
	}
}
