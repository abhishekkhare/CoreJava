package com.edu.abhi.designpatterns.factory.practice;

public class NyStylePizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if("Cheese".equals(type)){
			return new NyStyleCheesePizza();
		}else if ("peporoni".equals(type)){
			return new NyStylePeporoniPizza();
		}
		return null;
	}

}
