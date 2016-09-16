package com.edu.abhi.dessignpatterns.decorator.coffee;

public class SugarDecorator extends CoffeeDecorator{

	private String name;
	private double cost;
	
	public SugarDecorator(Coffee coffee,String name,double cost){
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

