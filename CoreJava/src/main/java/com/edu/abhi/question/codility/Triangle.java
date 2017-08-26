package com.edu.abhi.question.codility;

import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{10,2,5,1,8,20}));

	}
	public static int solution(int[] A){
		if (A.length < 3)
			return 0;
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		for (int i = 2; i < A.length; i++) {
			if ((long)A[i-2] + (long)A[i-1] > (long)A[i])
				return 1;
		}
		return 0;
	}
}
