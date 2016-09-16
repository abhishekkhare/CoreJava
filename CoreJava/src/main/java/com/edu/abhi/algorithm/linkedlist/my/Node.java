package com.edu.abhi.algorithm.linkedlist.my;

public class Node {
	public static int noOfNodes=0;
	public Node nextNode;
	public int data;
	
	public Node(int data){
		this.data = data;
		noOfNodes++;
	}
}
