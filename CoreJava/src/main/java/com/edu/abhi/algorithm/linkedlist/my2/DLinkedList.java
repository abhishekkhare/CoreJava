package com.edu.abhi.algorithm.linkedlist.my2;

public class DLinkedList {
	static DLink root;
	static DLink current;
	static int noOfLinkedList;
	public void addNodes(DLink dLink) {
		if (root == null) {
			root = dLink;
			root.setNextLink(null);
			root.setPreLink(null);
		} else {
			current = root;
			while (current.getNextLink() != null) {
				current = current.getNextLink();
			}
			current.setNextLink(dLink);
			dLink.setPreLink(current);
			root.setNextLink(null);
		}
		noOfLinkedList++;
	}

	public void print() {
		current = root;
		boolean arrow = true;
		while (current != null) {
			System.out.print((arrow) ? "|" + current + "|" : " --> " + "|"
					+ current + "|");
			arrow = false;
			current = current.getNextLink();
		}
		System.out.println("The number of nodes in the Linked List is "+ noOfLinkedList);
	}

	public void printBackwards() {
		current = root;
		boolean arrow = true;
		while (current.getNextLink() != null) {
			current = current.getNextLink();
		}
		do {
			System.out.print((arrow) ? "|" + current + "|" : " --> " + "|" + current + "|");
			arrow = false;
			//current = current.getPreLink();
		} while (current.getPreLink() != null);
		System.out.print(" --> " + "|" + current + "|");
	}

	public static void main(String[] args) {
		DLinkedList dl = new DLinkedList();
		
		DLink d1 = new DLink(1,"One");
		dl.addNodes(d1);
		dl.print();
		System.out.println();
		//dl.printBackwards();
		System.out.println();
		
		DLink d2 = new DLink(2,"Two");
		dl.addNodes(d2);
		dl.print();
		System.out.println();
		//dl.printBackwards();
		System.out.println();
		
		DLink d3 = new DLink(3,"Three");
		dl.addNodes(d3);
		dl.print();
		System.out.println();
		//dl.printBackwards();
		System.out.println();
		
		DLink d4 = new DLink(4,"Four");
		dl.addNodes(d4);
		dl.print();
		System.out.println();
		//dl.printBackwards();
		System.out.println();
	}

}
