package com.edu.abhi.dessignpatterns.decorator.coffee;

public class CoffeeMaker {

	public static void main(String[] args) {
		{
			Coffee plain = new PlainCoffee();
			System.out.println(plain.getDescription() + " $"+ plain.getCost());			
		}
		{
			Coffee plainTonnedMilkNoCream = new MilkDecorator(new PlainCoffee(), "with Toned Milk", .5); 
			System.out.println(plainTonnedMilkNoCream.getDescription() + " $"+ plainTonnedMilkNoCream.getCost());

		}
		
		{
			Coffee plainFullCreamMilkNoCream = new MilkDecorator(new PlainCoffee(), "with Full Cream Milk", 1.0); 
			System.out.println(plainFullCreamMilkNoCream.getDescription() + " $"+ plainFullCreamMilkNoCream.getCost());

		}
		{
			Coffee plainFullCreamMilkNoCreamBrownSugar = new SugarDecorator(new MilkDecorator(new PlainCoffee(), "with Full Cream Milk", 1.0),", Brown Sugar",0.5); 
			System.out.println(plainFullCreamMilkNoCreamBrownSugar.getDescription() + " $"+ plainFullCreamMilkNoCreamBrownSugar.getCost());

		}
		{
			Coffee plainFullCreamMilkNoCreamBrownSugarWhippedCream = new CreamDecorator(new SugarDecorator(new MilkDecorator(new PlainCoffee(), "with Full Cream Milk", 1.0),", Brown Sugar",0.5)," Whipped Cream",1.5); 
			System.out.println(plainFullCreamMilkNoCreamBrownSugarWhippedCream.getDescription() + " $"+ plainFullCreamMilkNoCreamBrownSugarWhippedCream.getCost());

		}
		

	}

}
