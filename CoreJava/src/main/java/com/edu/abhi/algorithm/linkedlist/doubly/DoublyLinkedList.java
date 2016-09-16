package com.edu.abhi.algorithm.linkedlist.doubly;

public class DoublyLinkedList {

	static DNode root;
	static DNode temp;
	static DNode current;

	public void addNodes(int data) {

		DNode dNode = new DNode(data);

		if (root == null) {
			root = dNode;
			root.previousNode = null;
			root.nextNode = null;

		} else {
			current = root;
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = dNode;
			dNode.previousNode = current;
			dNode.nextNode = null;
		}
	}

	public void insertAfterNode(int data, int after) {
		DNode dNode = new DNode(data);
		int ithNode = 1;
		current = root;
		while (ithNode != after) {
			current.nextNode = root;
			ithNode++;
		}
		temp = current.nextNode;
		current.nextNode = dNode;
		dNode.nextNode = temp;
		temp.previousNode = dNode;
		dNode.previousNode = current;
	}

	public void insertBeforeNode(int data, int before) {
		insertAfterNode(data, before - 1);
	}

	public void deleteNode(int nodeNumber) {
		int ithNode = 1;
		current = root;
		if (nodeNumber == 1) {
			root = current.nextNode;
			current.nextNode = null;
			current.previousNode = null;
		} else {
			while (ithNode != nodeNumber) {
				current = current.nextNode;
				ithNode++;
			}
			if (current.nextNode == null) {// trying to remove the last node.
				current.previousNode.nextNode = null;
				current.previousNode = null;
			} else {
				current.previousNode.nextNode = current.nextNode;
				current.nextNode.previousNode = current.previousNode;
			}

		}

	}

	public void print() {

		current = root;
		boolean arrow = true;

		do {

			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");

			arrow = false;

			current = current.nextNode;

		} while (current != null);

	}

	public void printBackwards() {

		current = root;
		boolean arrow = true;

		while (current.nextNode != null) {

			current = current.nextNode;

		}

		do {

			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");

			arrow = false;

			current = current.previousNode;

		} while (current.previousNode != null);

		System.out.print(" --> " + "|" + current.data + "|");

	}

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();

		list.addNodes(1);
		list.addNodes(2);
		list.addNodes(3);
		list.addNodes(4);
		list.addNodes(5);
		list.addNodes(6);

		list.print();
		System.out.println();
		list.deleteNode(6);
		list.print();
		/*list.printBackwards();

		System.out.println();
		System.out.println("The number of DNodes in the Linked List is "
				+ DNode.noOfLinkedList);*/

	}
}
