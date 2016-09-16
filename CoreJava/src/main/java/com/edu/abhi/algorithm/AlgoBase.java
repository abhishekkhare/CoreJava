package com.edu.abhi.algorithm;

public class AlgoBase {
	protected  int[] theArray = new int[50]; // Creates an array with 50 indexes

	protected int arraySize = 9; // Elements in theArray

	// Fills the Array with random values

	public AlgoBase() {
		
	}
	public AlgoBase(int i) {
		for (int j = 0; j < theArray.length; j++) {
			theArray[j]=i;
		}
	}
	
	public AlgoBase(int i,int lenght) {
		for (int j = 0; j < theArray.length; j++) {
			theArray[j]=i;
		}
		arraySize = lenght;
	}

	protected void generateRandomArray(boolean full) {
		
		if(full){
			arraySize = theArray.length;
		}
		for (int i = 0; i < arraySize; i++) {

			// Random number 10 through 19

			theArray[i] = (int) (Math.random() * 10) + 10;

		}

	}
	
	protected void generateRandomArrayBig(boolean full) {

		if (full) {
			arraySize = theArray.length;
		}
		for (int i = 0; i < arraySize; i++) {

			// Random number 10 through 19

			theArray[i] = (int) (Math.random() * 50) + 10;

		}

	}

	protected int[] getTheArray() {

		return theArray;

	}

	protected void swapValues(int indexOne, int indexTwo){	
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
		
	}
	
	protected int getArraySize() {

		return arraySize;

	}

	// Prints the Array on the screen in a grid

	protected void printArray() {

		System.out.println("----------");

		for (int i = 0; i < arraySize; i++) {

			System.out.print("| " + i + " | ");

			System.out.println(theArray[i] + " |");

			System.out.println("----------");

		}

	}

	// Gets value at provided index

	protected int getValueAtIndex(int index) {

		if (index < arraySize)
			return theArray[index];

		return 0;

	}

	protected void printHorzArray(int i, int j) {

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print(": "+ + theArray[n] + " ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		// END OF FIRST PART

		// ADDED FOR BUBBLE SORT

		if (j != -1) {

			// ADD THE +2 TO FIX SPACING

			for (int k = 0; k < ((j * 5) + 2); k++)
				System.out.print(" ");

			System.out.print(j);

		}

		// THEN ADD THIS CODE

		if (i != -1) {

			// ADD THE -1 TO FIX SPACING

			for (int l = 0; l < (5 * (i - j) - 1); l++)
				System.out.print(" ");

			System.out.print(i);

		}

		System.out.println();

	}
	
	protected void printHorzArrayBig(int i, int j) {

		for (int n = 0; n < 300; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 300; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print(String.format("| %2s " + " ", theArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 300; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			int spacesBeforeFront = 5 * i + 1;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("L");

			// Number of spaces to put before the R

			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("H");

			System.out.println("\n");

		}

	}
	
	protected void printHorzArray(int i, int j, int h) {

		if (i == j)
			i = i - h;

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {
			if(n<10)
				System.out.print("| " + theArray[n] + " ");
			else
				System.out.print("|  " + theArray[n] + " ");
		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			//int spacesBeforeFront = 5 * i + 1;

			//for (int k = 0; k < spacesBeforeFront; k++)
				//System.out.print(" ");

			System.out.print("I["+i+"]" + "interval " + h);

			// Number of spaces to put before the R

			//int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			//for (int l = 0; l < spacesBeforeRear; l++)
				//System.out.print(" ");

			System.out.print("O["+j+"]");

			System.out.println("\n");

		}

	}

}
