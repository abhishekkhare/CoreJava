package com.edu.abhi.algorithm.linkedlist.doubly;

public class DNode {
	public static int noOfLinkedList = 0;

	public int data;

	public DNode previousNode;
	public DNode nextNode;

	public DNode(int data) {

		this.data = data;
		noOfLinkedList++;

	}
}
