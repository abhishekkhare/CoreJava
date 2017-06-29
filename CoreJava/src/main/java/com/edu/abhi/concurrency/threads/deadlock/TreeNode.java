package com.edu.abhi.concurrency.threads.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Thread 1: parent.addChild(child); //locks parent
          --> child.setParentOnly(parent);

	Thread 2: child.setParent(parent); //locks child
          --> parent.addChildOnly()

 * @author abhishekkhare
 *
 */
public class TreeNode {

	TreeNode parent = null;
	List<TreeNode> children = new ArrayList<TreeNode>();

	public synchronized void addChild(TreeNode child) {
		if (!this.children.contains(child)) {
			this.children.add(child);
			child.setParentOnly(this);
		}
	}

	public synchronized void addChildOnly(TreeNode child){
	    if(!this.children.contains(child)){
	      this.children.add(child);
	    }
	  }

	public synchronized void setParent(TreeNode parent) {
		this.parent = parent;
		parent.addChildOnly(this);
	}

	public synchronized void setParentOnly(TreeNode parent) {
		this.parent = parent;
	}
}