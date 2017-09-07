package com.edu.abhi.designpatterns.strategy.hfdp;

public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("Looks like Mallard");
	}
}
