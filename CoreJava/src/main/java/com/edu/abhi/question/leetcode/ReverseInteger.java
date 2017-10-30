package com.edu.abhi.question.leetcode;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * click to show spoilers.
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function
 * should return 0 when the reversed integer overflows.
 * 
 * @author abhishekkhare
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {

		System.out.println(reverse(342));
		System.out.println(reverse(1999999999));

	}

	private static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;//2,4,3
			int newResult = result * 10 + tail;//2,24,243
			System.out.println("newResult:" + newResult + " tail:" + tail + " (newResult - tail) / 10:" + ((newResult - tail) / 10) + " result:" + result);
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;//2,24,243
			x = x / 10;//34,3,0
		}

		return result;

	}

}
