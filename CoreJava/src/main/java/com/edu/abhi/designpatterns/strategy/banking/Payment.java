package com.edu.abhi.designpatterns.strategy.banking;

public abstract class Payment {
	protected PaymentType paymentType;
	protected abstract void makePayment();
	public void doItNow(){
		System.out.println("Trying to connect the payment service");
		makePayment();
	}
	
}
