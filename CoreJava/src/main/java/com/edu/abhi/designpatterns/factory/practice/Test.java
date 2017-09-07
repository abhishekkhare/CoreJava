package com.edu.abhi.designpatterns.factory.practice;

public class Test {

	public static void main(String[] args) {
		PizzaStore pz = new NyStylePizzaStore();
		pz.preparePizza(pz,"Cheese");
		
		System.out.println("******************************");
		pz = new CLStylePizzaStore();		
		pz.preparePizza(pz,"peporoni");
	}

}
