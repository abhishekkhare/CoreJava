package com.edu.abhi.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	public static List<String> getLongestSequence(List<String> userA, List<String> userB) {
		List<List<String>> combinedList = new ArrayList<List<String>>();
		for (int i = 0; i < userA.size(); i++) {
			for (int j = 0; j < userB.size(); j++) {
				List<String> output = new ArrayList<String>();
				while (i < userA.size() && j < userB.size() && removeHTMLFileExtension(userA.get(i)).equals(removeHTMLFileExtension(userB.get(j)))) {
					output.add(userA.get(i));
					i++;
					j++;
				}
				if (output.size() > 0) {
					combinedList.add(output);
				}
			}
		}
		int maxSize = 0;
		List<String> finalList = new ArrayList<>();
		for (List<String> list : combinedList) {
			int tempSize = list.size();
			if (tempSize > maxSize) {
				finalList = list;
				maxSize = tempSize;
			}
		}
		return finalList;
	}
	
	private static String removeHTMLFileExtension(String input){
		if(input.contains("/")){
			input=input.replace("/", "");
		}
		if(input.contains(".html")){
			input=input.replace(".html", "");
		}
		
		return input;
	}

	// START TEST CASES
	//
	// You can add test cases below. Each test case should be an instance of
	// Test
	// constructed with:
	//
	// Test(String name, List<String> userA, List<String> userB, List<String>
	// expectedOutput);
	//

	private static final List<Test> tests = Arrays.asList(new Test(
			//Normal
			// name
			"sample input #1",
			// userA
			Arrays.asList("/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html"),
			// userB
			Arrays.asList("/nine.html", "/two.html", "/three.html", "/four.html", "/six.html", "/seven.html"),
			// expectedOutput
			Arrays.asList("/four.html", "/six.html", "/seven.html")),
			
			new Test(
					// name
					"sample input #2",
					// userA
					Arrays.asList("/one.html", "/two.html", "/three.html", "/four.html", "/six.html"),
					// userB
					Arrays.asList("/nine.html", "/two.html", "/three.html", "/four.html", "/six.html", "/seven.html"),
					// expectedOutput
					Arrays.asList("/two.html", "/three.html", "/four.html", "/six.html")),
			new Test(
					// name
					"sample input #3",
					// userA
					Arrays.asList("/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html"),
					// userB
					Arrays.asList("/three.html", "/eight.html"),
					// expectedOutput
					Arrays.asList()),
			new Test(
					// name
					"sample input #4",
					// userA
					Arrays.asList("/one.html", "/two.html", "/three.html", "/four.html", "/six.html"),
					// userB
					Arrays.asList("/three.html", "/eight.html"),
					// expectedOutput
					Arrays.asList("/three.html")),
			new Test(
					// name
					"sample input #5",
					// userA
					Arrays.asList("/one.html", "/two.html", "/four.html", "/six.html","/eight.html"),
					// userB
					Arrays.asList("/three.html", "/eight.html"),
					// expectedOutput
					Arrays.asList("/eight.html")),
			new Test(
					// name
					"sample input #6",
					// userA
					Arrays.asList("/one.html", "/two.html", "/three.html", "/four.html", "/six.html","/eight.html"),
					// userB
					Arrays.asList("/three.html", "/eight.html"),
					// expectedOutput
					Arrays.asList("/three.html")),
			new Test(
					//Normal
					// name
					"sample input #7",
					// userA
					Arrays.asList("/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html"),
					// userB
					Arrays.asList("nine", "two", "/three", "four.html", "six.html", "/seven"),
					// expectedOutput
					Arrays.asList("/four.html", "/six.html", "/seven.html"))
			);

	// END TEST CASES
	// DO NOT MODIFY BELOW THIS LINE

	private static class Test {

		public String name;
		public List<String> userA;
		public List<String> userB;
		public List<String> expectedOutput;

		public Test(String name, List<String> userA, List<String> userB, List<String> expectedOutput) {
			this.name = name;
			this.userA = userA;
			this.userB = userB;
			this.expectedOutput = expectedOutput;
		}
	}

	private static boolean equalOutputs(List<String> a, List<String> b) {
		return a.equals(b);
	}

	public static void main(String[] args) {
		int passed = 0;
		for (Test test : tests) {
			try {
				System.out.printf("==> Testing %s...\n", test.name);
				List<String> actualOutput = getLongestSequence(test.userA, test.userB);
				if (equalOutputs(actualOutput, test.expectedOutput)) {
					System.out.println("PASS");
					passed++;
				} else {
					System.out.println("FAIL");
					System.out.printf("Expected output: %s\n", test.expectedOutput);
					System.out.printf("Actual output: %s\n", actualOutput);
				}
			} catch (Exception e) {
				System.out.println("FAIL");
				System.out.println(e);
			}
		}
		System.out.printf("==> Passed %d of %d tests\n", passed, tests.size());
	}
}
