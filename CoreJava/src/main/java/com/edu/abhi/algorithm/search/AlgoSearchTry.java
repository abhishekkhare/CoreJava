package com.edu.abhi.algorithm.search;

import java.util.Arrays;

import com.edu.abhi.algorithm.AlgoBase;

public class AlgoSearchTry extends AlgoBase {

	public AlgoSearchTry(int i) {
		super(i);
	}

	public AlgoSearchTry() {
		super();
	}

	public int getValueAtIndex(int index) {
		if (arraySize > index) {
			return theArray[index];
		}

		throw new ArrayIndexOutOfBoundsException(index);
	}

	protected boolean doesArrayContainThisValue(int searchValue) {
		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == searchValue)
				return true;
		}
		return false;
	}

	// Delete Array row for the index and move elements up

	private void deleteIndex(int index) {
		for (int i = index; i < arraySize - 1; i++) {
			theArray[i] = theArray[i + 1];
		}
		arraySize--;
	}

	private void insertValue(int value) {
		if (arraySize < theArray.length) {
			theArray[arraySize] = value;
			arraySize++;
			return;
		}

		throw new ArrayIndexOutOfBoundsException();
	}

	// Linear Search : Every index must be looked at
	private String linearSearchForValue(int value) {
		boolean found = false;
		String arrayIndexes = "The value was found in following indexes ";
		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == value) {
				found = true;
				arrayIndexes += ":" + i;
			}
		}
		if (!found) {
			arrayIndexes += ":None";
		}
		return arrayIndexes;
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
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		while (lowIndex <= highIndex) {
			int middleIndex = (highIndex + lowIndex) / 2;
			if (theArray[middleIndex] < value)
				lowIndex = middleIndex + 1;
			else if (theArray[middleIndex] > value)
				highIndex = middleIndex - 1;
			else {
				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
				lowIndex = highIndex + 1;
			}
			printHorzArray(middleIndex, -1);
			System.out.println(lowIndex + " - " + highIndex + " : " + value);
		}
	}

	public static void main(String[] args) {
		AlgoSearchTry ast = new AlgoSearchTry(100);
		ast.generateRandomArray(false);
		ast.printArray();
		System.out.println(ast.getValueAtIndex(5));
		System.out.println(ast.doesArrayContainThisValue(17));
		ast.deleteIndex(8);
		ast.insertValue(109);
		ast.printArray();
		System.out.println(ast.linearSearchForValue(13));
		ast.binarySearchForValue(13);
	}

}
