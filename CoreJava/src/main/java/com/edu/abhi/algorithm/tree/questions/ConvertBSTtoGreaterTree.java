package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * 
 * 
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 * 
 * @author abhishekkhare
 *
 */
public class ConvertBSTtoGreaterTree {

	public static void main(String[] args) {


		{
			int[] array = new int[] { 1, 2, 3};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			convertBST(node);
		}
		
		System.out.println("**************************************************");
		
		{
			int[] array = new int[] { 1, 3,5,8,12,15,14};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			convertBST(node);
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1,  6, 7, 12,13,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			convertBST(node);
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1,  7, 8, 9,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			convertBST(node);
		}
	}

	public static BinaryTreeNode convertBST(BinaryTreeNode root) {
		if(root!=null){
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			stack.push(root);
			List<Integer> list = new ArrayList<Integer>();
			while(!stack.empty()){
				BinaryTreeNode node = stack.pop();
				list.add(Integer.parseInt(node.value));
				if(node.right!=null)
					stack.push(node.right);
				
				if(node.left!=null)
					stack.push(node.left);
			}
			
			list.stream().forEach(t -> System.out.print(t + ","));
			System.out.println();
			stack.push(root);
			List<Integer> newList = new ArrayList<Integer>();
			while(!stack.empty()){
				BinaryTreeNode node = stack.pop();
				Integer tempValue =  Integer.parseInt(node.value);
				Integer value =  Integer.parseInt(node.value);
				for (Iterator <Integer>iterator = list.iterator(); iterator.hasNext();) {
					Integer integer = iterator.next();
					if(tempValue<integer){
						value+=integer;
					}
				}
				newList.add(value);
				node.value=""+value;
				if(node.right!=null)
					stack.push(node.right);
				
				if(node.left!=null)
					stack.push(node.left);
			}
			newList.stream().forEach(t -> System.out.print(t + ","));
			System.out.println();
		}
		
		return root;
	}

}
