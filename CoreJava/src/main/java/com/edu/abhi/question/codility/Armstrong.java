package com.edu.abhi.question.codility;

public class Armstrong {

	public static void main(String[] args) {
		ams(153);

	}

	private static void ams(int n) {
		int c = 0, a, temp;
		temp = n;
		while (n > 0) {
			a = n % 10;
			n = n / 10;
			c = c + (a * a * a);
		}
		if (temp == c)
			System.out.println("armstrong number");
		else
			System.out.println("Not armstrong number");
	}

}
