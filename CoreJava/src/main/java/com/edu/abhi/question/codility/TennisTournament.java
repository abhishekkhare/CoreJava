package com.edu.abhi.question.codility;

public class TennisTournament {

	public static void main(String[] args) {
		System.out.println(solution(5, 3));
		System.out.println(solution(10, 3));
		System.out.println(solution(3, 5));

	}

	public static int solution(int P, int C) {
		if (P > C && C * 2 < P) {
			return C;
		}
		return P / 2;
	}
}
