package com.edu.abhi.algorithm.sort;

import com.edu.abhi.algorithm.AlgoBase;

public class AlgoElementrySort extends AlgoBase {
	public AlgoElementrySort(int i) {
		super(i);
	}

	/**
	 * O(n^2)
	 */
	private void bubbleSort() {
		System.out.println("Bubble Sort Start");
		int count = 0;
		printHorzArray(arraySize, -1);
		for (int i = 0; i < arraySize; i++) {
			// Remember to run the second loop only got arraySize-i
			for (int j = 0; j < (arraySize - i); j++) {
				count++;
				if (theArray[j] > theArray[j + 1]) {
					swapValues(j, j + 1);
					printHorzArray(j, j + 1);
				}
			}
		}
		System.out.println("Bubble Sort End " + count);
	}

	private void bubbleSortDescending() {
		System.out.println("Bubble Sort Desc Start");
		int count = 0;
		printHorzArray(arraySize, -1);
		for (int i = 0; i < arraySize; i++) {
			// Remember to run the second loop only got arraySize-i
			for (int j = 0; j < (arraySize - i); j++) {
				count++;
				if (theArray[j] < theArray[j + 1]) {
					swapValues(j, j + 1);
					printHorzArray(j, j + 1);
				}
			}
		}
		System.out.println("Bubble Sort Desc End " + count);
	}

	/**
	 * Selection sort search for the smallest number in the array saves it in
	 * the minimum spot and then repeats searching through the entire array each
	 * time
	 */
	private void selectionSort() {
		System.out.println("Selection Sort  Start");
		printHorzArray(arraySize, -1);
		int count = 0;
		for (int x = 0; x < arraySize; x++) {
			int minimum = x;
			for (int y = x; y < arraySize; y++) {
				count++;
				// System.out.println(theArray[minimum] + " - " +minimum +" % "
				// + theArray[y]+" - " + y);
				if (theArray[minimum] > theArray[y]) {
					minimum = y;
				}
			}
			swapValues(x, minimum);
			printHorzArray(x, minimum);
		}
		System.out.println("Selection Sort  End " + count);

	}

	/**
	 * The Insertion Sort is normally the best of the elementary sorts. Unlike
	 * the other sorts that had a group sorted at any given time, groups are
	 * only partially sorted here.
	 */
	private void insertionSort() {
		System.out.println("Insertion Sort  Start");
		printHorzArray(arraySize, -1);
		//int count = 0;
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1] > toInsert)) {
				//count++;
				theArray[j] = theArray[j - 1];
				j--;
				printHorzArray(i, j);
			}
			theArray[j] = toInsert;
			printHorzArray(i, j);
			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = "+ theArray[j] + " toInsert = " + toInsert + "\n");
		}
		//System.out.println("Insertion Sort  End " + count);

	}

	/**
	 * To change direction of sort just change this from > to <
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AlgoElementrySort as = new AlgoElementrySort(100);
		as.generateRandomArray(false);
		as.bubbleSort();
	//	as.bubbleSort();
	//	as.generateRandomArray(false);
	//	as.bubbleSortDescending();
	//	as.generateRandomArray(false);
	//	as.selectionSort();
	//	as.generateRandomArray(false);
	//	as.insertionSort();
	}

}
