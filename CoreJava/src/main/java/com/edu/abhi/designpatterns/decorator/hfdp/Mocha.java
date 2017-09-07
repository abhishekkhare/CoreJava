package com.edu.abhi.designpatterns.decorator.hfdp;

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
