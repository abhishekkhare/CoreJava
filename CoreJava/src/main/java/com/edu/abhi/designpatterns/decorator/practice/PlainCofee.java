package com.edu.abhi.designpatterns.decorator.practice;

public class PlainCofee implements Coffee{

	@Override
	public String description() {
		
		return "Plain Coffee";
	}

	@Override
	public double cost() {
		return 1.0;
	}

}
