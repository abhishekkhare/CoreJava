package com.edu.abhi.java8.defaultmethod;

public class TestDefaultMethod {

	public static void main(String[] args) {
		Moveable animal = new Animal();
		Moveable car = new Car();
		System.out.println("**********Move Now***********");
		animal.moveNow();
		car.moveNow();
		System.out.println("**********Move Fast***********");
		animal.moveFast();
		car.moveFast();
		System.out.println("**********Static Stream***********");
		Animal.Stream();
		Moveable.Stream();
		//Car.Stream();//Not available as Static methods

	}

}
