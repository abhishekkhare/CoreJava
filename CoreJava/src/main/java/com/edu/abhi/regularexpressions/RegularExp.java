package com.edu.abhi.regularexpressions;

import java.util.regex.*;

public class RegularExp {
	static String longString = " Derek  Banas  CA 12345  PA  AK (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 1-408-323-9822 Cd  Cc  CC  dd  df ";
	static String strangeString = " 1Z aaa **** *** {{{ {{ { ";

	
	public static void main(String[] args) {

		/**
		 * 
		 * Whenever you want to search anything, you want to put it inside of
		 * Brackets []
		 * 
		 * for e.g if you want all upper case letters - [A-Z].
		 * 
		 * if you want all letters either upper or lower case - [A-Za-z]
		 * 
		 * if you want all numbers - [0-9]
		 * 
		 * if you want all letters that are not A-G - [^A-G]
		 * 
		 * match any white space - [\\s]
		 * 
		 * match things that are not white pace - [\\S]
		 * 
		 * match number of time n-min and m-max - {n,m}
		 * 
		 * 
		 */

		/**
		 * Word must contain letters that are 2 to 20 characters in length
		 * [A-Za-z]{2,20} 0r \w{2,20} 
		 */
		// regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
		
		/**
		 *   //d - digits or numbers
		 *   //D - digit or numbers
		 *   {5} - number of times
		 *   ZipCode is 5 digit long
		 */
		 //regexChecker("\\s\\d{5}\\s", longString);
		
		/** 2 characters that start with C or A
		 * Must start with a A or C, followed by 1 letter in brackets
		 * Must be a maximum of 2 characters in length
		 */
		
		//regexChecker("A[KLRZ]|C[AOT]", longString);
		
		/** {n,} - if you only want a minimum but no maximum.		
		 * +  \means whatever proceeds must occur one or more times.
		 * . ^ * + ? { } [ ] \ | ( )  Characters that must be escaped or backslashed
		 * one or more {
		 */
		//regexChecker("(\\{{1,})", strangeString);
		//same
		//regexChecker("(\\{+)", strangeString);

		/** . - represents anything but a new line.
		 *  anything as long as there are 3 of them, notice no backslash here.
		 * -- regexChecker(".{3}", strangeString);
		 */
		
		
		/**
		\\w  - Any word type character A-Z, a-z, 0-9, _
		\\W  - Any non word character
		 *   -  Occurs zero or more times
		*/
		
		//regexChecker("\\w*", strangeString);
		
		//look for email address 
		
		regexChecker("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[A-Za-z]{2,4}", longString);
		
		// ?  0 or 1 of what proceeds it
		//Phone number
		//regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7})", longString);
		//regexReplace(longString);
	}

	public static void regexChecker(String theRegex, String str2Check) {
		// You define your regular expression (REGEX) using Pattern
		Pattern checkRegex = Pattern.compile(theRegex);

		// Creates a Matcher object that searches the String for
		// anything that matches the REGEX

		Matcher regexMatcher = checkRegex.matcher(str2Check);

		// Cycle through the positive matches and print them to screen
		// Make sure string isn't empty and trim off any whitespace

		while (regexMatcher.find()) {
			if (regexMatcher.group().length() != 0) {
				System.out.println("Input: "+str2Check);
				System.out.println("Output: "+regexMatcher.group().trim());

				// You can get the starting and ending indexs

				//System.out.println("Start Index: " + regexMatcher.start());
				//System.out.println("Start Index: " + regexMatcher.end());
			}else{
				System.out.println("Empty");
				
			}
		}

		System.out.println();
	}

public static void regexReplace(String str2Replace){
		
		// REGEX that matches 1 or more white space
		
		Pattern replace = Pattern.compile("\\s+");
		
		// This doesn't really apply, but this is how you ignore case
		// Pattern replace = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
		
		// trim the string t prepare it for a replace
		
		Matcher regexMatcher = replace.matcher(str2Replace.trim());
		
		// replaceAll replaces all white space with commas
		
		System.out.println(regexMatcher.replaceAll(", "));
		
	}
}
