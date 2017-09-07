package com.edu.abhi.designpatterns.factory.practice;

public class CLStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if("Cheese".equals(type)){
			return new CLStyleCheesePizza();
		}else if ("peporoni".equals(type)){
			return new CLStylePeporoniPizza();
		}
		return null;
	}

}
