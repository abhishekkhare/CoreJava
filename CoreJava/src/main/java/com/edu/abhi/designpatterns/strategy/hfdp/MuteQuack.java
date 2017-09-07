package com.edu.abhi.designpatterns.strategy.hfdp;

public class MuteQuack  implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Can't Quack");
	}
}