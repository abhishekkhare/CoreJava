package com.edu.abhi.algorithm.linkedlist.m1;

public class DoubleLinkedList {
	
	private DNode root;
	private DNode current;
	
	private class DNode {
		public int i;
		public DNode next;
		public DNode previous;
		
		public DNode(int i){
			this.i = i;
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList dl = new DoubleLinkedList();
		
		dl.displayForwardLinkedList();
		dl.displaybackwardLinkedList();
		
		dl.insertNode(1);
		dl.insertNode(2);
		dl.insertNode(3);
		dl.insertNode(4);
		dl.displayForwardLinkedList();
		dl.displaybackwardLinkedList();
		dl.insertAfterNode(35,3);
		dl.displayForwardLinkedList();
		dl.insertBeforeNode(-1);

		dl.find(5);
		dl.insertNode(5);
		dl.find(5);
		dl.deleteNode(3);
	}

	private void insertNode(int i) {
		DNode newNode = new DNode(i); 
		if(root==null){
			root =newNode;
			root.next=null;
			root.previous=null;
			current = root;
		}else{
			current.next = newNode;
			newNode.previous = current;
			newNode.next =null;
			current = newNode;
		}
		
	}

	private void insertBeforeNode(int i) {}

	private void deleteNode(int i) {
		// TODO Auto-generated method stub

	}

	private void find(int i) {
		// TODO Auto-generated method stub

	}

	private void insertAfterNode(int i, int j) {
		int count=1;
		DNode focusNode = root;
		while(count<j || focusNode==null){
			focusNode = focusNode.next;
			count++;
		}
		
		// A --> B ; B <-- A
		// N-->B; A<--N
		// N<--B;A-->N
		DNode newNode = new DNode(i);
		newNode.next=focusNode.next;
		newNode.previous = focusNode.next.previous;
		focusNode.next.previous = newNode;
		focusNode.next=newNode;
		
	}

	private void displayForwardLinkedList() {
		if (root==null) {
			System.out.println("Empty List");
			return;
		}
		DNode focusNode = root;
		while (focusNode != null) {
			System.out.print(focusNode.i + " -> ");
			focusNode = focusNode.next;
		}
		System.out.println();
	}

	private void displaybackwardLinkedList() {
		if (root==null) {
			System.out.println("Empty List");
			return;
		}
		DNode focusNode = current;
		while (focusNode != null) {
			System.out.print(focusNode.i + " -> ");
			focusNode = focusNode.previous;
		}
		System.out.println();
	}
}
