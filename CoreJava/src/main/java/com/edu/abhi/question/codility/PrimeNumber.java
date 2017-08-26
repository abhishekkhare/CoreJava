package com.edu.abhi.question.codility;

public class PrimeNumber {

	public static void main(String[] args) {
		for (int n = 0; n < 100; n++) {
			int i, m = 0, flag = 0;
			m = n / 2;
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				System.out.println("prime:" + n);
		}

	}

}
