package com.edu.abhi.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public String value;
	public List<TreeNode> children = new ArrayList<TreeNode>();;

	public TreeNode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	
	

}
