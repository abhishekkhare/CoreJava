package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 *  4
   /   \
  2     7
 / \   / \
1   3 6   9


	 4
   /   \
  7     2
 / \   / \
9   6 3   1

 * 
 * @author abhishekkhare
 *
 */
public class InvertBinaryTree {

	public static void main(String [] args){
		int[] array = new int[] { 1, 2, 3, 4, 6, 7, 9};
		BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
		BinaryTreeNode invertedNode = invertTree(node);
		System.out.println(invertedNode);
		
	}
	
	public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        if(root !=null){
        	BinaryTreeNode tempNodeL = root.left;
        	BinaryTreeNode tempNodeR = root.right;
        	if(tempNodeL!=null){
        		root.right=tempNodeL;
        		invertTree(tempNodeL);
        	}
        	
        	if(tempNodeR!=null){
        		root.left=tempNodeR;
        		invertTree(tempNodeR);
        	}
        }
		return root;
    }
}


