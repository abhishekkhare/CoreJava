package com.edu.abhi.question.codility;

import java.util.Arrays;

public class SocksLaundering {

	public static void main(String[] args) {
		System.out.println(solution(2, new int[] {1,2,1,1}, new int[]{1,4,3,2,4}));
		System.out.println(solution(10, new int[]{1,2,1,1,3}, new int[]{1,4,3,2,4}));
		System.out.println(solution(10, new int[]{1,2,1,2,3}, new int[]{1,4,3,2,4}));
		System.out.println(solution(10, new int[]{1,2,1,1,3,5}, new int[]{1,4,3,2,4}));
		System.out.println(solution(10, new int[]{0,1,2,1,1,3,5}, new int[]{1,4,3,2,4}));
		System.out.println(solution(10, new int[]{0,1,2,1,1,3,8}, new int[]{1,4,3,2,4}));
		System.out.println(solution(2, new int[]{1,2,1,1,3,5}, new int[]{1,4,3,2,4}));
		System.out.println(solution(1, new int[]{1,2,1,1,3,5}, new int[]{1,4,3,2,4}));
		System.out.println(solution(3, new int[]{1,2,1,1,3,5}, new int[]{1,4,3,2,4}));

	}
	static int solution(int K, int[] C, int[] D){
		Arrays.sort(C);
		System.out.println(Arrays.toString(C) + K);
		int [] temp = new int[K];
		int toBeCleanedCount =0;
		int cleanCount=0;
		for (int i = 0; i+1 <C.length; i=i+2) {
			System.out.println(C[i]+" -- "+C[i+1]);
			if(C[i]!=C[i+1]){
				if(toBeCleanedCount==K){
					break;
				}
				if(K%2==0){
					temp[toBeCleanedCount] = C[i];
					temp[toBeCleanedCount+1] = C[i+1];
					toBeCleanedCount+=2;
				}else{
					
				}
				
			}else{
				cleanCount++;
			}
			
		}
		
		if(C.length%2!=0)
			toBeCleanedCount++;
		
		System.out.println("toBeCleanedCount" + toBeCleanedCount + " cleanCount" + cleanCount);
		
		return 0;
	}
}
