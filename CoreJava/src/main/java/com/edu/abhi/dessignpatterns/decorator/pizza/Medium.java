package com.edu.abhi.dessignpatterns.decorator.pizza;

public class Medium extends ToppingDecorator {

	public Medium(Pizza newPizza) {
		super(newPizza);
		System.out.println("Medium ");
	}
	
public String getDescription(){
		
		return tempPizza.getDescription() + ", Medium ";
		
	}
	
	public double getCost(){
		
		System.out.println("Medium: " + .50);;
		
		return tempPizza.getCost() + .50;
		
	}

}
