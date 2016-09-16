package com.edu.abhi.regularexpressions;

import java.util.regex.*;

public class RegularExp2 {
	static String longString = " Derek Banas CA 12345 PA AK (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 1-408-323-9822 Cd  Cc  CC  dd  df ";
	static String strangeString = " 1Z aaa **** *** {{{ {{ { ";

	
	public static void main(String[] args) {
		/** Common matching symbols
		 * .		Matches any character
		 * 
		 *^regex	Finds regex that must match at the beginning of the line.
		 *
		 *regex$	Finds regex that must match at the end of the line.
		 *
		 *[abc]		Set definition, can match the letter a or b or c.
		 *
		 *[abc][vz]	Set definition, can match a or b or c followed by either v or z.
		 *
		 *[^abc]	When a caret appears as the first character inside square brackets, it negates the pattern. This can match any character except a or b or c.
		 *
		 *[a-d1-7]	Ranges: matches a letter between a and d and figures from 1 to 7, but not d1.
		 *
		 *X|Z		Finds X or Z.
		 *
		 *XZ		Finds X directly followed by Z.
		 *
		 *$			Checks if a line end follows.
		 */
		
		//regexChecker(".{3}"," AB ABCD 123456789");
		//regexChecker("^.{3}"," AB ABCD 123456789");
		//regexChecker(".{3}$"," AB ABCD 123456789");
		//regexChecker("[123]"," AB ABCD 123456789 54123678");
		//regexChecker("[123][45]"," AB ABCD 123456789 1235678");
		//regexChecker("[^123][45]"," AB ABCD 6457 123456789 1235678");
		//regexChecker("[a-d1-2]"," AB ABcCD 6457 123456789 1235678");
		//regexChecker("A|8"," AB ABcCD 6457 123456789 1235678");
		//regexChecker("Bc"," AB ABcCD 6457 123456789 1235678");
		
		/** Metacharacters
		 * 
		 * \d	Any digit, short for [0-9]
		 * 
		 * \D	A non-digit, short for [^0-9]
		 * 
		 * \s	A whitespace character, short for [ \t\n\x0b\r\f]
		 * 
		 * \S	A non-whitespace character, short for [^\s]
		 * 
		 * \w	A word character, short for [a-zA-Z_0-9]
		 * 
		 * \W	A non-word character [^\w]
		 * 
		 * \S+	Several non-whitespace characters
		 * 
		 * \b	Matches a word boundary where a word character is [a-zA-Z0-9_]. (Not Understood)
		 * 
		 */
		
		//regexChecker("\\d"," AB ABcCD 6457 123456789 1235678");
		//regexChecker("\\D"," AB ABcCD 6457 123456789 1235678");
		//regexChecker("\\s"," AB ABcCD 6457 1234		56789 1235678");
		//regexChecker("\\S"," AB ABcCD 6457 1234		56789 1235678");
		//regexChecker("\\w"," AB ABcCD 6457 1234		56789 1235678___XXX....YYYY");
		//regexChecker("\\W"," AB ABcCD 6457 1234		56789 1235678___XXX....YYYY");
		//regexChecker("\\S+"," AB ABcCD 6457 1234		56789 1235678___XXX....YYYY");
		//regexChecker("\\b"," AB ABcCD 6457 1234		56789 1235678___XXX....YYYY");
		/**
		 * Quantifier
		 * 	*		Occurs zero or more times, is short for {0,}	X* finds no or several letter X,  .* finds any character sequence
		 * 
		 * 	+		Occurs one or more times, is short for {1,}	X+ Finds one or several letter X
		 * 
		 * 	?		Occurs no or one times, ? is short for {0,1}.	X? finds no or exactly one letter X
		 * 
		 * {X}		Occurs X number of times, {} describes the order of the preceding liberal	\d{3} searches for three digits, .{10} for any character sequence of length 10.
		 * 
		 * {X,Y}	Occurs between X and Y times,	\d{1,4} means \d must occur at least once and at a maximum of four.
		 * 
		 * *?		? after a quantifier makes it a reluctant quantifier. It tries to find the smallest match. This makes the regular expression stop at the first match.(Not Understood)
		 * 
		 */
		//regexChecker("X*Y","XYX YY KY");
		//regexChecker("K*Y","XYX YY KY");
		
		//regexChecker("X+Y","XYX YY KY");
		//regexChecker("K+Y","XYX YY KY");
		
		//regexChecker("X?Y","XYX YY KY");
		//regexChecker("K?Y","XYX YY KY");
		
		//regexChecker("X{3}Y","XXXYX XXYY KKKY KKY");
		//regexChecker("K{2}Y","XXXYX XXYY KKKY KKY");
		
		
		//regexChecker("X{2,3}Y","XXXYX XXYY  XXXXXXYYYY KKKY KKY");
		
		
		/**
		 * 
		 * You can group parts of your regular expression. In your pattern you group elements with round brackets, e.g., (). 
		 * This allows you to assign a repetition operator to a complete group.
		 * 
		 */
		/**
		 * any word character, followed by one or more white spaces, followed by any character or ,
		 */
		
		// Removes whitespace between a word character and . or ,
		//regexChecker("(\\w)(\\s+)([\\.,])","XCCX1 ,dhff");
		//regexChecker("(\\w)(\\s+)([\\.,])","XCCX1 .dhff");
		//regexChecker("(\\w)(\\s+)([\\.,])","XCCX1 dhff");
		//System.out.println("XCCX1 ,dhff".replaceAll("(\\w)(\\s+)([\\.,])", "#"));
		
		
		// Extract the text between the two title elements
		//regexChecker("(?i)(<title.*?>)(.+?)(</title>)","<title>abhishek</title>");
		//regexChecker("(?i)(<title.*?>)(.+?)(</title>)","<HTML><title>abhishek</title>");
		//regexChecker("(?i)(<title.*?>)(.+?)(</title>)","<HTML><title name=atr>abhishek</title>");
		
		//System.out.println("<HTML><title name=atr>abhishek</title>".replaceAll("(?i)(<title.*?>)(.+?)(</title>)", "khare"));
		
		/**
		 * Negative Lookahead : Negative Lookahead provides the possibility to exclude a pattern. With this you can say that a string should not be followed by another string.
		 * Negative Lookahead is defined via (?!pattern).
		 */
		
		//regexChecker("a(?!b)","xyz ab a ac cb xx");
		
		//Some more example
		//if the string matches exactly "true"
		//regexChecker("true","this should return true or false");
		
		//if the string matches exactly "true" or "True"
		//regexChecker("[tT]rue","this should return true or True or tRue");
		
		//if the string matches exactly "true" or "True" or "yes" or "Yes"

		//regexChecker("[tT]rue|[yY]es","this should return true or True or tRue or Yes or Yes or No no");
		
		//if the string contains exactly "true"
		//regexChecker(".*true.*","this should return true or True or tRue or Yes or Yes or No no");
		
		//if the string contains of three letters
		//regexChecker("[a-zA-Z]{3}","ABCD EFG PQR LMNOP XYZ");
		
		//if the string does not have a number at the beginning
		//regexChecker("^[^\\d].*","abc");
		//regexChecker("^[^\\d].*","1abcd");
		
		//if the string contains a arbitrary number of characters except b
		//regexChecker("([\\w&&[^b]])*","abcksdfkdskfsdfdsf");
		//regexChecker("([\\w&&[^b]])*","skdskfjsmcnxmvjwque484242");
		
		//if the string contains a number less then 300
		regexChecker("[^0-9]*[12]?[0-9]{1,2}[^0-9]*","400");
		regexChecker("[^0-9]*[12]?[0-9]{1,2}[^0-9]*","300");
		regexChecker("[^0-9]*[12]?[0-9]{1,2}[^0-9]*","299");
		regexChecker("[^0-9]*[12]?[0-9]{1,2}[^0-9]*","1");
		
	}

	public static void regexChecker(String theRegex, String str2Check) {
		// You define your regular expression (REGEX) using Pattern
		Pattern checkRegex = Pattern.compile(theRegex);

		// Creates a Matcher object that searches the String for
		// anything that matches the REGEX

		Matcher regexMatcher = checkRegex.matcher(str2Check);

		// Cycle through the positive matches and print them to screen
		// Make sure string isn't empty and trim off any whitespace
		System.out.println(str2Check);
		while (regexMatcher.find()) {
			if (regexMatcher.group().length() != 0) {
				
				System.out.print(regexMatcher.group().trim() + " -- ");

				// You can get the starting and ending indexs

				System.out.println("Start Index: " + regexMatcher.start());
				System.out.println("Start Index: " + regexMatcher.end());
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
