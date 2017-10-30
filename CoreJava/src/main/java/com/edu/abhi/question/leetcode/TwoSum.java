package com.edu.abhi.question.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author abhishekkhare
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int [] nums = {2, 7, 11, 15};
		int target =9;
		int [] pair = bruteForce(nums,target);
		System.out.println(Arrays.toString(pair));
		target =22;
		System.out.println(Arrays.toString(bruteForce(nums,target)));
		System.out.println(Arrays.toString(twoPassHashTable(nums,target)));
		System.out.println(Arrays.toString(onePassHashTable(nums,target)));
	}

	/**
	 * Time complexity : O(n^2).
	 * Space complexity : O(1).
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int[] bruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if((target-nums[j])==nums[i]){
					return new int[] { i, j };
				}
			}
		}
		throw new RuntimeException("No two sum solution");
	}

	/**
	 * Time complexity : O(n). 
	 * Space complexity : O(1).
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int[] twoPassHashTable(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    //put everything in a hashmap.
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {// 1st check to find if it exist and 2nd check its not the same element.
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new RuntimeException("No two sum solution");
	}
	
	private static int[] onePassHashTable(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
}
