package com.edu.abhi.dessignpatterns.strategy.hfdp;

public class RubberDuck extends Duck {

	
	public RubberDuck() {
		quackBehavior = new Squeak();
		flyBehavior = new FlyNoWay();
	}
	
	@Override
	public void display() {
		System.out.println("Looks like Rubber Duck");
	}
}
