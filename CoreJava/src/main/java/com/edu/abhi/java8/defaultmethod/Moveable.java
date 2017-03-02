package com.edu.abhi.java8.defaultmethod;

/**
 * 
 * @author abhishekkhare 
 * 
 * Moveable interface is some existing interface and wants to add a new method moveFast(). If it adds moveFast() method using
 *         old technique, then all classes implementing Moveable will also be
 *         changed. In this scenario we can use default method to add a new
 *         method without impacting the implementing classes.
 */
public interface Moveable {
	void moveNow();

	public  static void Stream () {
		System.out.println("This is a static stream");
	}
	
	
	default void moveFast() {
		System.out.println("Somthing is moving fast, buddy !!");
	}
	
	default void run(){
        System.out.println("I am running, kid !!");
    }
	
	void test();

}
