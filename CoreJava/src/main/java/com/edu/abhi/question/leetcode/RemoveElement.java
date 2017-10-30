package com.edu.abhi.question.leetcode;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * @author abhishekkhare
 *
 */
public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 8, 9, 9, 9, 9, 9 };
		System.out.println(removeElement(nums, 9));
	}

	public static int removeElement(int[] nums, int val) {
		int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	}
}
