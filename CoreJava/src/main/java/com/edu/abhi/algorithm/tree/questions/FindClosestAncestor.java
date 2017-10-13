package com.edu.abhi.algorithm.tree.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**   
 * 							   Root
 * 					/		/		\			\
 * 				L11		L12			L13			L14
 * 			/	\		/	\		/	\		/	\
 *		L21		L22		L23	L24		L25	L26	   L27	L28
 *		|		|		|	 |		 |	 |	    |	 |
 *		L31		L32		L33	L34		L35	 L36	L37	L38
 *										  |
 *										 L41		
 * @author abhishekkhare
 *
 */
public class FindClosestAncestor {

	public static void main(String[] args) {
		Node root = new Node("root", null);

		Node l11 = new Node("l11", root);
		Node l12 = new Node("l12", root);
		Node l13 = new Node("l13", root);
		Node l14 = new Node("l14", root);
		root.children.add(l11);
		root.children.add(l12);
		root.children.add(l13);
		root.children.add(l14);

		Node l21 = new Node("l21", l11);
		Node l22 = new Node("l22", l11);
		l11.children.add(l21);
		l11.children.add(l22);

		Node l23 = new Node("l23", l12);
		Node l24 = new Node("l24", l12);
		l12.children.add(l23);
		l12.children.add(l24);

		Node l25 = new Node("l25", l13);
		Node l26 = new Node("l26", l13);
		l13.children.add(l25);
		l13.children.add(l26);

		Node l27 = new Node("l27", l14);
		Node l28 = new Node("l28", l14);
		l14.children.add(l27);
		l14.children.add(l28);

		Node l31 = new Node("l31", l21);
		l21.children.add(l31);
		Node l32 = new Node("l32", l22);
		l22.children.add(l32);
		Node l33 = new Node("l33", l23);
		l23.children.add(l33);
		Node l34 = new Node("l34", l24);
		l24.children.add(l34);
		Node l35 = new Node("l35", l25);
		l25.children.add(l35);
		Node l36 = new Node("l36", l26);
		l26.children.add(l36);
		Node l37 = new Node("l37", l27);
		l27.children.add(l37);
		Node l38 = new Node("l38", l28);
		l28.children.add(l38);
		
		Node l41 = new Node("l41", l36);
		l36.children.add(l41);

		findClosestAncestor(l32,l25);
		findClosestAncestor(l36,l25);
		findClosestAncestor(l35,l25);
		findClosestAncestor(l41,l25);
	}
	
	private static void findClosestAncestor(Node n1, Node n2){
		List<Node> ans1 = new LinkedList<Node>();
		List<Node> ans2 = new LinkedList<Node>();
		while(n1!=null && n2!=null){
			ans1.add(n1);
			if(ans1.contains(n2) || ans2.contains(n1)){
				System.out.println("Closest Ancestor::" + n1);
				return;
			}
			n1=n1.parent;
			ans2.add(n2);
			if(ans1.contains(n2) || ans2.contains(n1)){
				System.out.println("Closest Ancestor::" + n1);
				return;
			}
			n2=n2.parent;
		}
//		while(n2!=null){
//			ans2.add(n2);
//			n2=n2.parent;
//		}
//		
//		for (Iterator <Node>iterator = ans2.iterator(); iterator.hasNext();) {
//			Node node = iterator.next();
//			if(ans1.contains(node)){
//				System.out.println("Closest Ancestor::" + node);
//				break;
//			}
//			
//		}
		
		
		
	}

	private static class Node {
		String value;
		List<Node> children = new ArrayList<Node>();
		Node parent;

		Node(String value, Node parent) {
			this.value = value;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}

	}
}
