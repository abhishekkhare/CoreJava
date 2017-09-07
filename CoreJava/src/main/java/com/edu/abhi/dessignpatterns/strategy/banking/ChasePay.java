package com.edu.abhi.dessignpatterns.strategy.banking;

public class ChasePay implements PaymentType {

	@Override
	public void pay() {
		System.out.println("Paying by Chase Pay");

	}

}
