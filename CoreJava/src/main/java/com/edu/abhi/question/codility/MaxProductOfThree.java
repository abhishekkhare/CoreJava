package com.edu.abhi.question.codility;

import java.util.Arrays;

public class MaxProductOfThree {
	public static void main (String[] args) {
		int[] A = new int[] {-3,1,2,-2,5,6};
		System.out.println(solution(A));
		A = new int[] {-20,-1,1,2,-2,5,6};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		int max1 = A[A.length-1] *A[A.length-2] *A[A.length-3];
		int max2 = A[A.length-1] *A[0] *A[1];
		return max1>max2?max1:max2;
	}
}
