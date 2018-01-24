package com.edu.abhi.algorithm.search;

import com.edu.abhi.algorithm.AlgoBase;

import java.util.Arrays;

/**
 * @author abhishekkhare
 *
 */
public class AlgoSearch extends AlgoBase {
	public AlgoSearch(int i) {
		super(i);
	}

	public AlgoSearch() {
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
			if (theArray[i] == searchValue) {
				return true;
			}
		}
		return false;
	}

	// Delete Array row for the index and move elements up

	private void deleteIndex(int index) {
		if (arraySize > index) {
			for (int i = index; i < arraySize - 1; i++) {
				theArray[i] = theArray[i + 1];
			}
			arraySize--;
			return;
		}

		throw new ArrayIndexOutOfBoundsException(index);
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

				System.out.println("\nFound a Match for " + value
						+ " at Index " + middleIndex);

				lowIndex = highIndex + 1;

			}

			printHorzArray(middleIndex, -1);
			System.out.println(lowIndex + " - " + highIndex + " : " + value);

		}
	}

	public static void main(String[] args) {
		AlgoSearch as = new AlgoSearch(100);

		as.generateRandomArray(false);
		as.printArray();
		as.deleteIndex(3);
		as.insertValue(13);
		as.insertValue(15);
		as.insertValue(17);
		as.insertValue(18);
		as.insertValue(19);
		as.printArray();
		for (int i = 0; i < 10; i++) {
			System.out.println(10 + i + as.linearSearchForValue(10 + i));
			System.out.println(11 + i + as.linearSearchForValue(11 + i));
			System.out.println(12 + i + as.linearSearchForValue(12 + i));
		}
		as.deleteIndex(3);
		as.deleteIndex(3);
		as.deleteIndex(3);
		// as.generateRandomArray(false);
		// as.printArray();
		as.binarySearchForValue(18);
	}

}
