package com.edu.abhi.java8.defaultmethod;
/**
 * 
 * @author abhishekkhare
 *
 * Here the run() method is not overridden since it is defined as 'default' in the interface. 
 */
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
	
	public static void main(String [] args){
		Animal a = new Animal();
		Moveable b = new Animal();
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
		Animal.Stream();
		Moveable.Stream();
		System.out.println("Done");
	}
}
