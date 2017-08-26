package com.edu.abhi.question.codility;

public class TapeEquilibrium {

	public static void main(String[] args) {		
		System.out.println(solution(new int[]{1,2}));
		System.out.println(solution(new int[]{35,29}));
		System.out.println("*****");
		System.out.println(solution(new int[]{1,2}));
		System.out.println(solution(new int[]{35,29}));
		System.out.println("!!!!!!!");
		System.out.println(solution(new int[]{3,1,2,4,3,5}));
		System.out.println(solution(new int[]{3,1,2,4,3,7,5}));
		System.out.println(solution(new int[]{3,1,2,4,3,9,7,5}));
		System.out.println(solution(new int[]{3,1,2,4,3,11,9,7,5}));
		System.out.println(solution(new int[]{3,1,2,4,3,13}));
		System.out.println(solution(new int[]{3,1,2,4,3,15}));
		
		System.out.println(solution(new int[]{-33,-1,2,4,3,-15}));
		
	}

	public static int solution(int[] A){
		int res = Integer.MAX_VALUE;
		int tmp=0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		for (int i = 0; i < A.length-1; i++) {
			tmp+=A[i];
			res = Math.min(res, Math.abs(tmp - (sum - tmp)));
		}
		return res;
	}
}
