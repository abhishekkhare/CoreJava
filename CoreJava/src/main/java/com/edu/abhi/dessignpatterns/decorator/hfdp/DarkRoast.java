package com.edu.abhi.dessignpatterns.decorator.hfdp;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}

	public double cost() {
		return .99;
	}

}
