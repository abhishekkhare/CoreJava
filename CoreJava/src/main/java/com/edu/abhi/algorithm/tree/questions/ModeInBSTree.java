package com.edu.abhi.algorithm.tree.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * @author abhishekkhare
 *
 */
public class ModeInBSTree {

	public static void main(String[] args) {
		{
			int[] array = new int[] { 1, 2, 3, 3, 2, 1, 7, 8, 9};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			findMode(node).forEach((k,v) -> System.out.println(k + " --> " +v));
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1, 2, 3, 4, 4, 4, 6, 3, 3,3,2,1,13,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			findMode(node).forEach((k,v) -> System.out.println(k + " --> " +v));
		}

	
	}

	public static Map<String,Integer> findMode(BinaryTreeNode root) {
		Map<String,Integer> resultMap = new HashMap<String,Integer>();
		if(root!=null){
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			while(!stack.isEmpty()){
				BinaryTreeNode tempNode = stack.pop();
				if(resultMap.containsKey(tempNode.value)){
					Integer tempCount =  resultMap.get(tempNode.value);
					tempCount++;
					resultMap.put(tempNode.value, tempCount);
				}else{
					resultMap.put(tempNode.value, 1);
				}
				if(tempNode.right!=null){
					stack.push(tempNode.right);
				}
				
				if(tempNode.left!=null){
					stack.push(tempNode.left);
				}
			}
		}
		
		return resultMap;
	}
}
