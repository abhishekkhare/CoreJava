package com.edu.abhi.algorithm.tree;

public class Node {
	public Node leftChild;
	public Node rightChild;

	public int data;
	public String name;

	public Node(int data) {
		this.data = data;
		this.name = ""+data;
	}
	
	public Node(int data, String name) {
		this.data = data;
		this.name = name;
	}

	public String toString() {
		return name + " has data " + data;
	}

}
