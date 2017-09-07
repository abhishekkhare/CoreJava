package com.edu.abhi.dessignpatterns.decorator.hfdp;

public class Mocha extends CondimentDecorator {
	 
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + sizeCost();
	}
}
