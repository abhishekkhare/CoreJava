package com.edu.abhi.algorithm.linkedlist.m1;

public class LinkedList {

	private class Node {
		public int i;
		public Node next;

		Node(int i) {
			this.i = i;
		}
		
		@Override
		public String toString() {
			return i+"";
		}

	}

	public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.displayLinkedList();
		l.insertNode(1);
		l.insertNode(2);
		l.insertNode(3);
		l.insertNode(4);
		l.displayLinkedList();
		
		l.find(5);
		l.insertNode(5);
		l.find(5);
		l.deleteNode(3);
		l.displayLinkedList();
	}
	
	private void deleteNode(int i) {
		if (isEmpty()) {
			System.out.println("Empty List");
			return;
		}
		Node focusNode = firstNode;
		while (focusNode.next != null) {
			if(focusNode.next.i==i){
				focusNode.next = focusNode.next.next;
				return;
			}
			focusNode = focusNode.next;
		}
		
		System.out.println(i +" was Not Found");
	}

	Node firstNode = null;

	public void find(int i){
		if (isEmpty()) {
			System.out.println("Empty List");
			return;
		}
		Node focusNode = firstNode;
		while (focusNode != null) {
			if(focusNode.i==i){
				System.out.println(i + " was Found");
				return;
			}
			focusNode = focusNode.next;
		}
		System.out.println(i +" was Not Found");
	}
	public void displayLinkedList(){
		if (isEmpty()) {
			System.out.println("Empty List");
			return;
		}
		Node focusNode = firstNode;
		while (focusNode != null) {
			System.out.print(focusNode.i + " -> ");
			focusNode = focusNode.next;
		}
		System.out.println();
	}
	public void insertNode(int i) {
		Node newNode = new Node(i);
		newNode.next=firstNode;
		firstNode=newNode;

	}

	public boolean isEmpty() {
		if (firstNode == null) {
			return true;
		}
		return false;
	}
}
