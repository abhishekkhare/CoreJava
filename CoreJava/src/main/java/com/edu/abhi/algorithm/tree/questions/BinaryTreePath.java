package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This algorithm is very important, since a lot of questions can be solved if you can find the binary tree path. 
 * 
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 * 
 * @author abhishekkhare
 *
 */
public class BinaryTreePath {

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
	        StringBuilder sb = new StringBuilder();
	        sb.append(al.get(0));
	        for(int i=1; i<al.size();i++){
	            sb.append("->"+al.get(i));
	        }
	 
	        finalResult.add(sb.toString());
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
