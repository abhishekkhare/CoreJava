package com.edu.abhi.question.codility;

public class ArrayInversionCount {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{-1,6,3,4,7,4}));

	}
	public static int solution(int[] A){
		int count=0;
		for (int i = 0; i < A.length-1; i++) {
			for (int j = i+1; j < A.length; j++) {
				if(A[j]<A[i])
					count++;
			}
		}
		return count;
	}
}
