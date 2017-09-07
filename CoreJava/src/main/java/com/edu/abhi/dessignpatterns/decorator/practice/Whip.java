package com.edu.abhi.dessignpatterns.decorator.practice;

public class Whip extends CoffeeDecorator {

	public Whip(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String description() {
		return coffee.description() + " Adding Whip Cream";
	}

	@Override
	public double cost() {
		return coffee.cost() + 0.7;
	}

}
