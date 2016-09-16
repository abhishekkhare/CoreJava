package com.edu.abhi.algorithm.linkedlist.my;


public interface InterfaceLinkedList {
	void addNode(Node node);
	void insertAfterNode(int data, int after);
	void insertBeforeNode(int data, int before);
	void deleteNode(int nodeNumber);
	boolean isEmpty();
	Node find(int nodeNumber);
	void display();
}
