package com.edu.abhi.question.codility;
/**
 * https://codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 * @author abhishekkhare
 *
 */
public class CountFactors {

	public static void main(String[] args) {
		//System.out.println(solution(24));
		//System.out.println(solution(56));
		//System.out.println(solution(72));
		//System.out.println(solution(37));
		System.out.println(solution(0));

	}
	public static int solution(int N){
		int count =0;
		for (int i = 1; i <= N/2; i++) {
			if (N % i == 0) {
				count++;
				System.out.println(N + " -- " + i + " == " + count);
			}
		}
		count++;
		return count;
	}
	
}
