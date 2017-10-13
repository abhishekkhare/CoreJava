package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.List;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 * 
 * @author abhishekkhare
 *
 */
public class PathSum {

	public static void main(String[] args) {
		{
			int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			System.out.println(binaryTreePaths(node));
		}
		
		System.out.println("**************************************************");
		{
			int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			System.out.println(binaryTreePaths(node));
		}

	}
	
	public static List<String> binaryTreePaths(BinaryTreeNode root) {
	    ArrayList<String> finalResult = new ArrayList<String>();
	    if(root==null)
	        return finalResult;
	 
	    ArrayList<String> curr = new ArrayList<String>();
	    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	 
	    dfs(root, results, curr);
	 
	    for(ArrayList<String> al : results){
	    	int sum =0;
	        StringBuilder sb = new StringBuilder();
	        sb.append(al.get(0));
	        sum+=Integer.parseInt(al.get(0));
	        for(int i=1; i<al.size();i++){
	        	sum+=Integer.parseInt(al.get(i));
	            sb.append("->"+al.get(i));
	        }
	 
	        finalResult.add(sb.toString() + " = " +sum);
	    }
	 
	    return finalResult;
	}
	
	public static void dfs(BinaryTreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr){
	    curr.add(String.valueOf(root.value));
	 
	    if(root.left==null && root.right==null){
	        list.add(curr);
	        return;
	    }
	 
	    if(root.left!=null){
	        ArrayList<String> temp = new ArrayList<String>(curr);
	        dfs(root.left, list, temp);
	    }
	 
	    if(root.right!=null){
	        ArrayList<String> temp = new ArrayList<String>(curr);
	        dfs(root.right, list, temp);
	    } 
	}

}
