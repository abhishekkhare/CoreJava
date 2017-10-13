package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * 
 * @author abhishekkhare
 *
 */
public class ConvertSortedArrayToBST {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19 };
		sortedArrayToBST(array);

	}

	public static BinaryTreeNode unbalancedBST() {
		BinaryTreeNode root = new BinaryTreeNode("20");
		BinaryTreeNode l1 = new BinaryTreeNode("10");
		l1.left= new BinaryTreeNode("5");
		l1.right= new BinaryTreeNode("15");
		root.left=l1;
		BinaryTreeNode r1 = new BinaryTreeNode("30");
		root.right=r1;
		BinaryTreeNode rl2 = new BinaryTreeNode("24");
		BinaryTreeNode rr2 = new BinaryTreeNode("40");
		r1.left=rl2;
		r1.right=rr2;
		
		BinaryTreeNode rll3 = new BinaryTreeNode("22");
		BinaryTreeNode rlr3 = new BinaryTreeNode("28");
		rl2.left=rll3;
		rl2.right = rlr3;
		
		BinaryTreeNode rlll4 = new BinaryTreeNode("21");
		BinaryTreeNode rllr4 = new BinaryTreeNode("23");
		rll3.left=rlll4;
		rll3.right = rllr4;
		
		BinaryTreeNode rlrl4 = new BinaryTreeNode("26");
		BinaryTreeNode rlrr4 = new BinaryTreeNode("29");
		rlr3.left=rlrl4;
		rlr3.right = rlrr4;
		rlrl4.left=new BinaryTreeNode("25");
		
		BinaryTreeNode rrl3 = new BinaryTreeNode("35");
		BinaryTreeNode rrr3 = new BinaryTreeNode("50");
		rr2.left=rrl3;
		rr2.right = rrr3;
		
		BinaryTreeNode rrrl4 = new BinaryTreeNode("45");
		BinaryTreeNode rrrr4 = new BinaryTreeNode("60");
		rrr3.left=rrrl4;
		rrr3.right = rrrr4;
		
		BinaryTreeNode rrrrl5 = new BinaryTreeNode("55");
		BinaryTreeNode rrrrr5 = new BinaryTreeNode("70");
		rrrr4.left=rrrrl5;
		rrrr4.right = rrrrr5;
		
		
		BinaryTreeNode rrrrrr6 = new BinaryTreeNode("80");
		rrrrr5.right = rrrrrr6;
		
		BinaryTreeNode rrrrrrr7 = new BinaryTreeNode("90");
		rrrrrr6.right = rrrrrrr7;
		
		return root;
	}
	
	public static BinaryTreeNode sortedArrayToBST(int[] nums) {
		BinaryTreeNode node = sortedArrayToBST(nums,0,nums.length-1);
		return node;
	}

	public static BinaryTreeNode sortedArrayToBST(int arr[], int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		BinaryTreeNode node = new BinaryTreeNode(arr[mid]+"");

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		node.left = sortedArrayToBST(arr, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of
		 * root
		 */
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

}
