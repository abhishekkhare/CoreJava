package com.edu.abhi.question.codility;

import java.util.Set;
import java.util.TreeSet;

public class CommonPrimeDivisors {

	public static void main(String[] args) {

//		findPrimeDivisors(15);
//		findPrimeDivisors(75);
//		findPrimeDivisors(100);
//		findPrimeDivisors(221);
//		System.out.println(solution(new int[]{15,10,3}, new int[]{75,30,5}));
//		System.out.println(solution(new int[]{15,10,3,15}, new int[]{75,30,5,75}));
//		System.out.println(solution(new int[]{15,10,3,15,13}, new int[]{75,30,5,75,8}));
//		System.out.println(solution(new int[]{15,10,3,15,90}, new int[]{75,30,5,75,90}));
		System.out.println(solution(new int[]{15,10,3,15,90,169}, new int[]{75,30,5,75,90,169}));
//		System.out.println(solution(new int[]{1}, new int[]{1}));
//		System.out.println(solution(new int[]{2}, new int[]{2}));

	}

	private static Set<Integer> findPrimeDivisors(int x) {
		Set<Integer> temp = new TreeSet<Integer>();
		System.out.println("--- " + x);
		for (int i = 1; i <= x ; i++) {
			System.out.println("**"+i);
			if (x % i == 0) {
				System.out.println("++"+i);
				if (isPrime(i)){
					System.out.println(i);
					temp.add(i);
				}
			}
		}
		System.out.println(temp);
		return temp;
	}

	private static boolean isPrime(int n) {
		int i,m=0;
		m = n / 2;
		for (i = 2; i <= m; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int solution(int[] A, int[] B) {
		int size = A.length;
		int count=0;
		for (int i = 0; i < size; i++) {
			Set<Integer> tA = findPrimeDivisors(A[i]);
			Set<Integer> tB = findPrimeDivisors(B[i]);
			System.out.println("A:" + tA);
			System.out.println("B:" + tB);
			if(tA.size()!=tB.size()){
				//ignore
			}else if(tA.size()>0 && tA.containsAll(tB)){
				System.out.println("True");
				count++;
			}
		}
		return count;
	}
}
