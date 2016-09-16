package com.edu.abhi.algorithm.linkedlist;

public class LinkedList {
	static Node root;
	static Node current;
	static Node temp;

	public void addNode(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
			root.nextNode = null;
		} else {
			current = root;
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = node;
			node.nextNode = null;
		}
	}

	public void insertAfterNode(int data, int after) {
		int ithNode = 1;
		Node node = new Node(data);
		current = root;
		while (ithNode != after) {
			current = current.nextNode;
			ithNode++;
		}
		temp = current.nextNode;
		current.nextNode = node;
		node.nextNode = temp;
	}

	public void insertBeforeNode(int data, int before) {
		insertAfterNode(data,before-1);
	}
	
	public void deleteNode(int nodeNumber) {
		int ithNode = 1;
		current = root;
		//if trying to delete the root node.
		if (nodeNumber == 1) {
			root = current.nextNode;
		} else {
			while (ithNode != nodeNumber - 1) {
				current = current.nextNode;
				ithNode++;
			}
			current.nextNode = current.nextNode.nextNode;
		}
		Node.noOfLinkedList--;
		// System.out.println(current.data);
	}

	public void print() {
		current = root;
		boolean arrow = true;
		while (current != null) {
			System.out.print((arrow) ? "|" + current.data + "|" : " --> " + "|"
					+ current.data + "|");
			arrow = false;
			current = current.nextNode;
		}
		System.out.println("The number of nodes in the Linked List is "+ Node.noOfLinkedList);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addNode(1);
		list.insertAfterNode(22, 1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.print();
		//list.insertNode(43, 2);
		list.addNode(7);
		list.print();
		System.out.println();
	}
}
