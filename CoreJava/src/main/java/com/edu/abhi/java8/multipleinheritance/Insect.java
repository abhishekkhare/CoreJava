package com.edu.abhi.java8.multipleinheritance;

import com.edu.abhi.java8.defaultmethod.Moveable;

/**
 * 
 * @author abhishekkhare In this case since we have a run() method in both
 *         Moveable and Cralable, we are forced to override it specifying which
 *         interface method we should use.
 *         
 *         However since the test method has no implementation, we are forced to implement it.
 */
public class Insect implements Moveable, Crawlable {

	@Override
	public void moveNow() {
		System.out.println("Insect is moving now.");
	}

	@Override
	public void run() {
		Crawlable.super.run();
	}

	@Override
	public void test() {
		System.out.println("INSECT TEST");
		
	}

	
	public static void main(String [] args){
		Insect i = new Insect();
		i.crawl();
		i.moveFast();
		i.moveNow();
		i.run();
		i.test();
		
	}
}
