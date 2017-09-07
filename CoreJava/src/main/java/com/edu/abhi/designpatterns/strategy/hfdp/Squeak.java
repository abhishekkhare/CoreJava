package com.edu.abhi.designpatterns.strategy.hfdp;

public class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Squeak");
	}
}