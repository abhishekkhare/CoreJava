package com.edu.abhi.question.codility;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MissingInteger {

	public static void main(String[] args) {
		MissingInteger s = new MissingInteger();
		System.out.println(s.solution(new int[] { 1,2,3 }));
		System.out.println(s.solution(new int[] { -1, 3, 1, 3, 6, 4, 1, 2 ,100}));
		System.out.println(s.solution(new int[] { -1, -3,-5}));
	}

	public int solution(int[] A) {
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		Set<Integer> tempSet = new LinkedHashSet<Integer>();
		int count=1;
		
		for (int i = 0; i < A.length; i++) {
			if(A[i]>0 && tempSet.add(A[i])){
				System.out.println(count +" "+ A[i]);
				if(count==A[i]){
					count++;
				}else{
					return count;
				}
				
			}
		}
		return count++;
	}

}
