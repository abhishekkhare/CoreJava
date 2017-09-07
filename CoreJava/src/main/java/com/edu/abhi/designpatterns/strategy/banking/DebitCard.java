package com.edu.abhi.designpatterns.strategy.banking;

public class DebitCard implements PaymentType {

	@Override
	public void pay() {
		System.out.println("Paying By Debit Card");

	}

}
