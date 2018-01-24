package com.edu.abhi.algorithm.search;

import com.edu.abhi.algorithm.AlgoBase;

import java.util.Arrays;

public class AlgoSearchTry2 extends AlgoBase {

	public AlgoSearchTry2(int i) {
		super(i);
	}

	public AlgoSearchTry2() {
		super();
	}

	public int getValueAtIndex(int index) {
		if(index<arraySize){
			return theArray[index];
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	protected boolean doesArrayContainThisValue(int searchValue) {
		boolean flag = false;
		for (int i = 0; i < theArray.length; i++) {
			if(theArray[i]==searchValue){
				System.out.println("Found at " + i);
				flag = true;
			}
		}
		return flag;
	}

	// Delete Array row for the index and move elements up

	private void deleteIndex(int index) {
		if(index<arraySize){
			for (int i = index; i < arraySize-1; i++) {
				theArray[i]=theArray[i+1];
			}
			arraySize--;
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	private void insertValue(int value) {
		if(arraySize<theArray.length){
			theArray[arraySize]=value;
			arraySize++;
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	// Linear Search : Every index must be looked at
	private String linearSearchForValue(int value) {
		String output="";
		for (int i = 0; i < theArray.length; i++) {
			if(theArray[i]==value){
				output +="Found at " + i + " :: ";
			}
		}
		return output;
	}
	
	/**
	 * The Binary Search is quicker than the linear search because all the
	 * values are sorted. Because everything is sorted once you get to a number
	 * larger than what you are looking for you can stop the search. Also you be
	 * able to start searching from the middle which speeds the search. It also
	 * works best when there are no duplicates
	 * 
	 * @param value
	 */
	private void binarySearchForValue(int value) {
		Arrays.sort(theArray);
		int low =0;
		int high = theArray.length;
		printHorzArray(low, high);
		while(low<=high){
			int mid = (low+high)/2;
			if(theArray[mid]<value){
				low=mid+1;
			}else if(theArray[mid]>value){
				high=mid-1;
			}else{
				System.out.println("Found::" +mid);
				low=high+1;
			}
		}
	}

	public static void main(String[] args) {
		AlgoSearchTry2 ast = new AlgoSearchTry2(100);
		ast.generateRandomArray(false);
		/*{
			
			ast.printArray();
			System.out.println(ast.getValueAtIndex(5));
			System.out.println(ast.doesArrayContainThisValue(17));
			ast.deleteIndex(8);
			ast.insertValue(109);
			ast.printArray();
			System.out.println(ast.linearSearchForValue(13));
		}*/
		
		{
			ast.binarySearchForValue(13);	
		}
		
		
	}

}
