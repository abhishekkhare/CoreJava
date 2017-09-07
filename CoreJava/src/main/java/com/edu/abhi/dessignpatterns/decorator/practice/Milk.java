package com.edu.abhi.dessignpatterns.decorator.practice;

public class Milk extends CoffeeDecorator {

	public Milk(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String description() {
		return coffee.description() + " Adding Milk";
	}

	@Override
	public double cost() {
		return coffee.cost()+0.5;
	}

}
