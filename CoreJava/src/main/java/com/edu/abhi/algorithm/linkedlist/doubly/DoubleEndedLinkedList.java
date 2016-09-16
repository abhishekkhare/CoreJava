package com.edu.abhi.algorithm.linkedlist.doubly;

//A Double Ended LinkedList has a reference to 
//the first and last Link in the List

public class DoubleEndedLinkedList {

	Neighbor firstLink;
	Neighbor lastLink;

	public void insertInFirstPosition(String homeOwnerName, int houseNumber) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		// If no items in the list add the new Link
		// to lastLink in the LinkedList

		if (isEmpty()) {

			lastLink = theNewLink;

		} /* FOR DOUBLY LINKED LIST */else {

			firstLink.previous = theNewLink;

		} // END OF DOUBLY LINKED LIST ADDITION

		// DOUBLY LINKED LIST
		// Just like you can go forward in the list with next
		// with a doubly linked list you can go backwards
		// because it also has a previous as well as a next

		// Assign the reference to the previous
		// firstLink and assign the new Link
		// to firstLink in LinkedList

		theNewLink.next = firstLink;

		firstLink = theNewLink;

	}

	public void insertInLastPosition(String homeOwnerName, int houseNumber) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		// If empty put the new Neighbor in first position

		if (isEmpty()) {

			firstLink = theNewLink;

		} else {

			// Assign the last Neighbors next to the new Neighbor

			lastLink.next = theNewLink;

			theNewLink.previous = lastLink; // FOR DOUBLY LINKED LIST

		}

		lastLink = theNewLink;

	}

	// DOUBLY LINKED LIST ADDITION
	// Insert after the provided key

	public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		Neighbor currentNeighbor = firstLink; // Starts search at first link

		// while the current houseNumber isn't the key keep looking

		while (currentNeighbor.houseNumber != key) {

			currentNeighbor = currentNeighbor.next; // Switch to the next
													// Neighbor

			// If we get to the last Neighbor without a match leave the method

			if (currentNeighbor == null) {

				return false;

			}

		}

		// If we make it here we have a match for the key

		// If the match was for the last Neighbor in the list

		if (currentNeighbor == lastLink) {

			// Assign the new Neighbor as the last link

			theNewLink.next = null;
			lastLink = theNewLink;

		} else {

			// It didn't match for the last link
			// So take next from the Neighbor that was
			// here previously and assign theNewLink to
			// the previous Neighbor

			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink;

		}

		theNewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;

	}

	public static void main(String[] args) {

		DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();

		theLinkedList.insertInFirstPosition("Mark Evans", 7);
		theLinkedList.insertInFirstPosition("Piers Polkiss", 9);
		theLinkedList.insertInFirstPosition("Doreen Figg", 6);
		theLinkedList.insertInLastPosition("Petunia Dursley", 4);

		/*
		 * theLinkedList.insertInOrder("Mark Evans", 7);
		 * theLinkedList.insertInOrder("Piers Polkiss", 9);
		 * theLinkedList.insertInOrder("Doreen Figg", 6);
		 * theLinkedList.insertInOrder("Petunia Dursley", 4);
		 */

		theLinkedList.display();

		theLinkedList.insertAfterKey("Derek Banas", 2, 6);

		theLinkedList.display();

		System.out.println("\n");

		// Send the LinkedList to the iterator

		NeighborIterator neighbors = new NeighborIterator(theLinkedList);

		// Get the first neighbor and display

		neighbors.currentNeighbor.display();

		// Is there another?

		System.out.println(neighbors.hasNext());

		// Switch to the next Neighbor

		neighbors.next();

		neighbors.currentNeighbor.display();

		neighbors.remove();

		neighbors.currentNeighbor.display();

	}

	// Returns true if LinkList is empty

	public boolean isEmpty() {

		return (firstLink == null);

	}

	// Inserts Neighbors in order based on house number

	public void insertInOrder(String homeOwnerName, int houseNumber) {

		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

		// Holds he last Neighbor searched so we can change
		// its value for next if we input a new Neighbor

		Neighbor previousNeighbor = null;

		Neighbor currentNeighbor = firstLink;

		// While there are still Neighbors and the new houseNumber
		// is greater than the current focused houseNumber
		// Change the > to < for opposite sort

		while ((currentNeighbor != null)
				&& (houseNumber > currentNeighbor.houseNumber)) {

			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next; // Get the next Neighbor

		}

		// We are still at the beginning of the list

		if (previousNeighbor == null) {

			// Save new Neighbor in the first position

			firstLink = theNewLink;

		} else {

			// Assign the new Neighbor as the value for next

			previousNeighbor.next = theNewLink;

		}

		// Assign the value of next to the next Neighbor

		theNewLink.next = currentNeighbor;

	}

	public void display() {

		Neighbor theLink = firstLink;

		while (theLink != null) {

			theLink.display();

			System.out.println("Next Link: " + theLink.next);

			theLink = theLink.next;

			System.out.println();

		}

	}

}

class Neighbor {

	public String homeOwnerName;
	public int houseNumber;

	public Neighbor next;

	public Neighbor previous; // Used with Doubly Linked List

	public Neighbor(String homeOwnerName, int houseNumber) {

		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;

	}

	public void display() {

		System.out
				.println(homeOwnerName + ": " + houseNumber + " Privet Drive");

	}

	public String toString() {

		return homeOwnerName;

	}

}

// An iterator provides an easy way to cycle through all
// the objects in a LinkedList

class NeighborIterator {

	Neighbor currentNeighbor; // The current focus Neighbor
	Neighbor previousNeighbor; // The previous Neighbor

	DoubleEndedLinkedList theNeighbors;

	// hasNext, next, remove are common iterator methods

	NeighborIterator(DoubleEndedLinkedList theNeighbors) {

		this.theNeighbors = theNeighbors;

		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;

	}

	public boolean hasNext() {

		if (currentNeighbor.next != null) {

			return true;

		}

		return false;

	}

	public Neighbor next() {

		if (hasNext()) {

			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;

			return currentNeighbor;

		}

		return null;

	}

	public void remove() {

		// If at the beginning of the list

		if (previousNeighbor == null) {

			theNeighbors.firstLink = currentNeighbor.next;

		} else {

			previousNeighbor.next = currentNeighbor.next;

			// If at end of list

			if (currentNeighbor.next == null) {

				// Assign first link as the current link

				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;

			} else {

				currentNeighbor = currentNeighbor.next;

			}

		}

	}

}
