package com.edu.abhi.designpatterns.decorator.coffee;

public class CoffeeDecorator implements Coffee{

	protected Coffee tempCoffee;
	
	public CoffeeDecorator(Coffee coffee){
		this.tempCoffee = coffee;
	}
	
	@Override
	public String getDescription() {
		
		return tempCoffee.getDescription();
	}

	@Override
	public double getCost() {

		return tempCoffee.getCost();
	}

}
