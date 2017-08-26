package com.edu.abhi.question.codility;

import java.util.Arrays;

public class ChocolatesByNumbers {

	public static void main(String[] args) {
		System.out.println(solution(10,4));
		//System.out.println(solution(20,7));
		//System.out.println(solution(13,7));
		System.out.println(solution(3,5));
	}

	public static int solution(int N, int M){
		int [] temp = new int[N];
		int count=0;
		Arrays.fill(temp, 1);
		for (int i = 0;true ;) {
			System.out.println("i=" + i + " -- "+Arrays.toString(temp));
			temp[i]=0;
			count++;
			if((i+M)<N)
				i=i+M;
			else
				i=(i+M)%N;
			if(temp[i]==0)
				break;
		}
		
		return count;
	}
}
