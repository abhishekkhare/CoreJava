package com.edu.abhi.designpatterns.decorator.hfdp;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}

	public double cost() {
		return .99;
	}

}
