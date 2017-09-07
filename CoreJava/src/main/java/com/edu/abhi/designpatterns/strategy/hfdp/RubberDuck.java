package com.edu.abhi.designpatterns.strategy.hfdp;

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
