package com.edu.abhi.question.codility;

import java.util.Arrays;

/**
 * https://codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 * @author abhishekkhare
 *
 */
public class PermMissingElem {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {}));
		System.out.println(solution(new int[] { 1,3,5,7,9,2,4,6,10}));
		System.out.println(solution(new int[] { 8,3,5,7,9,2,4,6,10}));
		System.out.println(solution(new int[] { 1,3,5,7,9,2,4,6,8}));
		
		System.out.println("******************************************************");
		System.out.println(solution(new int[] { 1,3,5,7,9,2,4,6,10,11,12,13,14,15,16,17,18,19,20}));
		System.out.println(solution(new int[] {3,5,7,9,2,4,6,10,11,12,13,14,15,16,17,18,19,20,8}));
		System.out.println(solution(new int[] { 1,3,5,7,9,2,4,6,10,11,12,13,14,15,16,17,18,20,8}));
		System.out.println(solution(new int[] { 1,5,7,9,2,4,6,10,11,12,13,14,15,16,17,18,20,8,19}));
	}
	public static int solution(int[] A){
		if(A.length!=0){
			Arrays.sort(A);
			System.out.println(Arrays.toString(A));
			for (int i = 0; i < A.length; i++) {
				//System.out.println(A[i] + " --- "+ i);
				if(A[i]==i+1){
					//contihue
				}else{
					return i+1;
				}
			}	
		}else{
			return 1;	
		}
		return A.length+1;
	}
}
