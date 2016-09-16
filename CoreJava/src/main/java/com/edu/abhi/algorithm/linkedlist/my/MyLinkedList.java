package com.edu.abhi.algorithm.linkedlist.my;

public class MyLinkedList implements InterfaceLinkedList{
	public Node root;
	public Node current;
	public Node temp;

	public static void main(String[] args) {
		MyLinkedList ml = new MyLinkedList();
		ml.display();
		ml.addNode(new Node(1));
		ml.display();
		ml.insertAfterNode(22, 1);
		ml.addNode(new Node(2));
		ml.display();
		ml.addNode(new Node(3));
		ml.addNode(new Node(4));
		ml.addNode(new Node(5));
		ml.addNode(new Node(6));
		ml.insertBeforeNode(33, 3);
		ml.display();
		ml.deleteNode(3);
		ml.display();
		System.out.println("Node:" +ml.find(4).data);
		System.out.println("Circular:" + TestList.isListCircular(ml));
	}

	@Override
	public void addNode(Node node) {
		if(root == null){
			root=node;
			current = root;
		}else{
			current.nextNode = node;
			current = node;
			node.nextNode=null;
		}
		
	}

	@Override
	public void insertAfterNode(int data, int after) {
		int noOfNode =1;
		Node node = new Node(data);
		current = root;
		while(noOfNode<after){
			if(current.nextNode!=null){
				current = current.nextNode;	
				noOfNode++;
			}else{
				throw new RuntimeException(after + "bigger than the linked list");
			}
		}
		
		node.nextNode=current.nextNode;
		current.nextNode = node;
		current=node;
	}

	@Override
	public void insertBeforeNode(int data, int before) {
		insertAfterNode(data,before-1);
	}

	@Override
	public void deleteNode(int nodeNumber) {
		current = root;
		if(nodeNumber==1){
			root = current.nextNode;
		}else{
			int noOfNode =1;
			while(noOfNode<nodeNumber-1){
				current = current.nextNode;
				noOfNode++;
			}
			temp = current.nextNode;
			current.nextNode=temp.nextNode;
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
				current = current.nextNode;
				noOfNode++;
			}
			return current.nextNode;
		}
	}

	@Override
	public void display() {
		System.out.println("Display:");
		if(root == null){
			System.out.println("Empty Linked List");
		}else{
			boolean arrow = true;
			temp = root;
			while(temp.nextNode!=null){
				System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"+ temp.data + "|");
				temp = temp.nextNode;
				arrow = false;
			}
			System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"+ temp.data + "|");
		}
		
		System.out.println("");
		
	}
}
