package com.edu.abhi.designpatterns.strategy.hfdp;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("Flying high in the sky");
	}

}
