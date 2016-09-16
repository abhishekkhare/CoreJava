package com.edu.abhi.algorithm.linkedlist.circular;

import com.edu.abhi.algorithm.linkedlist.doubly.DNode;

public class DoublyCircularLinkedList {

	// Declarations are the same!
	static DNode root;
	static DNode current;
	static DNode temp;

	public void addDNode(int data) {
		DNode dNode = new DNode(data);
		if (root == null) {
			root = dNode;
			// previous and next were null - now 'root'
			root.nextNode = root;
			root.previousNode = root;
		} else {
			current = root;
			// root was equal to null - now it's root.
			while (current.nextNode != root) {
				current = current.nextNode;
			}
			// previous
			/*
			 * current.nextNode = dNode; dNode.previousNode = current;
			 * dNode.nextNode = null;
			 */

			// New
			current.nextNode = dNode;
			dNode.nextNode = root;
			dNode.previousNode = current;
			root.previousNode = dNode;
		}
	}

	// remains the same! largely because no roots were used
	public void insertDNode(int data, int after) {
		DNode dNode = new DNode(data);
		int ithDNode = 1;
		current = root;
		while (ithDNode != after) {
			current = current.nextNode;
			ithDNode++;
		}
		temp = current.nextNode;
		current.nextNode = dNode;
		dNode.nextNode = temp;
		temp.previousNode = dNode;
		dNode.previousNode = current;
	}

	public void deleteDNode(int DNodeNumber) {
		int ithDNode = 1;
		current = root;
		if(DNodeNumber == 1){//trying to delete the root element.
			root.nextNode.previousNode = root.previousNode;
			root.previousNode.nextNode = root.nextNode;
			root = root.nextNode;
		} else {
			while (ithDNode != DNodeNumber) {
				current = current.nextNode;
				ithDNode++;
			}
			// new
			current.nextNode.previousNode = current.previousNode;
			current.previousNode.nextNode = current.nextNode;
			current = current.nextNode;
		}
		// add this, you always forget!
		DNode.noOfLinkedList--;
	}

	// a bunch of print functions!
	public void print() {

		current = root;
		boolean arrow = true;

		do {

			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");

			arrow = false;

			current = current.nextNode;

		} while (current != root);

	}

	public void printBackwards() {

		current = root;
		boolean arrow = true;

		do {

			current = current.nextNode;

		} while (current.nextNode != root);

		do {

			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");

			arrow = false;

			current = current.previousNode;

		} while (current != root);

		System.out.print(" --> " + "|" + current.data + "|");

	}

	public void printCont() {

		current = root;
		boolean arrow = true;

		for (int i = 0; i < 15; i++) {

			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");

			arrow = false;

			current = current.nextNode;

		}

	}

	public void printContBackwards() {

		current = root.previousNode;
		boolean arrow = true;

		for (int i = 0; i < 15; i++) {

			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");

			arrow = false;

			current = current.previousNode;

		}

	}

	public static void main(String[] args) {

		DoublyCircularLinkedList list = new DoublyCircularLinkedList();

		list.addDNode(1);
		list.addDNode(2);
		list.addDNode(3);
		list.addDNode(4);
		list.addDNode(5);
		list.addDNode(6);

		list.print();
		System.out.println();
		list.printBackwards();
		System.out.println();
		list.printCont();
		System.out.println();
		list.printContBackwards();

		System.out.println();
		System.out.println("The number of DNodes in the Linked List is "
				+ DNode.noOfLinkedList);

	}
}
