package com.edu.abhi.dessignpatterns.strategy.banking;

public class Client2 extends Payment {

	Client2(PaymentType paymentType){
		this.paymentType=paymentType;
	}
	@Override
	protected void makePayment() {
		this.paymentType.pay();

	}

}
