package com.edu.abhi.designpatterns.strategy.hfdp;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck m = new MallardDuck();
		m.display();
		m.performFly();
		m.performQuack();
		
		FlyBehavior fn = new FlyNoWay();
		m.setFlyBehavior(fn);
		m.performFly();

	}

}
