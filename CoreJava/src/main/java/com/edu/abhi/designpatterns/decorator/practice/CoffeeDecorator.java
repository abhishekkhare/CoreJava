package com.edu.abhi.designpatterns.decorator.practice;

public abstract class CoffeeDecorator implements Coffee {

	protected Coffee coffee;

	public CoffeeDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	public abstract String description();

	public abstract double cost();

}
