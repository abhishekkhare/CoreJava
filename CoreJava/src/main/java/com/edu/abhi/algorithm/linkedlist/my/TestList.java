package com.edu.abhi.algorithm.linkedlist.my;

public class TestList {

	public static boolean isListCircular(InterfaceLinkedList ml) {
		if (ml instanceof MyLinkedList || ml instanceof MyCircularLinkedList) {
			MyLinkedList ml1 = (MyLinkedList) ml;
			ml1.current = ml1.root;
			while (true) {
				if (ml1.current.nextNode == ml1.root) {
					return true;
				} else if (ml1.current.nextNode == null) {
					break;
				} else {
					ml1.current = ml1.current.nextNode;
				}
			}
		}
		if (ml instanceof MyDoubleLinkedList
				|| ml instanceof MyDoubleCircularLinkedList) {

			MyDoubleLinkedList ml1 = (MyDoubleLinkedList) ml;
			ml1.current = ml1.root;
			while (true) {
				if (ml1.current.nextNode == ml1.root) {
					return true;
				} else if (ml1.current.nextNode == null) {
					break;
				} else {
					ml1.current = (DNode) ml1.current.nextNode;
				}
			}

		}
		return false;
	}

	public static boolean doListCoincide(MyLinkedList ml1, MyLinkedList ml2) {
		if ((ml1 instanceof MyLinkedList && ml2 instanceof MyLinkedList)) {
			MyLinkedList ml11 = (MyLinkedList) ml1;
			MyLinkedList ml22 = (MyLinkedList) ml2;
			ml11.current=ml11.root;
			while(ml11.current.nextNode!=null){
				ml22.current=ml22.root;
				while(ml22.current.nextNode!=null){
					if(ml11.current.nextNode == ml22.current.nextNode){
						return true;
					}
					ml22.current = ml22.current.nextNode;
				}
				ml11.current = ml11.current.nextNode;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyLinkedList ml1 = new MyLinkedList();
		MyLinkedList ml2 = new MyLinkedList();
		MyLinkedList ml3 = new MyLinkedList();
		Node n1 = new Node(1);
		Node n11 = new Node(11);
		Node n2 = new Node(2);
		Node n22 = new Node(22);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		ml1.addNode(n1);
		ml1.addNode(n2);
		ml1.addNode(n3);
		ml1.addNode(n4);
		ml1.addNode(n5);
		ml1.addNode(n6);
		ml1.display();
		
		
		ml2.addNode(n11);
		ml2.addNode(n22);
		ml2.addNode(n3);
		ml2.addNode(n4);
		ml2.addNode(n5);
		ml2.addNode(n6);
		ml2.display();
		
		System.out.println(doListCoincide(ml1,ml2));
		
		ml3.addNode(n11);
		ml3.addNode(n22);
		ml3.display();
		
		System.out.println(doListCoincide(ml1,ml3));
		
	}
}
