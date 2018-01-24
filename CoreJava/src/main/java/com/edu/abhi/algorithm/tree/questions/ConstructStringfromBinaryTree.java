package com.edu.abhi.algorithm.tree.questions;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

import java.util.Stack;

/**
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And you
 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 * 
 * 
 * 
 * Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


 * 
 * @author abhishekkhare
 *
 */
public class ConstructStringfromBinaryTree {

	public static void main(String[] args) {
		{
			int[] array = new int[] { 1, 2, 3,4,5,6,7,8};
			BinaryTreeNode root = ConvertSortedArrayToBST.sortedArrayToBST(array);
			System.out.println(tree2str(root));
		}
//		{
//			int[] array = new int[] { 1, 2, 3,4,5,6,7,8};
//			BinaryTreeNode root = ConvertSortedArrayToBST.sortedArrayToBST(array);
//			System.out.println(tree2str(root));	
//		}
		
		
	}

	public static String tree2str(BinaryTreeNode root) {
		String result = "";
		if (root != null) {
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			result += root.value;
			if (root.left != null) {
				root.left.value= "("+root.left.value;
				stack.push(root.left);
			}

			if (root.right != null) {
				root.right.value= "("+root.right.value;
				stack.push(root.right);
			}

			while (!stack.isEmpty()) {
				BinaryTreeNode temp = stack.pop();
				result += temp.value;

				if (temp.left != null) {
					temp.left.value= "("+temp.left.value;
					stack.push(temp.left);
				}else{
					result +=")()";
				}

				if (temp.right != null) {
					temp.right.value= "("+temp.right.value;
					stack.push(temp.right);
				}else{
					result +=")()";
				}
			}
		}

		return result;
	}
}
