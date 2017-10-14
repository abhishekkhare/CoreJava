package com.edu.abhi.algorithm.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.edu.abhi.algorithm.tree.GenerateTree;

/**
 * 
 * Depth First Traversals
 * 
 * Inorder Traversal (Left-Root-Right)
 * 
 * Preorder Traversal (Root-Left-Right)
 * 
 * Postorder Traversal (Left-Right-Root)
 * 
 * Breadth-first search (BFS) - It starts at the tree root (or some arbitrary
 * node of a graph, sometimes referred to as a 'search key'[1]) and explores the
 * neighbor nodes first, before moving to the next level neighbours.
 * 
 * @author abhishekkhare
 *
 */
public class TreeTraversal {

	/**
	 * parent node is processed before its children.
	 * 
	 * The key is using a stack to store left and right children, and push right
	 * child first so that it is processed after the left child.
	 * 
	 * Start with root and cycle down to all the left childeren,once we hit
	 * null, we jump up one parent and go to right child
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<String> preorderTraversal(BinaryTreeNode root) {
		ArrayList<String> returnList = new ArrayList<String>();
		if (root == null)
			return returnList;

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);

		while (!stack.empty()) {
			BinaryTreeNode n = stack.pop();
			returnList.add(n.value);

			if (n.right != null) {
				stack.push(n.right);
			}

			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return returnList;
	}

	/**
	 * The order of "inorder" is: left child -> parent -> right child
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<String> inorderTraversal(BinaryTreeNode root) {
		ArrayList<String> lst = new ArrayList<String>();

		if (root == null)
			return lst;

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		// define a pointer to track nodes
		BinaryTreeNode p = root;

		while (!stack.empty() || p != null) {
			// if it is not null, push to stack and go down the tree to left
			if (p != null) {
				stack.push(p);
				p = p.left;
				// if no left child pop stack, process the node then let p point
				// to the right
			} else {
				BinaryTreeNode t = stack.pop();
				lst.add(t.value);
				p = t.right;
			}
		}

		return lst;
	}

	/**
	 * The order of "Postorder" is: left child -> right child -> parent node.
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<String> postorderTraversal(BinaryTreeNode root) {
		ArrayList<String> lst = new ArrayList<String>();

		if (root == null)
			return lst;

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);

		BinaryTreeNode prev = null;
		while (!stack.empty()) {
			BinaryTreeNode curr = stack.peek();

			// go down the tree.
			// check if current node is leaf, if so, process it and pop stack,
			// otherwise, keep going down
			if (prev == null || prev.left == curr || prev.right == curr) {
				// prev == null is the situation for the root node
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					lst.add(curr.value);
				}

				// go up the tree from left node
				// need to check if there is a right child
				// if yes, push it to stack
				// otherwise, process parent and pop stack
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					lst.add(curr.value);
				}

				// go up the tree from right node
				// after coming back from right node, process parent node and
				// pop stack.
			} else if (curr.right == prev) {
				stack.pop();
				lst.add(curr.value);
			}

			prev = curr;
		}

		return lst;
	}

	public static ArrayList<String> bfsTraversal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		List<BinaryTreeNode> tempStack = new ArrayList<BinaryTreeNode>();
		if(root!=null){
			System.out.println(root.value);
			if(root.right!=null)
				stack.push(root.right);
			if(root.left!=null)
				stack.push(root.left);
		}
		while(!stack.isEmpty()){
			BinaryTreeNode node = stack.pop();
			System.out.println(node.value);
			tempStack.add(node);
			if(stack.isEmpty()){
				for (int i = tempStack.size()-1; i >= 0; i--) {
					BinaryTreeNode binaryTreeNode = tempStack.get(i);
							if(binaryTreeNode.right!=null)
								stack.push(binaryTreeNode.right);
							if(binaryTreeNode.left!=null)
								stack.push(binaryTreeNode.left);
				}
				tempStack = new ArrayList<BinaryTreeNode>();
			}
			
		}
		return null;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = GenerateTree.balacedBinaryTree();
		System.out.println("******************** Pre Order (Root-Left-Right)*********************************");
		{
			ArrayList<String> returnList = TreeTraversal.preorderTraversal(root);
			returnList.stream().forEach(n -> System.out.println(n));
		}
		System.out
				.println("******************** Inorder Traversal (Left-Root-Right) *********************************");
		{
			ArrayList<String> returnList = TreeTraversal.inorderTraversal(root);
			returnList.stream().forEach(n -> System.out.println(n));
		}

		System.out.println(
				"********************* Postorder Traversal (Left-Right-Root) ********************************");
		{
			ArrayList<String> returnList = TreeTraversal.postorderTraversal(root);
			returnList.stream().forEach(n -> System.out.println(n));
		}

		System.out.println(
				"********************* Breadth First Search ********************************");
		TreeTraversal.bfsTraversal(root);
	}

}
