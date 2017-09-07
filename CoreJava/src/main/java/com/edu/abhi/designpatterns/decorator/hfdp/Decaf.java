package com.edu.abhi.designpatterns.decorator.hfdp;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}

	public double cost() {
		return 1.05;
	}

}
