package com.edu.abhi.designpatterns.strategy.banking;

public class TestBankPayment {

	public static void main(String[] args) {
		Client1 c1 = new Client1(new PayPal());
		Client2 c2 = new Client2(new ChasePay());
		c1.doItNow();
		c2.makePayment();

	}

}
