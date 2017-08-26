package com.edu.abhi.question.codility;

import java.util.Stack;

public class Brackets {

	public static void main(String[] args) {
		//System.out.println(solution("{[()()]}"));
		//System.out.println(solution("([)()]"));
		//System.out.println(solution("([)()]{}"));
		//System.out.println(solution("[()]{}"));
		//System.out.println(solution("()[]{}"));
		//System.out.println(solution("[]{})("));
		//System.out.println(solution(")([]{})("));
		//System.out.println(solution("[]{})("));
		//System.out.println(solution("{{{{{"));
		System.out.println(solution("(()(())())"));

	}

	public static int solution(String S) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < S.length(); i++) {
			String temp = S.substring(i, i + 1);
			System.out.println(temp + "---- " + stack);
			switch (temp) {
			case "{":
				stack.push(temp);
				break;
			case "[":
				stack.push(temp);
				break;
			case "(":
				stack.push(temp);
				break;
			case "}": {
				if (stack.isEmpty() || !stack.pop().equals("{"))
					return 0;
				}
				break;
			case "]": {
				if (stack.isEmpty() ||!stack.pop().equals("["))
					return 0;
				}
				break;
			case ")": {
				if (stack.isEmpty() || !stack.pop().equals("("))
					return 0;
				}
				break;
			}
		}

		return stack.size()==0?1:0;
	}

}
