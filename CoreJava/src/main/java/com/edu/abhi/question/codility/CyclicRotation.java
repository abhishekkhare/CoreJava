package com.edu.abhi.question.codility;

import java.util.Arrays;
/**
 * https://codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * @author abhishekkhare
 *
 */
public class CyclicRotation {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 1)));
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 2)));
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 3)));
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 4)));
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 5)));
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 6)));
		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6 }, 9)));
		
//		System.out.println(Arrays.toString(solution(new int[] { 3, 8, 9, 7, 6,5,7,9,4,6,7 }, 6)));
//		System.out.println(Arrays.toString(solution(new int[] {}, 6)));
	}

	public static int[] solution(int[] A, int K){
		if(A.length==0)
			return A;
		if(K>A.length){
			K=K-A.length;
		}
	    for(int i = 1; i <=K; i++) {
	    	A = process(A);
	    	System.out.println("--- "  + Arrays.toString(A));
	    }
	    return A;
	}
	
	static int[] process(int [] A){
		int [] temp = new int[A.length];
		for (int i = 0; i < A.length-1; i++) {
			temp[i+1] = A[i];
		}
		temp[0] = A[A.length-1];
		return temp;
	}
	
}
