package com.edu.abhi.designpatterns.decorator.coffee;

public class MilkDecorator extends CoffeeDecorator{

	private String name;
	private double cost;
	
	public MilkDecorator(Coffee coffee,String name,double cost){
		super(coffee);
		this.name = name;
		this.cost=cost;
	}
	
	@Override
	public String getDescription(){
		return this.tempCoffee.getDescription() + "," +name;
	}
	
	@Override
	public double getCost(){
		return this.tempCoffee.getCost() +cost;
	}
}

