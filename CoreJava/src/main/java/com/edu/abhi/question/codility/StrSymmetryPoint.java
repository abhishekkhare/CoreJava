package com.edu.abhi.question.codility;

public class StrSymmetryPoint {

	public static void main(String[] args) {
		System.out.println(solution("racecar"));

	}

	public static int solution(String S) {
		int length = S.length();
		if (length % 2 != 0 && isPalindrome(S)) {
			return length / 2;
		} else {
			return -1;
		}
	}

	static boolean  isPalindrome(String S) {
		for (int i = 0, j = S.length() - 1; i < j; i++, j--) {
			if (S.charAt(i) != S.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
