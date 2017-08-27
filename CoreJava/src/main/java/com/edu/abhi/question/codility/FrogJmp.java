package com.edu.abhi.question.codility;

/**
 * https://codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 * @author abhishekkhare
 *
 */
public class FrogJmp {

	public static void main(String[] args) {
//		System.out.println(solution(10,85,30));
//		System.out.println(solution(10,85,5));
//		System.out.println(solution(95,85,5));
//		System.out.println(solution(85,85,5));
		System.out.println(solution(10,12,5));
		
	}
	public static int solution(int X, int Y, int D){
		int count =(Y-X)/D;
		int rem = (Y-X)%D;
		System.out.println(D+ " "+count +" -- "+ rem);
		if(rem>0){
			count++;
		}
		if(count<0){
			count=0;
		}
		return count;
	}
}
