package com.edu.abhi.designpatterns.strategy.hfdp;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I don't fly");
	}

}
