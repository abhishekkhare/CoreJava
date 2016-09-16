package com.edu.abhi.algorithm.sort.questions;

import java.util.Arrays;

import com.edu.abhi.algorithm.AlgoBase;

public class Q1 extends AlgoBase {
	public Q1(int i) {
		super(i);
	}

	public Q1(int i, int j) {
		super(i, j);
	}

	public static void main(String[] args) {
		Q1 q1 = new Q1(100);
		q1.generateRandomArray(false);
		Arrays.sort(q1.theArray);
		q1.printHorzArray(q1.arraySize, -1);
		
		Q1 q2 = new Q1(100);
		q2.generateRandomArray(false);
		Arrays.sort(q2.theArray);
		q2.printHorzArray(q2.arraySize, -1);
		
		int x = q1.theArray[q1.arraySize / 2];
		int y = q2.theArray[q2.arraySize / 2];
		
		System.out.println("x="+x);
		System.out.println("y="+y);
		int realMedan = getMedian(q1, q2);
		if (x == y) {
			System.out.println("M=" + x + " realMedian=" + realMedan);
		} else if (x < y) {
			int [] temp = new int[q1.arraySize / 2 + q2.arraySize / 2+1];
			int count=0;
			for (int i = q1.arraySize / 2; i < q1.arraySize; i++) {
				temp[count++] = q1.theArray[i];
			}
			for (int i = 0; i < q2.arraySize / 2; i++) {
				temp[count++] = q2.theArray[i];
			}
			Arrays.sort(temp);
			
			System.out.println("M=" + temp[temp.length/2] + " realMedian=" + realMedan);
		} else {
			int [] temp = new int[q1.arraySize / 2 + q2.arraySize / 2 +1];
			int count=0;
			for (int i = q2.arraySize / 2; i < q2.arraySize; i++) {
				temp[count++] = q2.theArray[i];
			}
			for (int i = 0; i < q1.arraySize / 2; i++) {
				temp[count++] = q1.theArray[i];
			}
			Arrays.sort(temp);
			
			System.out.println("M=" + temp[temp.length/2] + " realMedian=" + realMedan);
			System.out.println("M=" + x + " realMedian=" + realMedan);
		}
	}

	private static int getMedian(Q1 q1, Q1 q2) {
		Q1 q3 = new Q1(100, q1.arraySize + q2.arraySize);
		int count = 0;
		for (int i = 0; i < q1.arraySize; i++) {
			q3.theArray[count++] = q1.theArray[i];
		}

		for (int i = 0; i < q2.arraySize; i++) {
			q3.theArray[count++] = q2.theArray[i];
		}
		q3.printHorzArray(q3.arraySize, -1);
		Arrays.sort(q3.theArray);
		q3.printHorzArray(q3.arraySize, -1);
		return q3.theArray[q3.arraySize / 2];
	}

}
