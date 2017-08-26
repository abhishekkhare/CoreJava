package com.edu.abhi.question.codility;

import java.util.Arrays;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
		
		System.out.println(solution(new int[]{9,3,9,3,9,7,9,5,7,6,5,8,9,6,11}));
		System.out.println(solution(new int[]{1,1,2,2,3,3,4,4,5}));
		System.out.println(solution(new int[]{1,2,2,3,3,4,4,5,5}));
		System.out.println(solution(new int[]{1,1,2,2,3,4,4,5,5}));
	}
	
	public static int solution(int[] A){
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		for (int i = 0; i+1 < A.length;) {
			System.out.println(A[i] + " -- " + A[i+1]);
			if(A[i]==A[i+1]){
				i+=2;
			}else{
				return A[i];
			}
			System.out.println(i + " - " + A.length);
		}
		
		return A[A.length-1];
	}
}
