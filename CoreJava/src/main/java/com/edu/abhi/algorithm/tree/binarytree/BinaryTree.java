package com.edu.abhi.algorithm.tree.binarytree;

import com.edu.abhi.algorithm.tree.Node;

/**
 * 
 * 
 * 50 28 80 25 40 75 85 20 30 70 90 15 29 10
 * 
 * @author abhishekkhare
 * 
 */
public class BinaryTree {
	public Node root;

	public void addNode(int data, String name) {
		Node newNode = new Node(data, name);
		// If there is no root this becomes root
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (data < focusNode.data) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * All nodes are visited in ascending order, Recursion is used to go to one
	 * node and then go to its child nodes and so forth.
	 * 
	 * Aim for the smallest value first, Start at 1st leftchild, when null is
	 * reached move up in value.
	 * 
	 * @param focusNode
	 */

	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			// Traverse the left node
			inOrderTraverseTree(focusNode.leftChild);
			// Visit the currently focused on node
			System.out.println(focusNode);
			// Traverse the right node
			inOrderTraverseTree(focusNode.rightChild);

		}
	}

	/**
	 * Start with root and cycle down to all the left childeren,once we hit
	 * null, we jump up one parent and go to right child
	 * 
	 * @param focusNode
	 */
	public void preorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
		}
	}

	/**
	 * 
	 * @param focusNode
	 */
	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}

	public Node findNode(int data) {
		// Start at the top of the tree
		Node focusNode = root;
		// While we haven't found the Node
		// keep looking
		while (focusNode.data != data) {
			// If we should search to the left
			if (data < focusNode.data) {
				// Shift the focus Node to the left child
				focusNode = focusNode.leftChild;
			} else {
				// Shift the focus Node to the right child
				focusNode = focusNode.rightChild;
			}
			// The node wasn't found
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}

	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();
		theTree.addNode(50, "Boss");
		theTree.addNode(28, "VVV");
		theTree.addNode(25, "Vice President");
		theTree.addNode(20, "OOOO");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(10, "SESESE");
		theTree.addNode(40, "SECSECSEC");
		theTree.addNode(30, "Secretary");
		theTree.addNode(29, "SASASA");
		theTree.addNode(80, "SALSALSA");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(70, "SA1SA1");
		theTree.addNode(85, "Salesman 1");
		theTree.addNode(90, "SAL1SAL1");

		theTree.inOrderTraverseTree(theTree.root);
		System.out.println("***************************");
		theTree.preorderTraverseTree(theTree.root);
		System.out.println("***************************");
		theTree.postOrderTraverseTree(theTree.root);
		System.out.println("***************************");
		System.out.println(theTree.findNode(25));
	}
}
