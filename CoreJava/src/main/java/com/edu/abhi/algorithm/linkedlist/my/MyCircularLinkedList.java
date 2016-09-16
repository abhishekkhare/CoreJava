package com.edu.abhi.algorithm.linkedlist.my;

public class MyCircularLinkedList extends MyLinkedList implements InterfaceLinkedList{
	
	public static void main(String[] args) {
		MyCircularLinkedList ml = new MyCircularLinkedList();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		ml.display();
		ml.addNode(n1);
		ml.addNode(n2);
		ml.display();
		ml.addNode(n4);
		ml.addNode(n5);
		ml.display();
		ml.insertAfterNode(3, 2);
		ml.display();
		ml.deleteNode(4);
		ml.display();
		System.out.println(ml.find(3).data);
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
			node.nextNode=root;
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
			int count =0;
			while(temp.nextNode!=null && count<20){
				System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"+ temp.data + "|");
				temp = temp.nextNode;
				arrow = false;
				count++;
			}
			System.out.print((arrow) ? "|" + temp.data + "|" : " --> " + "|"+ temp.data + "|");
		}
		
		System.out.println("");
		
	}

}
