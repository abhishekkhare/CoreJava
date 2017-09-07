package com.edu.abhi.designpatterns.decorator.pizza;

public class PizzaMaker {

	public static void main(String[] args) {

		// The PlainPizza object is sent to the Mozzarella constructor
		// and then to the TomatoSauce constructor

		Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
		

		System.out.println("Ingredients: " + basicPizza.getDescription());

		System.out.println("Price: " + basicPizza.getCost());
		
		Pizza smallPizza = new Small(basicPizza);
		
		System.out.println("Ingredients: " + smallPizza.getDescription());

		System.out.println("Price: " + smallPizza.getCost());

		Pizza mediumPizza = new Medium(basicPizza);
		
		System.out.println("Ingredients: " + mediumPizza.getDescription());

		System.out.println("Price: " + mediumPizza.getCost());
		
		Pizza largePizza = new Large(basicPizza);
		
		System.out.println("Ingredients: " + largePizza.getDescription());

		System.out.println("Price: " + largePizza.getCost());
		

	}

}