package com.edu.abhi.algorithm.tree.questions;

import java.util.List;

import com.edu.abhi.algorithm.tree.GenerateTree;
import com.edu.abhi.algorithm.tree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * 
 * @author abhishekkhare
 *
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode p = GenerateTree.treeWithMultipleChildren();
		TreeNode q = GenerateTree.treeWithMultipleChildren();
		TreeNode r = GenerateTree.treeWithMultipleChildren1();
		System.out.println("P & Q:" + isSameTree(p, q));
		System.out.println("P & R:" + isSameTree(p, r));
		System.out.println("Q & R:" + isSameTree(q, r));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.children != null && q.children != null && p.children.size() == q.children.size()) {
				List<TreeNode> childrenP = p.children;
				List<TreeNode> childrenQ = q.children;
				for (int i = 0; i < childrenP.size(); i++) {
					if (isSameTree(childrenP.get(i), childrenQ.get(i))) {
						// continue;
					} else {
						return false;
					}
				}

			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
