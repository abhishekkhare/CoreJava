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
	
	public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + value);
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1)
                    .print(prefix + (isTail ?"    " : "│   "), true);
        }
    }
}	


