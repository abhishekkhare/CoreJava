package com.edu.abhi.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

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

	public static void depthFirst(TreeNode root, boolean rootFlag) {
		if (root != null) {
			if (rootFlag)
				System.out.println(root.value);
			List<TreeNode> children = root.children;
			for (TreeNode node : children) {
				System.out.println(node.value);
				if (node.children != null && node.children.size() > 0) {
					depthFirst(node, false);
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

	public static void main(String[] args) {
		TreeNode root = GenerateTree.treeWithMultipleChildren();
		System.out.println("******************** Depth First Search with Recursion *********************************");
		TreeTraversal.depthFirst(root, true);
		System.out.println("******************** Breadth First Search with Recursion *********************************");
		TreeTraversal.breadthFirst(root);

	}

}
