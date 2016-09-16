package com.edu.abhi.others;

import java.util.ArrayList;
import java.util.List;

public class MemorryErrors {
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		// stackOverflowError(0);
		outOfMemoryError();
	}

	private static void outOfMemoryError() {

		int iteratorValue = 20;
		System.out.println("\n=================> OOM test started..\n");
		for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
			System.out.println("Iteration " + outerIterator + " Free Mem: "
					+ Runtime.getRuntime().freeMemory());
			int loop1 = 2;
			int[] memoryFillIntVar = new int[iteratorValue];
			// feel memoryFillIntVar array in loop..
			do {
				memoryFillIntVar[loop1] = 0;
				loop1--;
			} while (loop1 > 0);
			iteratorValue = iteratorValue * 5;
			System.out.println("\nRequired Memory for next loop: "
					+ iteratorValue);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void stackOverflowError(int x) {
		while (true) {
			x++;
			System.out.println(x);
			stackOverflowError(x);
		}

	}

}
