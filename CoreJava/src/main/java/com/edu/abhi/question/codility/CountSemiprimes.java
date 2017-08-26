package com.edu.abhi.question.codility;

import java.util.Arrays;

public class CountSemiprimes {

	public static void main(String[] args) {
//		countPrimes(1,26);
//		countPrimes(4,10);
//		countPrimes(16,20);
//		countPrimes(13,23);
		int[] A = new int[] {1,4,16};
		int[] B = new int[]{26,10,20};
		int N = 26;
		//System.out.println(Arrays.toString(solution(N,A,B)));
		N=1;
		//System.out.println(Arrays.toString(solution(N,A,B)));
		N=4;
		System.out.println(Arrays.toString(solution(N,A,B)));

	}

	public static int[] solution(int N, int[] P, int[] Q) {
		int size = P.length;
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			if(P[i]>=1 && P[i]<=Q[i] && Q[i]<=N){
				System.out.println(P[i] + " - "+Q[i]);
				int temp = countPrimes(P[i], Q[i],N);
			res[i] = temp;
			}
		}

		return res;
	}

	public static int countPrimes(int s1, int s2,int N) {
		int [] temp = new int[s2];
		Arrays.fill(temp, 0);
		temp[0]=1;
		temp[1]=2;
		int index =1;
		int count=0;
		int flag = 0;
		for (int i = 1; i <= s2/2; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = 0;
					break;
				} else {
					flag = 1;
				}
			}
			if (flag == 1) {
				System.out.println(i);
				index++;
				temp[index]=i;
			}
		}
		System.out.println(Arrays.toString(temp));
		for (int i = 1; i < temp.length && temp[i]!=0; i++) {
			for (int j = i; j < temp.length && temp[j]!=0; j++) {
				int mul =  temp[i]*temp[j];
				if(mul>=s1 && mul<=s2){
					System.out.println(temp[i]+"*"+temp[j] + " = "+mul);
					count++;
				}
			}
		}
		return count;
	}
}
