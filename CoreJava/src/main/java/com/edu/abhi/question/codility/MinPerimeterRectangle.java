package com.edu.abhi.question.codility;

public class MinPerimeterRectangle {

	public static void main(String[] args) {
		System.out.println(solution(30));
		System.out.println(solution(14));

	}
	
	public static int solution(int N){
		int min = Integer.MAX_VALUE;
		for (int i = 1; i*i <= N; i++) {
			if (N % i == 0) {
				System.out.println(N + " -- " + i);
				min = 2*(i+N/i)<min?2*(i+N/i):min;
			}
		}
		return min;
	}
}
