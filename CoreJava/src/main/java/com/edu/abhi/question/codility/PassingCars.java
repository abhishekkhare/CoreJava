package com.edu.abhi.question.codility;

/**
 * https://codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * @author abhishekkhare
 *
 */
public class PassingCars {

	public static void main(String[] args) {
		//System.out.println(solution(new int[]{0,1,0,1,1}));
		//System.out.println(solution(new int[]{1,0,1,0,1,1}));
		System.out.println(solution(new int[]{1,0,1,0,1,1,0}));

	}
	public static int solution(int[] A){
		int res = 0;
		int ones = 0;
		for (int i = A.length-1; i >= 0; i--) {
			if (A[i] == 1)
				ones++;
			else {
				res += ones;
				if (res > 1000000000)
					return -1;
			}
		}
		return res;
	}
}
