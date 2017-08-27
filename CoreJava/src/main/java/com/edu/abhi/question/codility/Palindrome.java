package com.edu.abhi.question.codility;

public class Palindrome {

	public static void main(String[] args) {
		string("DAAD");
		string("DAEAD");
		string("racecar");
		string("DAADX");
		string("XDAADX");
		string("ABCD");
		number();
	}

	static void string(String str) {
		String revstring = "";

		for (int i = str.length() - 1; i >= 0; --i) {
			revstring += str.charAt(i);
		}

		System.out.println(revstring);

		if (revstring.equalsIgnoreCase(str)) {
			System.out.println("The string is Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}
	}

	static void number() {
		for (int i = 100; i < 1000; i++) {
			int n = i;
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
