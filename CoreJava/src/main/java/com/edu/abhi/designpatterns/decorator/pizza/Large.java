package com.edu.abhi.designpatterns.decorator.pizza;

public class Large extends ToppingDecorator {

	public Large(Pizza newPizza) {
		super(newPizza);
		System.out.println("Large");
	}
	
public String getDescription(){
		
		return tempPizza.getDescription() + ", Large";
		
	}
	
	public double getCost(){
		
		System.out.println("Large: " + 1.00);;
		
		return tempPizza.getCost() + 1.00;
		
	}

}
