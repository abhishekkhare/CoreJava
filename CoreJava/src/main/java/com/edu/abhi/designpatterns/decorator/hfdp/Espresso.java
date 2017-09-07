package com.edu.abhi.designpatterns.decorator.hfdp;

public class Espresso extends Beverage {
	
	public Espresso() {
		description = "Espresso";
	}

	public double cost() {
		return 1.99;
	}
}
