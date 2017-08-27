package com.edu.abhi.question.codility;

public class Factorial {

	public static void main(String[] args) {
		fac(5);

	}

	private static void fac(int x) {
		int fact = 1;
		for (int i = 1; i <= x; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + x + " is: " + fact);
	}
}