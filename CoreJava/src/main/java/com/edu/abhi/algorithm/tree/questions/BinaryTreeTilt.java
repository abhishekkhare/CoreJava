package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

import java.util.Stack;

/**
 * Given a binary tree, return the tilt of the whole tree.
 * 
 * The tilt of a tree node is defined as the absolute difference between the sum
 * of all left subtree node values and the sum of all right subtree node values.
 * Null node has tilt 0.
 * 
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Input: 
         2
       /   \
      1     3
Output: 1
Explanation: 
Tilt of node 1 : 0
Tilt of node 3 : 0
Tilt of node 2 : |1-3| = 2
Tilt of binary tree : 0 + 0 + 2 = 2
 * 
 * 
 * 
 * 
 * @author abhishekkhare
 *
 */
public class BinaryTreeTilt {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3};
		BinaryTreeNode root = ConvertSortedArrayToBST.sortedArrayToBST(array);
		System.out.println(findTilt(root));
	}

	public static int findTilt(BinaryTreeNode root) {
		int tiltLeft=0;
		int tiltRight=0;
		if(root!=null){
			BinaryTreeNode nodeLeft = null;
			BinaryTreeNode nodeRight = null;
			if(root.left!=null){
				nodeLeft = root.left;
			}
			
			if(root.right!=null){
				nodeRight = root.right;
			}
			
			Stack<BinaryTreeNode> stackLeft = new Stack<BinaryTreeNode>();
			Stack<BinaryTreeNode> stackRight = new Stack<BinaryTreeNode>();
			stackLeft.push(nodeLeft);
			stackRight.push(nodeRight);

			while(!stackLeft.isEmpty()){
				BinaryTreeNode temp = stackLeft.pop();
				tiltLeft+=Integer.parseInt(temp.value);
				if(temp.left!=null){
					stackLeft.push(temp);
				}
				
				if(temp.right!=null){
					stackLeft.push(temp);
				}
			}
			
			while(!stackRight.isEmpty()){
				BinaryTreeNode temp = stackRight.pop();
				tiltRight+=Integer.parseInt(temp.value);
				if(temp.left!=null){
					stackRight.push(temp);
				}
				
				if(temp.right!=null){
					stackRight.push(temp);
				}
			}
			
		}
		return Math.abs(tiltRight-tiltLeft);
	}

}
