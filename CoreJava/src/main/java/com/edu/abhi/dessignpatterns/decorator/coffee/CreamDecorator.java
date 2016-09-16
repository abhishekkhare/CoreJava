package com.edu.abhi.dessignpatterns.decorator.coffee;

public class CreamDecorator extends CoffeeDecorator{

	private String name;
	private double cost;
	
	public CreamDecorator(Coffee coffee,String name,double cost){
		super(coffee);
		this.name = name;
		this.cost=cost;
	}
	
	public String getDescription(){
		return this.tempCoffee.getDescription() + "," +name;
	}
	
	public double getCost(){
		return this.tempCoffee.getCost() +cost;
	}
}

