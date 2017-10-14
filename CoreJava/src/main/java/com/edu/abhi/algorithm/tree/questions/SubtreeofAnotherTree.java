package com.edu.abhi.algorithm.tree.questions;

import java.util.Stack;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
 * 
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2

 * 
 * Return false.
 * @author abhishekkhare
 *
 */
public class SubtreeofAnotherTree {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3,5,6,7,8,9};
		int[] subArray = new int[] {1,2,3};
		BinaryTreeNode s = ConvertSortedArrayToBST.sortedArrayToBST(array);
		BinaryTreeNode t = ConvertSortedArrayToBST.sortedArrayToBST(subArray);
		System.out.println(isSubtree(s, t));

	}

	public static boolean isSubtree(BinaryTreeNode s, BinaryTreeNode t) {
		if(s!=null && t!=null){
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(s);
			while(!stack.isEmpty()){
				BinaryTreeNode temp = stack.pop();
				if(isSameTree(temp, t)){
					return true;
				}
				if(temp.left!=null){
					stack.push(temp.left);
				}
				
				if(temp.right!=null){
					stack.push(temp.right);
				}
			}
		}
		return false;
	}
	
	public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
		if(p!=null && q !=null){
			Stack<BinaryTreeNode> stackP = new Stack<BinaryTreeNode>();
			Stack<BinaryTreeNode> stackQ = new Stack<BinaryTreeNode>();
			stackP.push(p);
			stackQ.push(q);
			while(!stackP.isEmpty() && !stackQ.isEmpty()){
				BinaryTreeNode tempP = stackP.pop();
				BinaryTreeNode tempQ = stackQ.pop();
				if(tempP.value.equals(tempQ.value)){
					if(tempP.left!=null){
						stackP.push(tempP.left);
					}
					
					if(tempP.right!=null){
						stackP.push(tempP.right);
					}
					
					if(tempQ.left!=null){
						stackQ.push(tempQ.left);
					}
					
					if(tempQ.right!=null){
						stackQ.push(tempQ.right);
					}
				}else{
					return false;
				}
			}
		}
		return true;
	}
}
