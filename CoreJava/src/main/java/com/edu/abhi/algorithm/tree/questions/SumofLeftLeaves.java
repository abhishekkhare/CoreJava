package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

import java.util.Stack;

/**
 *3
   / \
  9  20
    /  \
   15   7

 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * @author abhishekkhare
 *
 */
public class SumofLeftLeaves {

	public static void main(String[] args) {
		{
			int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			System.out.println(sumOfLeaves(node));
			System.out.println(sumOfLeftLeaves(node));
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			System.out.println(sumOfLeaves(node));	
			System.out.println(sumOfLeftLeaves(node));
		}
	}

	public static int sumOfLeaves(BinaryTreeNode root) {
		int sum =0;
		if(root!=null){
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			while(!stack.empty()){
				BinaryTreeNode tempNode = stack.pop();
				if(tempNode.left==null && tempNode.right==null){
					sum+=Integer.parseInt(tempNode.value);	
				}else{
					if(tempNode.right!=null){
						stack.push(tempNode.right);
					}
					if(tempNode.left!=null){
						stack.push(tempNode.left);
					}
				}
			}
			
		}
		return sum;
	}
	public static int sumOfLeftLeaves(BinaryTreeNode root) {
		int sum =0;
		if(root!=null){
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			while(!stack.empty()){
				BinaryTreeNode tempNode = stack.pop();
				if(tempNode.left==null && tempNode.right==null){
					sum+=Integer.parseInt(tempNode.value);	
				}else{
					if(tempNode.right!=null){
						if(tempNode.right.right!=null || tempNode.right.left!=null)
							stack.push(tempNode.right);
					}
					
					if(tempNode.left!=null){
						stack.push(tempNode.left);
					}
				}
			}
			
		}
		return sum;
	}
}
