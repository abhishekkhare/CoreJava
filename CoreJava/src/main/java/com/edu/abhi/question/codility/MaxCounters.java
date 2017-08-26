package com.edu.abhi.question.codility;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {
		//System.out.println(Arrays.toString(solution(5,new int[]{3,4,4,6,1,4,4})));
		//System.out.println(Arrays.toString(solution(3,new int[]{3,2,3,1,4,4})));
		//System.out.println(Arrays.toString(solution(5,new int[]{6,4,4,3,1,4,4})));
		//System.out.println(Arrays.toString(solution(5,new int[]{6,4,4,3,1,4,4,6})));
		System.out.println(Arrays.toString(solution(5,new int[]{6,4,4,3,1,4,4,6,4})));

	}
	public static int[] solution(int N, int[] A){
		int [] temp = new int[N];
		int maxCounter = 0;
		Arrays.fill(temp, 0);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]+"[]"+Arrays.toString(temp));
			if(A[i]>=1 && A[i]<=N){
				temp[A[i]-1]=temp[A[i]-1]+1;
				if(temp[A[i]-1]>maxCounter)
					maxCounter = temp[A[i]-1]; 
			}else if(A[i]==N+1){
				temp = new int[N];
				Arrays.fill(temp, maxCounter);
			}
		}
		return temp;
	}
	
	
	
	
}
