package com.edu.abhi.algorithm.sort;

import com.edu.abhi.algorithm.AlgoBase;

/**
 * This is a Java Program to implement Heap Sort on an integer array. Heapsort
 * is a comparison-based sorting algorithm to create a sorted array (or list),
 * and is part of the selection sort family. Although somewhat slower in
 * practice on most machines than a well-implemented quicksort, it has the
 * advantage of a more favorable worst-case O(n log n) runtime.
 * 
 * Heapsort is an in-place algorithm, but it is not a stable sort. Worst case
 * performance : O(n log n) Best case performance : O(n log n) Average case
 * performance : O(n log n)
 * 
 */
public class HeapSort extends AlgoBase {
	int N;
	public HeapSort(int x) {
		super(x);
		N=arraySize;
	}

	/** Function to build a heap */
	private void heapify() {
		int n = N - 1;
		for (int i = n / 2; i >= 0; i--)
			maxheap(i);
	}

	private void maxheap(int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && theArray[left] > theArray[i])
			max = left;
		if (right <= N && theArray[right] > theArray[max])
			max = right;

		if (max != i) {
			swapValues(i, max);
			maxheap(max);
		}

	}

	private void heapSort() {
		heapify();        
        for (int i = N; i > 0; i--)
        {
        	swapValues(0, i);
            N = N-1;
            maxheap(0);
        }
		
	}
	
	public static void main(String[] args) {
		HeapSort hs = new HeapSort(100);
		hs.generateRandomArray(false);
		hs.printHorzArray(0, hs.arraySize);
		hs.heapSort();
		hs.printHorzArray(0, hs.arraySize);
	}

	

}
