package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.List;

import com.edu.abhi.algorithm.tree.GenerateTree;
import com.edu.abhi.algorithm.tree.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author abhishekkhare
 *
 */
public class MaxDepth {

	public static void main(String[] args) {
		System.out.println(maxDepth(GenerateTree.treeWithMultipleChildren()));
		System.out.println(maxDepth(GenerateTree.treeWithMultipleChildren1()));
		System.out.println(maxDepth(GenerateTree.treeWithMultipleChildren2()));
		System.out.println(maxDepth(GenerateTree.treeWithMultipleChildren3()));

	}

	public static int maxDepth(TreeNode root) {
		if (root != null) {
			if (root.children != null && root.children.size() > 0) {
				List<TreeNode> children = root.children;
				List<TreeNode> childrenTemp = root.children;
				int depth = 1;
				while (childrenTemp != null && childrenTemp.size() > 0) {
					depth++;
					children = childrenTemp;
					childrenTemp = new ArrayList<TreeNode>();
					for (TreeNode treeNode : children) {
						if (treeNode.children != null && treeNode.children.size() > 0) {
							childrenTemp.addAll(treeNode.children);
						}

					}
				}
				return depth;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
