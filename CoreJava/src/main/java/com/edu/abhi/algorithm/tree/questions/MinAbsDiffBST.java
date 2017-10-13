package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * @author abhishekkhare
 *
 */
public class MinAbsDiffBST {

	public static void main(String[] args) {

		{
			int[] array = new int[] { 1, 2, 3};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			getMinimumDifference(node);
		}
		
		System.out.println("**************************************************");
		
		{
			int[] array = new int[] { 1, 3,5,8,12,15,14};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			getMinimumDifference(node);
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1,  6, 7, 12,13,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			getMinimumDifference(node);
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1,  7, 8, 9,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			getMinimumDifference(node);
		}

	

	}

	public static void getMinimumDifference(BinaryTreeNode root) {
		if(root!=null){
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			List<Integer> list = new ArrayList<Integer>();
			stack.push(root);
			while(!stack.empty()){
				BinaryTreeNode node = stack.pop();
				list.add(Integer.parseInt(node.value));
				if(node.right!=null){
					stack.push(node.right);
				}
				if(node.left!=null){
					stack.push(node.left);
				}
			}
			
			list.stream().forEach(l -> System.out.print(l));
			System.out.println();
			Integer [] array = list.toArray(new Integer[list.size()]);
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			int min = Integer.MAX_VALUE;
			String nodes ="";
			for (int i = 0; i < array.length-1; i++) {
				int diff = Math.abs((array[i]-array[i+1]));
				if(diff<min){
					min = diff;
					nodes = array[i]+ " - "+array[i+1];
				}
			}
			System.out.println(nodes + " =" + min);
		}
		
		
	}
}
