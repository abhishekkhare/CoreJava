package com.edu.abhi.designpatterns.strategy.banking;

public class CreditCard implements PaymentType {

	@Override
	public void pay() {
		System.out.println("Paying by CC");

	}

}
