package com.edu.abhi.algorithm.sort;

import com.edu.abhi.algorithm.AlgoBase;

public class BasicSortsTry extends AlgoBase {
	
	public BasicSortsTry(int i) {
		super(i);
	}

	private void bubbleSort() {
		for (int i = theArray.length-1; i >1; i--) {
			for (int j = 0; j < i; j++) {
				if(theArray[j]>theArray[j+1]){
					swapValues(j, j+1);
					printHorzArray(j, j+1);
				}
			}
		}
		printHorzArray(0, theArray.length);
	}
	
	/**
	 * Selection sort search for the smallest number in the array saves it in
	 * the minimum spot and then repeats searching through the entire array each
	 * time
	 */
	private void selectionSort() {
		for (int i = 0; i < theArray.length; i++) {
			int min =i;
			for (int j = i; j < theArray.length; j++) {
				if(theArray[min]>theArray[j]){
					min =j;
				}
			}
			printHorzArray(i, -1);
			swapValues(min, i);
			printHorzArray(i, -1);
		}
	}
	
	/**
	 * The Insertion Sort is normally the best of the elementary sorts. Unlike
	 * the other sorts that had a group sorted at any given time, groups are
	 * only partially sorted here.
	 */
	private void insertionSort() {
		printHorzArray(0, -1);
		for (int i = 1; i < theArray.length; i++) {
			int j=i;
			int toInsert = theArray[j];
			while((j>0) && theArray[j-1]>toInsert){
				theArray[j]=theArray[j-1];
				j--;
			}
			theArray[j]=toInsert;
		}
		printHorzArray(0, -1);
	}
	
	public static void main(String[] args) {
		BasicSortsTry as = new BasicSortsTry(100);
		as.generateRandomArray(false);
		//as.bubbleSort();
		//as.selectionSort();
		as.insertionSort();

	}

	

}
