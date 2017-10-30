package com.edu.abhi.algorithm.linkedlist.my2;

public class LinkedList {

	static Link root;
	static Link current;
 
	static int noOfLinkedList = 0;
	
	public void addNode(Link link) {
		if (root == null) {
			root = link;
			root.setNextLink(null);
		} else {
			current = root;
			while (current.getNextLink() != null) {
				current = current.getNextLink();
			}
			current.setNextLink(link);
			link.setNextLink(null);
		}
		noOfLinkedList++;
	}
	
	public void deleteNode(Link link) {
		current = root;
		while (current.getNextLink() != null) {
			if(current.getNextLink().equals(link)){
				current.setNextLink(current.getNextLink().getNextLink());
				noOfLinkedList--;
			}else{
				current =  current.getNextLink();
			}
		}
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
	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		Link l1 = new Link(1, "One");
		lList.addNode(l1);
		lList.print();
		
		Link l2 = new Link(2, "Two");
		lList.addNode(l2);
		lList.print();
		
		Link l3 = new Link(3, "Three");
		lList.addNode(l3);
		lList.print();
		
		Link l4 = new Link(4, "Four");
		lList.addNode(l4);
		lList.print();
		
		lList.deleteNode(l3);
		lList.print();
		
		
	}

}
