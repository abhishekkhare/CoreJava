package com.edu.abhi.algorithm.stacksQueue;

import java.util.Arrays;

public class DoubleEndedQueue {
	private String[] queueArray;
	private int queueSize;

	// Sets stack as empty

	private int front, numberOfItems, rear = 0;

	DoubleEndedQueue(int size) {

		queueSize = size;

		queueArray = new String[size];

		// Assigns the value of -1 to every value in the array
		// so I control what gets printed to screen

		Arrays.fill(queueArray, "-1");

	}

	public void insertFront(String input) {
		if (numberOfItems + 1 <= queueSize) {
			for (int i = numberOfItems + 1; i > 0; i--) {
				queueArray[i] = queueArray[i - 1];
			}
			queueArray[0] = input;
			numberOfItems++;
			rear++;
			System.out.println("INSERT " + input + " Was Added to the Stack\n");
		} else {
			System.out.println("Sorry But the Queue is Full");
		}
	}

	public void insertRear(String input) {
		// add element at the end of the queue
		if (numberOfItems + 1 <= queueSize) {
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			System.out.println("INSERT " + input + " Was Added to the Stack\n");
		} else {
			System.out.println("Sorry But the Queue is Full");
		}
	}

	public String peakFront() {
		return queueArray[front];
	}

	public String peakRear() {
		return queueArray[rear - 1];
	}

	public void pollFront() {
		if (numberOfItems > 0) {
			System.out.println("REMOVE " + queueArray[front]
					+ " Was Removed From the Queue\n");
			// Just like in memory an item isn't deleted, but instead is just
			// not available
			queueArray[front] = "-1";

			front++;

			numberOfItems--;
		} else {
			System.out.println("Sorry But the Queue is Empty");
		}
	}

	public void pollRear() {
		if (numberOfItems > 0) {
			System.out.println("REMOVE " + queueArray[rear-1]
					+ " Was Removed From the Queue\n");
			// Just like in memory an item isn't deleted, but instead is just
			// not available
			queueArray[rear-1] = "-1";

			rear--;

			numberOfItems--;
		} else {
			System.out.println("Sorry But the Queue is Empty");
		}
	}

	public void displayTheQueue() {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < queueSize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < queueSize; n++) {

			if (queueArray[n].equals("-1"))
				System.out.print("|     ");

			else
				System.out.print(String.format("| %2s " + " ", queueArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		// Number of spaces to put before the F

		int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

		for (int k = 1; k < spacesBeforeFront; k++)
			System.out.print(" ");

		System.out.print("F");

		// Number of spaces to put before the R

		int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

		for (int l = 0; l < spacesBeforeRear; l++)
			System.out.print(" ");

		System.out.print("R");

		System.out.println("\n");

	}

	public static void main(String a[]) {
		DoubleEndedQueue deq = new DoubleEndedQueue(20);
		deq.insertFront("10");
		deq.insertFront("15");
		deq.insertFront("17");
		deq.insertFront("19");
		deq.displayTheQueue();
		System.out.println("Front-" + deq.peakFront());
		System.out.println("Rear-" + deq.peakRear());

		deq.insertRear("9");
		deq.insertRear("7");
		deq.insertRear("5");
		deq.displayTheQueue();
		System.out.println("Front-" + deq.peakFront());
		System.out.println("Rear-" + deq.peakRear());
		
		deq.pollFront();
		System.out.println("Front-" + deq.peakFront());
		deq.pollRear();
		System.out.println("Rear-" + deq.peakRear());
		deq.displayTheQueue();
	}
}
