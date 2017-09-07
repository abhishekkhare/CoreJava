package com.edu.abhi.dessignpatterns.strategy.hfdp;

public abstract class Duck {
	protected FlyBehavior flyBehavior;

	protected QuackBehavior quackBehavior;

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	protected void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
	
	protected void setQuackBehavior(QuackBehavior quackBehavior){
		this.quackBehavior = quackBehavior;
	}
	
	public void swim() {
		System.out.println("Swim");
	}

}