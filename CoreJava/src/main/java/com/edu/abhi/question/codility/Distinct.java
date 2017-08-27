package com.edu.abhi.question.codility;

import java.util.HashSet;
import java.util.Set;
/**
 * https://codility.com/programmers/lessons/6-sorting/distinct/
 * @author abhishekkhare
 *
 */
public class Distinct {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2,1,1,2,3,1}));
		System.out.println(solution(new int[]{}));
		
		System.out.println(solution(new int[]{2,1,1,2,3,1,-2,1,-1,2,-3,1}));

	}
	
	public static int solution(int[] A){
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		return set.size();
	}

}
