package com.edu.abhi.dessignpatterns.decorator.practice;

public class Soy extends CoffeeDecorator {

	public Soy(Coffee coffee) {
		super(coffee);
	}

	@Override
	public String description() {
		return coffee.description() + " Adding Soy Milk";
	}

	@Override
	public double cost() {
		return coffee.cost()+0.8;
	}

}
