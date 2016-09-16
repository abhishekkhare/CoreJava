package com.edu.abhi.algorithm.linkedlist.my;

public class MyDoubleCircularLinkedList extends MyDoubleLinkedList implements InterfaceLinkedList {

	public static void main(String[] args) {
		MyDoubleCircularLinkedList ml = new MyDoubleCircularLinkedList();
		ml.display();
		ml.displayReverse();
		ml.addNode(new DNode(1));
		ml.display();
		ml.displayReverse();
		ml.insertAfterNode(22, 1);
		ml.addNode(new DNode(2));
		ml.display();
		ml.displayReverse();
		ml.addNode(new DNode(3));
		ml.addNode(new DNode(4));
		ml.addNode(new DNode(5));
		ml.addNode(new DNode(6));
		ml.display();
		ml.displayReverse();
		ml.insertBeforeNode(33, 3);
		ml.display();
		ml.displayReverse();
		ml.displayCircular();
		System.out.println(ml.find(3).data);
		System.out.println("Circular:" + TestList.isListCircular(ml));
	}

	@Override
	public void addNode(Node node) {
		if (node instanceof DNode) {
			DNode dNode = (DNode) node;
			if (root == null) {
				root = dNode;
				root.previousNode = dNode;
				root.nextNode = dNode;
				current = root;
			} else {
				temp = (DNode) current.nextNode;
				current.nextNode = dNode;
				dNode.previousNode = current;
				dNode.nextNode = temp;
				current = dNode;
			}
		} else {
			throw new RuntimeException("Node not of type DNode");
		}

	}

	@Override
	public void insertAfterNode(int data, int after) {
		int noOfNode = 1;
		DNode node = new DNode(data);
		current = root;
		while (noOfNode < after) {
			if (current.nextNode != null) {
				current = (DNode) current.nextNode;
				noOfNode++;
			} else {
				throw new RuntimeException(after
						+ "bigger than the linked list");
			}
		}

		node.nextNode = current.nextNode;
		current.nextNode = node;
		node.previousNode = current;
		current = node;
	}

	@Override
	public void insertBeforeNode(int data, int before) {
		insertAfterNode(data, before - 1);
	}

	@Override
	public void deleteNode(int nodeNumber) {
		current = root;
		if (nodeNumber == 1) {
			root = (DNode) current.nextNode;
		} else {
			int noOfNode = 1;
			while (noOfNode < nodeNumber - 1) {
				current = (DNode) current.nextNode;
				noOfNode++;
			}
			temp = (DNode) current.nextNode;
			current.nextNode = temp.nextNode;
			((DNode) (temp.nextNode)).previousNode = current;
		}
	}

	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public Node find(int nodeNumber) {
		current = root;
		if(nodeNumber==1){
			return current;
		}else{
			int noOfNode =1;
			while(noOfNode<nodeNumber-1){
				current = (DNode)current.nextNode;
				noOfNode++;
			}
			return current.nextNode;
		}
	}

	public void displayReverse() {
		System.out.println("Display Reverse:");
		if (root == null) {
			System.out.println("Empty Linked List");
		} else {
			boolean arrow = true;
			temp = current;
			while (temp.previousNode != root) {
				System.out.print((arrow) ? "|" + temp.data + "|" : " --> "
						+ "|" + temp.data + "|");
				temp = temp.previousNode;
				arrow = false;
			}
			System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"
					+ temp.data + "|");
			temp = temp.previousNode;
			arrow = false;
			System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"
					+ temp.data + "|");
		}
		System.out.println("");

	}

	public void displayCircular() {

		System.out.println("Display Circular:");
		if (root == null) {
			System.out.println("Empty Linked List");
		} else {
			boolean arrow = true;
			temp = root;
			int count = 0;
			while (count < 20) {
				System.out.print((arrow) ? "|" + temp.data + "|" : " --> "
						+ "|" + temp.data + "|");
				temp = (DNode) temp.nextNode;
				arrow = false;
				count++;
			}
			System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"
					+ temp.data + "|");
		}
		System.out.println("");

	}

	@Override
	public void display() {
		System.out.println("Display:");
		if (root == null) {
			System.out.println("Empty Linked List");
		} else {
			boolean arrow = true;
			temp = root;
			while (temp.nextNode != root) {
				System.out.print((arrow) ? "|" + temp.data + "|" : " --> "
						+ "|" + temp.data + "|");
				temp = (DNode) temp.nextNode;
				arrow = false;
			}
			System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"
					+ temp.data + "|");
		}
		System.out.println("");

	}

}
