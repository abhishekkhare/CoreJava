package com.edu.abhi.designpatterns.decorator.practice;

public class Test {

	public static void main(String[] args) {
		{
			Coffee pc = new PlainCofee();
			pc = new Milk(pc);
			System.out.println(pc.description() + " $" + pc.cost());	
		}
		
		{
			Coffee pc = new PlainCofee();
			pc = new Milk(pc);
			pc = new Whip(pc);
			System.out.println(pc.description() + " $" + pc.cost());	
		}
		
		{
			Coffee pc = new PlainCofee();
			pc = new Soy(pc);
			pc = new Whip(pc);
			System.out.println(pc.description() + " $" + pc.cost());	
		}
		
		
		

	}

}
