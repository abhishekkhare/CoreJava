package com.edu.abhi.dessignpatterns.strategy.hfdp;

public class MuteQuack  implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Can't Quack");
	}
}