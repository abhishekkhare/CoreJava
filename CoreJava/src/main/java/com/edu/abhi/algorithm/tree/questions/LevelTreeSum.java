package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.List;

/**
 Given a root to a binary tree, find the level of the tree with the minimum sum. 

for example: 

50 
/ \ 
6 2 
/ \ / 
30 80 7 

the answer is: level 2
 * 
 * 
 * @author abhishekkhare
 *
 */
public class LevelTreeSum {

	public static void main(String [] args) {
		Node root = new Node(50);
		Node l11 = new Node(6);
		Node l12 = new Node(2);
		root.left = l11;
		root.right = l12;

		Node l21 = new Node(30);
		Node l22 = new Node(80);
		l11.left = l21;
		l11.right = l22;

		Node l23 = new Node(7);
		l12.left = l23;
		
		breadthFirstSearch(root);

	}

	static void breadthFirstSearch(Node root) {
		int sum = Integer.MAX_VALUE;
		int level = 1;
		int index = 1;
		List<Node> children = new ArrayList<Node>();
		
		if (root != null) {
			sum = root.value;
			if (root.left != null)
				children.add(root.left);
			if (root.right != null)
				children.add(root.right);

		}
		if (children != null && children.size() > 0) {
			while (true) {
				int tempSum = 0;
				List<Node> remainingChildren = new ArrayList<Node>();
				for (Node node : children) {
					if (node != null) {
						tempSum += node.value;
						if (node.left != null) {
							remainingChildren.add(node.left);
						}
						if (node.right != null) {
							remainingChildren.add(node.right);
						}

					}
				}
				index+=1;
				if(tempSum<sum){
					sum=tempSum;
					level=index;
				}
				if (remainingChildren.size() > 0) {
					children = remainingChildren;
				} else {
					break;
				}
			}
		}
		
		System.out.println("Sum::" + sum + " level::" + level);

	}

	private static class Node {
		Integer value;
		Node left;
		Node right;

		Node(Integer value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		
		
	}

}
