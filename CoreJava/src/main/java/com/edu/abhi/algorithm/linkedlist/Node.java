package com.edu.abhi.algorithm.linkedlist;

public class Node {
	public static int noOfLinkedList = 0;
	public int data;
	public Node nextNode;

	public Node(int data) {
		this.data = data;
		noOfLinkedList++;
	}
}
