package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.edu.abhi.algorithm.tree.GenerateTree;
import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * @author abhishekkhare
 *
 */
public class MirrorTree {

	public static void main(String[] args) {
		BinaryTreeNode root = GenerateTree.mirrorBinaryTree();
		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stackL = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stackR = new Stack<BinaryTreeNode>();
		List<BinaryTreeNode> tempStackL = new ArrayList<BinaryTreeNode>();
		List<BinaryTreeNode> tempStackR = new ArrayList<BinaryTreeNode>();
		if(root!=null){
			System.out.println(root.value);
			if(root.right!=null)
				stackR.push(root.right);
			if(root.left!=null)
				stackL.push(root.left);
		}
		while(!stackR.isEmpty() && !stackL.isEmpty()){
			if(stackR.size() != stackL.size())
				return false;
			BinaryTreeNode nodeR = stackR.pop();
			BinaryTreeNode nodeL = stackL.pop();
			if(!nodeR.value.equals(nodeL.value)){
				return false;
			}
			System.out.println(nodeR.value + " == " + nodeL.value);
			tempStackR.add(nodeR);
			tempStackL.add(nodeL);
			if(stackR.isEmpty() && stackL.isEmpty()){
				for (int i = tempStackR.size()-1; i >= 0; i--) {
					BinaryTreeNode binaryTreeNodeR = tempStackR.get(i);
					BinaryTreeNode binaryTreeNodeL = tempStackR.get(i);
					
					if(binaryTreeNodeR.right!=null)
						stackR.push(binaryTreeNodeR.right);
					if(binaryTreeNodeR.left!=null)
						stackR.push(binaryTreeNodeR.left);

					if(binaryTreeNodeL.right!=null)
						stackL.push(binaryTreeNodeL.right);
					if(binaryTreeNodeL.left!=null)
						stackL.push(binaryTreeNodeL.left);
				}
				tempStackL = new ArrayList<BinaryTreeNode>();
				tempStackR = new ArrayList<BinaryTreeNode>();
			}
			
		}
		return true;
	}
}
