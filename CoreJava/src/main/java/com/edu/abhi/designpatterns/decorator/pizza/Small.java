package com.edu.abhi.designpatterns.decorator.pizza;

public class Small extends ToppingDecorator {

	public Small(Pizza newPizza) {
		super(newPizza);
		System.out.println("Small Cup");
	}
	
public String getDescription(){
		
		return tempPizza.getDescription() + ", Small";
		
	}
	
	public double getCost(){
		
		System.out.println("Small: " + .00);
		
		return tempPizza.getCost() + .00;
		
	}

}
