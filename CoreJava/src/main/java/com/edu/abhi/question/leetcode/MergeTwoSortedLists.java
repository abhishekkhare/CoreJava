package com.edu.abhi.question.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author abhishekkhare
 *
 */
public class MergeTwoSortedLists {
	static ListNode l1 = null;
	static ListNode l2 = null;

	public static void main(String[] args) {

		for (int i = 0; i <= 100; i+=7) {
			if (i % 3 == 0)
				addNodeL1(new ListNode(i));
			else
				addNodeL2(new ListNode(i));

		}
		printList(l1);
		System.out.println();
		printList(l2);
		ListNode l3 = mergeTwoLists(l1, l2);
		System.out.println();
		printList(l3);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	private static void printList(ListNode l12) {
		while (l12.next != null) {
			System.out.print(l12.val + " , ");
			l12 = l12.next;
		}
		System.out.print(l12.val + " , ");

	}

	private static void addNodeL1(ListNode l) {
		if (l1 == null) {
			l1 = l;
			l1.next = null;
		} else {
			ListNode current = l1;
			while (current.next != null) {
				current = current.next;
			}
			current.next = l;
			l.next = null;
		}
	}

	private static void addNodeL2(ListNode l) {
		if (l2 == null) {
			l2 = l;
			l2.next = null;
		} else {
			ListNode current = l2;
			while (current.next != null) {
				current = current.next;
			}
			current.next = l;
			l.next = null;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
