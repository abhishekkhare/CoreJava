package com.edu.abhi.algorithm.sort;

import com.edu.abhi.algorithm.AlgoBase;

public class MyMergeSort extends AlgoBase {
	static int count =0;
	
	public MyMergeSort(int i) {
		super(i);
	}
	
	private void mergeSort_srt(int array[], int low, int high) {
		if (low >= high) {
			return;
		}

		// Find the middle index of the array

		int middle = (low + high) / 2;

		// CREATE 2 ARRAYS FROM THE ONE

		// Send the array, 0 and the middle index of the array

		mergeSort_srt(array, low, middle);

		// Send the array, the middle index + 1 and the highest
		// index of the array

		mergeSort_srt(array, middle + 1, high);
		
		/*int end_low = middle;
		int start_high = middle + 1;
		while ((low <= end_low) && (start_high <= high)) {
			if (array[low] < array[start_high]) {
				low++;
			} else {
				int Temp = array[start_high];
				for (int k = start_high - 1; k >= low; k--) {
					array[k + 1] = array[k];
					count++;
				}
				array[low] = Temp;
				count++;
				low++;
				end_low++;
				start_high++;
			}
		}*/
		insertionSortForMerge(low,high);
		
	}
	private void insertionSortForMerge(int low,int high) {
		printHorzArray(low, high);
		System.out.println("low:"+low+" high:" + high);
		for (int i = low+1; i <= high; i++) {
			int j=i;
			int toInsert = theArray[j];
			while((j>low) && theArray[j-1]>toInsert){
				theArray[j]=theArray[j-1];
				count++;
				j--;
			}
			theArray[j]=toInsert;
			count++;
		}
		printHorzArray(low, high);
	}
	
	private void insertionSort() {
		for (int i = 1; i < theArray.length; i++) {
			int j=i;
			int toInsert = theArray[j];
			while((j>0) && theArray[j-1]>toInsert){
				theArray[j]=theArray[j-1];
				j--;
				count++;
			}
			theArray[j]=toInsert;
			count++;
		}
	}
	public static void main(String[] args) {
		MyMergeSort as = new MyMergeSort(100);
		as.generateRandomArray(false);
		MyMergeSort as1 = new MyMergeSort(100);
		as1.generateRandomArray(false);
		//as1.theArray=new int[]{12,19,14,13,20,25,12,15,13,11,10};
		//as1.arraySize=10;
		
		//as.theArray=new int[]{12,19,14,13,20,25,12,15,13,11,10};
		//as.arraySize=10;
				
		//as.bubbleSort();
		//as.selectionSort();
		as.sort();
		as.printHorzArray(0, -1);
		System.out.println("MergeSort:"+count);
		count=0;
		as1.insertionSort();
		as1.printHorzArray(0, -1);
		System.out.println("Insertion Sort:"+count);
		String vendorEmail = "abhi@abc.com";
		String [] vendorEmails = vendorEmail.split(";");
		for (int i = 0; i < vendorEmails.length; i++) {
			System.out.println(vendorEmails[i]);
		}
	}

	private void sort() {
		mergeSort_srt(theArray,0,arraySize);
		
	}
}
