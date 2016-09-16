package com.edu.abhi.algorithm.sort;

import com.edu.abhi.algorithm.AlgoBase;

public class AlgoAdvancedShellSort extends AlgoBase {

	public AlgoAdvancedShellSort(int i) {
		super(i);
	}

	/**
	 * The method starts by sorting elements far apart from each other and
	 * progressively reducing the gap between them. Starting with far apart
	 * elements can move some out-of-place elements into position faster than a
	 * simple nearest neighbor exchange.
	 */
	private void shellSort(int x) {
		System.out.println("Shell Sort Start");
		int compare = 0;
		int swap = 0;

		int inner, outer, temp;

		int interval = 1;
		while (interval <= arraySize / x) {

			// Define an interval sequence

			interval = interval * x + 1;
			System.out.println("interval " + interval);
		}
		// Keep looping until the interval is 1
		// Then this becomes an insertion sort

		while (interval > 0) {

			// Continue incrementing outer until the end of the array is reached

			for (outer = interval; outer < arraySize; outer++) {

				// Store the value of the array in temp unless it has to be
				// copied to a space occupied by a bigger number closer to the
				// beginning of the array

				temp = theArray[outer];

				System.out.println("Copy " + theArray[outer] + " into temp");

				// inner is assigned the value of the highest index to check
				// against all values the proceed it. Along the way if a
				// number is greater than temp it will be moved up in the array

				inner = outer;

				System.out.println("Checking if " + theArray[inner - interval]
						+ " in index " + (inner - interval)
						+ " is bigger than " + temp);

				// While there is a number bigger than temp move it further
				// up in the array

				while (inner > interval - 1
						&& theArray[inner - interval] >= temp) {

					System.out.println("In While Checking if "
							+ theArray[inner - interval] + " in index "
							+ (inner - interval) + " is bigger than " + temp);

					printHorzArray(inner, outer, interval);

					// Make room for the smaller temp by moving values in the
					// array
					// up one space if they are greater than temp

					theArray[inner] = theArray[inner - interval];

					System.out.println(theArray[inner - interval]
							+ " moved to index " + inner);

					inner -= interval;

					System.out.println("inner= " + inner);

					printHorzArray(inner, outer, interval);

					System.out.println("outer= " + outer);
					System.out.println("temp= " + temp);
					System.out.println("interval= " + interval);

				}

				// Now that everything has been moved into place put the value
				// stored in temp into the index above the first value smaller
				// than it is

				theArray[inner] = temp;

				System.out.println(temp + " moved to index " + inner);

				printHorzArray(inner, outer, interval);

			}

			// Once we get here we have interval sorted our array
			// so we decrement interval and go again

			interval = (interval - 1) / x;
		}

		System.out.println("Shell Sort Start + compare:" + compare + " swap:"
				+ swap);
	}

	private void shellSortSelf(int x) {
		int interval = 1;
		while (interval <= arraySize / x) {

			// Define an interval sequence

			interval = interval * x + 1;
		}
		while (interval > 1) {
			System.out.println("interval " + interval);
			int tempInterval = interval;
			for (int i = 0; i < arraySize && tempInterval < arraySize; i++, tempInterval++) {
				int tempIValue = theArray[i];
				int tempIntervalValue = theArray[tempInterval];
				printHorzArray(i, tempInterval, interval);
				if (tempIValue > tempIntervalValue) {
					swapValues(i, tempInterval);
				}
			}

			interval = (interval - 1) / x;
		}
		insertionSort();
	}

	private void insertionSort() {
		System.out.println("Insertion Sort  Start");
		printHorzArray(arraySize, -1);
		int count = 0;
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1] > toInsert)) {
				count++;
				theArray[j] = theArray[j - 1];
				j--;
				printHorzArray(i, j);
			}
			theArray[j] = toInsert;
			printHorzArray(i, j);
			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = "
					+ theArray[j] + " toInsert = " + toInsert + "\n");
		}
		System.out.println("Insertion Sort  End " + count);

	}

	public static void main(String[] args) {

		AlgoAdvancedShellSort as = new AlgoAdvancedShellSort(100);
		as.generateRandomArrayBig(true);

		as.printHorzArrayBig(as.arraySize, -1);
		as.shellSortSelf(3);
	
	}

}
