package com.edu.abhi.dessignpatterns.strategy.hfdp;

public class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Squeak");
	}
}