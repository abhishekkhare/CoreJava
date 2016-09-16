package com.edu.abhi.algorithm.linkedlist;

public class TestLinkList {
	public static void main(String[] args) {

		LinkList theLinkedList = new LinkList();

		// Insert Link and add a reference to the book Link added just prior
		// to the field next

		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone",
				107);

		theLinkedList.display();

		System.out.println("Value of first in LinkedList "
				+ theLinkedList.firstLink + "\n");

		// Removes the last Link entered

		theLinkedList.removeFirst();

		theLinkedList.display();

		System.out.println(theLinkedList.find("The Lord of the Rings").bookName
				+ " Was Found");

		theLinkedList.removeLink("A Tale of Two Cities");

		System.out.println("\nA Tale of Two Cities Removed\n");

		theLinkedList.display();

	}
}
