package com.edu.abhi.question.codility;

import java.util.Arrays;

public class CountNonDivisible {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{3,1,2,3,6})));

	}
	
	public static int[] solution(int[] A){
		int [] temp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
			int count =0;
			for (int j = 0; j < A.length ; j++) {
				System.out.println(A[i] + " -- "+ A[j]);
				if(i==j){
					//do nothing
				}else if(A[i]%A[j]!=0){
					System.out.println(A[i] + " ++ "+ A[j]);
					count++;
				}
			}
			System.out.println("count" + count);
			temp[i]=count;
		}
		
		return temp;
	}

}
