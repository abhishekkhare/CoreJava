package com.edu.abhi.designpatterns.strategy.hfdp;

public class RedHeadDuck extends Duck{
	
	public RedHeadDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		System.out.println("Looks like Readhead");
	}
}
