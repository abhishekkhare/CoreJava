package com.edu.abhi.algorithm.tree.binarytree;

public class BinaryTreeNode {
	public String value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
    }

	@Override
	public String toString() {
		return "BinaryTreeNode [value=" + value + "]";
	}
    
}
