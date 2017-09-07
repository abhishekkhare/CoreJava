package com.edu.abhi.designpatterns.decorator.hfdp;

public abstract class CondimentDecorator extends Beverage {
	protected Beverage beverage;

	public abstract String getDescription();

	public Size getSize() {
		return beverage.getSize();
	}
	
	public double sizeCost() {
		double cost = beverage.cost();
		if (beverage.getSize() == Size.TALL) {
			cost += .10;
		} else if (beverage.getSize() == Size.GRANDE) {
			cost += .15;
		} else if (beverage.getSize() == Size.VENTI) {
			cost += .20;
		}
		return cost;
	}
}
