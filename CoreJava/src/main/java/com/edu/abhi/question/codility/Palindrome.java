package com.edu.abhi.question.codility;

public class Palindrome {

	public static void main(String[] args) {
		
	}
	
	static void number(){

		for (int i = 100; i < 500; i++) {
			int n=i;
			int r, sum = 0, temp;
			temp = n;
			while (n > 0) {
				r = n % 10; // getting remainder
				sum = (sum * 10) + r;
				n = n / 10;
			}
			if (temp == sum)
				System.out.println("palindrome number: " + i);
		}
		
	
	}

}
