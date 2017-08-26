package com.edu.abhi.question.codility;

public class CountDiv {

	public static void main(String[] args) {
		
//		System.out.println(solution(6,15, 2));
//		System.out.println(solution(6,11, 2));
//		System.out.println(solution(6,15, 3));
//		System.out.println(solution(6,11, 5));
//		System.out.println(solution(5,15, 5));
//		System.out.println(solution(10,15, 5));
//		System.out.println(solution(10,52, 5));
		System.out.println(solution(11,345, 17));
		System.out.println(solution(7,52, 5));
		System.out.println(solution(10,10, 20));
		
		
	}
	
	public static int solution(int A, int B, int K){
		int count =0;
		int count1 = (B-A)/K;
		if(B%K==0 || A%K==0 || (A<K && count1>0))
			count1++;
		for (int i = A; i <= B; i++) {
			if(i%K==0){
				System.out.println(i);
				count++;
			}
		}
		System.out.println(count + " --- " + count1);
		return count1;
	}

}
