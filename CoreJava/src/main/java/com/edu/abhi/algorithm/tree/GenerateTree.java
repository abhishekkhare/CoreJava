package com.edu.abhi.algorithm.tree;

import com.edu.abhi.algorithm.tree.binarytree.BinaryTreeNode;

public class GenerateTree {

	public static BinaryTreeNode balacedBinaryTree() {

		BinaryTreeNode b1 = new BinaryTreeNode("Root");
		BinaryTreeNode b2 = new BinaryTreeNode("L1");
		BinaryTreeNode b3 = new BinaryTreeNode("R1");
		b1.left = b2;
		b1.right = b3;

		BinaryTreeNode b4 = new BinaryTreeNode("LL2");
		BinaryTreeNode b5 = new BinaryTreeNode("LR2");
		b2.left = b4;
		b2.right = b5;

		BinaryTreeNode b6 = new BinaryTreeNode("RL2");
		BinaryTreeNode b7 = new BinaryTreeNode("RR2");
		b3.left = b6;
		b3.right = b7;

		BinaryTreeNode b8 = new BinaryTreeNode("LLL3");
		BinaryTreeNode b9 = new BinaryTreeNode("LLR3");
		b4.left = b8;
		b4.right = b9;

		BinaryTreeNode b10 = new BinaryTreeNode("LRL3");
		BinaryTreeNode b11 = new BinaryTreeNode("LRR3");
		b5.left = b10;
		b5.right = b11;

		BinaryTreeNode b12 = new BinaryTreeNode("RLL3");
		BinaryTreeNode b13 = new BinaryTreeNode("RLR3");
		b6.left = b12;
		b6.right = b13;

		BinaryTreeNode b14 = new BinaryTreeNode("RRL3");
		BinaryTreeNode b15 = new BinaryTreeNode("RRR3");
		b7.left = b14;
		b7.right = b15;

		return b1;
	}
	
	public static BinaryTreeNode mirrorBinaryTree() {

		BinaryTreeNode b1 = new BinaryTreeNode("Root");
		BinaryTreeNode b2 = new BinaryTreeNode("1");
		BinaryTreeNode b3 = new BinaryTreeNode("1");
		b1.left = b2;
		b1.right = b3;

		BinaryTreeNode b4 = new BinaryTreeNode("2");
		BinaryTreeNode b5 = new BinaryTreeNode("3");
		b2.left = b4;
		b2.right = b5;

		BinaryTreeNode b6 = new BinaryTreeNode("3");
		BinaryTreeNode b7 = new BinaryTreeNode("2");
		b3.left = b6;
		b3.right = b7;

		BinaryTreeNode b8 = new BinaryTreeNode("4");
		BinaryTreeNode b9 = new BinaryTreeNode("5");
		b4.left = b8;
		b4.right = b9;

		BinaryTreeNode b10 = new BinaryTreeNode("6");
		BinaryTreeNode b11 = new BinaryTreeNode("7");
		b5.left = b10;
		b5.right = b11;

		BinaryTreeNode b12 = new BinaryTreeNode("7");
		BinaryTreeNode b13 = new BinaryTreeNode("6");
		b6.left = b12;
		b6.right = b13;

		BinaryTreeNode b14 = new BinaryTreeNode("5");
		BinaryTreeNode b15 = new BinaryTreeNode("4");
		b7.left = b14;
		b7.right = b15;

		return b1;
	}

	public static TreeNode treeWithMultipleChildren() {
		TreeNode tn1 = new TreeNode("Root");
		TreeNode tn11 = new TreeNode("11");
		TreeNode tn12 = new TreeNode("12");
		TreeNode tn13 = new TreeNode("13");
		TreeNode tn14 = new TreeNode("14");

		tn1.children.add(tn11);
		tn1.children.add(tn12);
		tn1.children.add(tn13);
		tn1.children.add(tn14);

		TreeNode tn21 = new TreeNode("21");
		TreeNode tn22 = new TreeNode("22");
		TreeNode tn23 = new TreeNode("23");
		tn11.children.add(tn21);
		tn11.children.add(tn22);
		tn11.children.add(tn23);

		TreeNode tn24 = new TreeNode("24");
		TreeNode tn25 = new TreeNode("25");
		TreeNode tn26 = new TreeNode("26");
		tn12.children.add(tn24);
		tn12.children.add(tn25);
		tn12.children.add(tn26);

		TreeNode tn27 = new TreeNode("27");
		TreeNode tn28 = new TreeNode("28");
		TreeNode tn29 = new TreeNode("29");
		tn14.children.add(tn27);
		tn14.children.add(tn28);
		tn14.children.add(tn29);

		TreeNode tn31 = new TreeNode("31");
		TreeNode tn32 = new TreeNode("32");
		tn21.children.add(tn31);
		tn21.children.add(tn32);

		TreeNode tn33 = new TreeNode("33");
		TreeNode tn34 = new TreeNode("34");
		tn23.children.add(tn33);
		tn23.children.add(tn34);

		return tn1;
	}
	
	public static TreeNode treeWithMultipleChildren1() {
		TreeNode tn1 = new TreeNode("Root");
		TreeNode tn11 = new TreeNode("11");
		TreeNode tn12 = new TreeNode("12");
		TreeNode tn13 = new TreeNode("13");
		TreeNode tn14 = new TreeNode("14");

		tn1.children.add(tn11);
		tn1.children.add(tn12);
		tn1.children.add(tn13);
		tn1.children.add(tn14);

		TreeNode tn21 = new TreeNode("21");
		TreeNode tn22 = new TreeNode("22");
		TreeNode tn23 = new TreeNode("23");
		tn11.children.add(tn21);
		tn11.children.add(tn22);
		tn11.children.add(tn23);

		TreeNode tn24 = new TreeNode("24");
		TreeNode tn25 = new TreeNode("25");
		TreeNode tn26 = new TreeNode("26");
		tn12.children.add(tn24);
		tn12.children.add(tn25);
		tn12.children.add(tn26);

		TreeNode tn27 = new TreeNode("27");
		TreeNode tn28 = new TreeNode("28");
		TreeNode tn29 = new TreeNode("29");
		tn14.children.add(tn27);
		tn14.children.add(tn28);
		tn14.children.add(tn29);

		TreeNode tn31 = new TreeNode("31");
		TreeNode tn32 = new TreeNode("32");
		tn21.children.add(tn31);
		tn21.children.add(tn32);

//		TreeNode tn33 = new TreeNode("33");
//		TreeNode tn34 = new TreeNode("34");
//		tn23.children.add(tn33);
//		tn23.children.add(tn34);

		return tn1;
	}
	
	public static TreeNode treeWithMultipleChildren2() {
		TreeNode tn1 = new TreeNode("Root");
		TreeNode tn11 = new TreeNode("11");
		TreeNode tn12 = new TreeNode("12");
		TreeNode tn13 = new TreeNode("13");
		TreeNode tn14 = new TreeNode("14");

		tn1.children.add(tn11);
		tn1.children.add(tn12);
		tn1.children.add(tn13);
		tn1.children.add(tn14);

//		TreeNode tn21 = new TreeNode("21");
//		TreeNode tn22 = new TreeNode("22");
//		TreeNode tn23 = new TreeNode("23");
//		tn11.children.add(tn21);
//		tn11.children.add(tn22);
//		tn11.children.add(tn23);

		TreeNode tn24 = new TreeNode("24");
		TreeNode tn25 = new TreeNode("25");
		TreeNode tn26 = new TreeNode("26");
		tn12.children.add(tn24);
		tn12.children.add(tn25);
		tn12.children.add(tn26);

		TreeNode tn27 = new TreeNode("27");
		TreeNode tn28 = new TreeNode("28");
		TreeNode tn29 = new TreeNode("29");
		tn14.children.add(tn27);
		tn14.children.add(tn28);
		tn14.children.add(tn29);

//		TreeNode tn31 = new TreeNode("31");
//		TreeNode tn32 = new TreeNode("32");
//		tn21.children.add(tn31);
//		tn21.children.add(tn32);
//
//		TreeNode tn33 = new TreeNode("33");
//		TreeNode tn34 = new TreeNode("34");
//		tn23.children.add(tn33);
//		tn23.children.add(tn34);

		return tn1;
	}
	
	public static TreeNode treeWithMultipleChildren3() {
		TreeNode tn1 = new TreeNode("Root");
		TreeNode tn11 = new TreeNode("11");
		TreeNode tn12 = new TreeNode("12");
		//TreeNode tn13 = new TreeNode("13");
		TreeNode tn14 = new TreeNode("14");

		tn1.children.add(tn11);
		tn1.children.add(tn12);
		//tn1.children.add(tn13);
		tn1.children.add(tn14);

//		TreeNode tn21 = new TreeNode("21");
//		TreeNode tn22 = new TreeNode("22");
//		TreeNode tn23 = new TreeNode("23");
//		tn11.children.add(tn21);
//		tn11.children.add(tn22);
//		tn11.children.add(tn23);
//
//		TreeNode tn24 = new TreeNode("24");
//		TreeNode tn25 = new TreeNode("25");
//		TreeNode tn26 = new TreeNode("26");
//		tn12.children.add(tn24);
//		tn12.children.add(tn25);
//		tn12.children.add(tn26);
//
//		TreeNode tn27 = new TreeNode("27");
//		TreeNode tn28 = new TreeNode("28");
//		TreeNode tn29 = new TreeNode("29");
//		tn14.children.add(tn27);
//		tn14.children.add(tn28);
//		tn14.children.add(tn29);

//		TreeNode tn31 = new TreeNode("31");
//		TreeNode tn32 = new TreeNode("32");
//		tn21.children.add(tn31);
//		tn21.children.add(tn32);
//
//		TreeNode tn33 = new TreeNode("33");
//		TreeNode tn34 = new TreeNode("34");
//		tn23.children.add(tn33);
//		tn23.children.add(tn34);

		return tn1;
	}
}
