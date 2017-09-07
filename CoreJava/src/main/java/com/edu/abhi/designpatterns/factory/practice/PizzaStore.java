package com.edu.abhi.designpatterns.factory.practice;

public abstract class PizzaStore {
	abstract Pizza createPizza(String  type);
	
	Pizza preparePizza(PizzaStore store, String type){
		
		Pizza pizza = store.createPizza(type);
		pizza.getDough();
		pizza.getPizzaType();
		pizza.packIt();
		
		return pizza;
	}
}
