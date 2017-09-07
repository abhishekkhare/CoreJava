package com.edu.abhi.dessignpatterns.strategy.banking;

public class PayPal implements PaymentType {

	@Override
	public void pay() {
		System.out.println("Paying by PayPal");

	}

}
