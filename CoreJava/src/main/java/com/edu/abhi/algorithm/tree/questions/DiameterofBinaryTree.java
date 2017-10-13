package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * 
 * Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 * @author abhishekkhare
 *
 */
public class DiameterofBinaryTree {



	public static void main(String[] args) {
		{
			int[] array = new int[] { 5,10,15,20,21,22,23,25,26,28,29,30,35,40,45,50,55,60,70,80};
			BinaryTreeNode node = ConvertSortedArrayToBST.sortedArrayToBST(array);
			System.out.println(binaryTreePaths(node));
		}
		System.out.println("******************************************");
		{
			BinaryTreeNode node = ConvertSortedArrayToBST.unbalancedBST();
			binaryTreePaths(node).stream().sorted(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.length()-o1.length();
				}
			}).forEach(t -> System.out.println(t));
			
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


	public int diameterOfBinaryTree(BinaryTreeNode root) {
		
		//if(root!=null)
			
		
		return 0;
	}
}
