package com.edu.abhi.designpatterns.factory.practice;

public abstract class Pizza {

	protected abstract void getPizzaType();

	void packIt() {
		System.out.println("Boxing the Pizza");

	}

	void getDough() {
		System.out.println("Getting Dough");

	}

}
