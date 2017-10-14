package com.edu.abhi.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Depth First Traversals
 * 
 * Inorder Traversal (Left-Root-Right)
 * 
 * Preorder Traversal (Root-Left-Right)
 * 
 * Postorder Traversal (Left-Right-Root)
 * 
 * Breadth-first search (BFS) - It starts at the tree root (or some arbitrary
 * node of a graph, sometimes referred to as a 'search key'[1]) and explores the
 * neighbor nodes first, before moving to the next level neighbours.
 * 
 * @author abhishekkhare
 *
 */
public class TreeTraversal {

	public static void depthFirstRecursive(TreeNode root, boolean rootFlag) {
		if (root != null) {
			if (rootFlag)
				System.out.println(root.value);
			List<TreeNode> children = root.children;
			for (TreeNode node : children) {
				if (node.children != null && node.children.size() > 0) {
					depthFirst(node, false);
				}
			}
		}
	}
	
	
	public static void depthFirst(TreeNode root, boolean rootFlag) {

		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode tempNode = stack.pop();
				System.out.println(tempNode.value);
				if(tempNode.children!=null && tempNode.children.size()>0){
					for (TreeNode treeNode : tempNode.children) {
						stack.push(treeNode);
					}
				}
			}
		}	
	}

	public static void breadthFirst(TreeNode root) {
		if (root != null) {
			System.out.println(root.value);
			int index = 0;
			List<List<TreeNode>> remainingChildren = new ArrayList<List<TreeNode>>();
			List<TreeNode> children = root.children;
			if (children != null && children.size() > 0) {
				while (true) {
					for (TreeNode node : children) {
						if (node != null) {
							System.out.println(node.value);
							if (node.children != null && node.children.size() > 0)
								remainingChildren.add(node.children);
						}
					}
					if (remainingChildren.size() > index) {
						children = remainingChildren.get(index);
						index++;
					} else {
						break;
					}
				}
			}
		}
	}
	
	public static void breadthFirst1(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			List<TreeNode> tempList = new ArrayList<TreeNode>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode tempNode =  stack.pop();
				System.out.println(tempNode.value);
				if (tempNode.children != null && tempNode.children.size() > 0){
					for (TreeNode treeNode : tempNode.children) {
						tempList.add(treeNode);
					}
				}
				if(stack.isEmpty()){
					for (int i = tempList.size()-1; i >= 0; i--) {
						stack.push(tempList.get(i));
					}
					tempList = new ArrayList<TreeNode>();
				}	
			}
			
			
		}
	}

	public static void main(String[] args) {
		TreeNode root = GenerateTree.treeWithMultipleChildren();
		root.print();
		System.out.println("******************** Depth First Search with Recursion *********************************");
		TreeTraversal.depthFirstRecursive(root, true);
		System.out.println("without Recursion");
		TreeTraversal.depthFirstRecursive(root, true);
		System.out.println("******************** Breadth First Search *********************************");
		TreeTraversal.breadthFirst(root);
		System.out.println("simpler way");
		TreeTraversal.breadthFirst1(root);

	}

}
