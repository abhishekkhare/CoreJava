package com.edu.abhi.regularexpressions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * ^ - new line or negate
 * $ - end of line
 * d - Digit
 * D - Non Digit
 * w - word
 * W - non word
 * s - whitespace
 * S - non whitespace
 * b - word boundary
 * * - 0 or more times
 * + - 1 or more times
 * ? - 0 or 1 times
 * {n} - n times
 * {X,Y} - Occurs between X and Y times
 * 
 * @author abhishekkhare
 *
 */
public class RegexTestStrings {
	public static final String EXAMPLE_TEST = "This     is my small . example , string which I'm going to "
			+ "use for pattern matching. <title hello> world </title>";
	public static final String TEST_STRING = "ABC 12A XYZ $#% ALMN ABCD 1234 KLPD 4345 AE BD CE CD lmno ABD   pqr 23ere @#@$^*( AAA AA AAAAAA";

	public static void main(String[] args) {
		
		  //System.out.println(EXAMPLE_TEST.matches("\\w.*")); 
		  //String[] splitString = (EXAMPLE_TEST.split("\\s+"));
		  //System.out.println(splitString.length);
		  //for (String string : splitString) {
			 // System.out.println(string);
		  //}
		  // replace allwhitespace with tabs
		  //System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
		 
		 //matchAnyCharacter();
		// matchBegeningOfLine();
		//matchEndOfLine();
		// matchAnyCharacterInGroup();
		 //matchAnyCharacterInOneGroupFollowedByAnother();
		// doNotMatchAnyCharacterInGroup();
		// matchAnyCharacterInRange();
		//findOneorOtherCharacter();
		// findOneDirectlyFollowedOtherCharacter();
		/**
		 * The following meta characters have a pre-defined meaning and make
		 * certain common patterns easier to use, e.g., \d instead of [0..9].
		 */
		 //findAnyDigit();
		 //findAnyNonDigit();
		 //findAnyWhiteSpace();
		// findAnyNonWhiteSpace();
		 //findAnyWordCharacter();
		//findAnyNonWordCharacter();
		 //findSeveralWhiteSpace();
		 //findSeveralNonWhiteSpace();
		//matchWordBoundry();
		/**
		 * A quantifier defines how often an element can occur. The symbols ?,
		 * *, + and {} define the quantity of the regular expressions
		 */
		 //occursZeroOrMoreTimes();
		// occursOneOrMoreTimes();
		 //occursZeroOrOneTime();
		//occursXTime();
		//occursBetweenXAndYTime();

		/**
		 * Grouping - In your pattern you group elements with round brackets,
		 * e.g., (). this allows you to assign a repetition operator to a
		 * complete group.
		 * 
		 * In addition these groups also create a backreference to the part of
		 * the regular expression. This captures the group. A backreference
		 * stores the part of the String which matched the group. This allows
		 * you to use this part in the replacement.
		 * 
		 * Via the $ you can refer to a group. $1 is the first group, $2 the
		 * second, etc.
		 * 
		 */

		 //groupingExample();
		/**
		 * Negative Lookahead provides the possibility to exclude a pattern.
		 * With this you can say that a string should not be followed by another
		 * string.
		 * 
		 * Negative Lookaheads are defined via (?!pattern).
		 */
		 //negativeLookAhead();
		/**
		 * Backslashes in Java -The backslash \ is an escape character in Java
		 * Strings. That means backslash has a predefined meaning in Java. You
		 * have to use double backslash \\ to define a single backslash. If you
		 * want to define \w, then you must be using \\w in your regex. If you
		 * want to use backslash as a literal, you have to type \\\\ as \ is
		 * also an escape character in regular expressions.
		 */
		 //moreExamples();
		 //moreExamples1();
		//moreExamples2();
		moreExamples3();
	}

	private static void moreExamples3() {
		//String input = "<script type=\"application/ld+json\">Hi Some JSON Text </script>";
		String input="";
		try {
			input = getSegment("/Users/abhishekkhare/Downloads/WSWork/JSON Regex Filter/jsonld.inc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pattern p = Pattern.compile("(<script.*\">)|(</script>)");
		System.out.println(input);
		Matcher matcher = p.matcher(input);		
		List<String> animals = new ArrayList<String>();		
		while (matcher.find()) {
			System.out.println("Found a " + matcher.group() + ".");
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println();
			animals.add(matcher.group());
		}
		
	}
	
	protected static String getSegment(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		  return new String(encoded, Charset.defaultCharset());
	}

	private static void moreExamples2() {
		{
			String input = "I have a cat, but I like my dog better.";

			Pattern p = Pattern.compile("(mouse|cat|dog|wolf|bear|human)");
			Matcher m = p.matcher(input);

			List<String> animals = new ArrayList<String>();
			while (m.find()) {
				System.out.println("Found a " + m.group() + ".");
				animals.add(m.group());
			}
		}
		System.out.println("11111111111111111111");
		{
			List<String> input = new ArrayList<String>();
			input.add("123-45-6789");
			input.add("9876-5-4321");
			input.add("987-65-4321 (attack)");
			input.add("987-65-4321 ");
			input.add("192-83-7465");


			for (String ssn : input) {
				if (ssn.matches("(\\d{3}-\\d{2}-\\d{4})")) {
					System.out.println("Found good SSN: " + ssn);
				}
			}
		}
		System.out.println("3333333333333333333333333333");
		{
			String input = 
	                  "User clientId=23421. Some more text clientId=33432. This clientNum=100";

			Pattern p = Pattern.compile("(clientId=)(\\d+)");
			Matcher m = p.matcher(input);

			StringBuffer result = new StringBuffer();
			while (m.find()) {
				System.out.println("Masking: " + m.group(2));
				m.appendReplacement(result, m.group(1) + "***masked***");
			}
			m.appendTail(result);
			System.out.println(result);
		}
		
		
	}

	private static void moreExamples1() {
		// using pattern with flags
				Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher("ABcabdAb");
				// using Matcher find(), group(), start() and end() methods
				while (matcher.find()) {
					System.out.println("Found the text \"" + matcher.group()
							+ "\" starting at " + matcher.start()
							+ " index and ending at index " + matcher.end());
				}

				// using Pattern split() method
				pattern = Pattern.compile("\\W");
				String[] words = pattern.split("one@two#three:four$five");
				for (String s : words) {
					System.out.println("Split using Pattern.split(): " + s);
				}

				// using Matcher.replaceFirst() and replaceAll() methods
				pattern = Pattern.compile("1*2");
				matcher = pattern.matcher("112345126781122");
				System.out.println("Using replaceAll: " + matcher.replaceAll("__"));
				System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
		
	}

	private static void moreExamples() {
		String s = "humbapumpa jim";
		System.out.println(s.matches(".*(jim|joe).*"));
		System.out.println(s.replaceAll("(jim|joe)","#"));
		s = "humbapumpa jom";
		System.out.println(s.matches(".*(jim|joe).*"));
		s = "humbaPumpa joe";
		System.out.println(s.matches(".*(jim|joe).*"));
		s = "humbapumpa joe jim";
		System.out.println(s.matches(".*(jim|joe).*"));
		System.out.println("11111111111111111111111111111111111111111111111");
		{
			String line = "This order was placed for QT3000! OK?";
			String pattern = "(.*)(\\d+)(.*)";
			// Create a Pattern object
			Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			Matcher m = r.matcher(line);
			if (m.find()) {
				System.out.println("Found value: " + m.group(0));
				System.out.println("Found value: " + m.group(1));
				System.out.println("Found value: " + m.group(2));
				System.out.println("Found value: " + m.group(3));
			} else {
				System.out.println("NO MATCH");
			}
		}
		System.out.println("22222222222222222222222222222222");
		{
			String REGEX = "\\bcat\\b";
			String INPUT = "cat cat cat cattie cat";
			Pattern p = Pattern.compile(REGEX);
			Matcher m = p.matcher(INPUT); // get a matcher object
			int count = 0;

			while (m.find()) {
				count++;
				System.out.println("Match number " + count);
				System.out.println("start(): " + m.start());
				System.out.println("end(): " + m.end());
			}
		}

		System.out.println("33333333333333333333333333333333");
		{
			String REGEX = "foo";
			String INPUT = "fooooooooooooooooo";
			Pattern pattern = Pattern.compile(REGEX);
			Matcher matcher = pattern.matcher(INPUT);

			System.out.println("Current REGEX is: " + REGEX);
			System.out.println("Current INPUT is: " + INPUT);

			System.out.println("lookingAt(): " + matcher.lookingAt());
			System.out.println("matches(): " + matcher.matches());
		}
		System.out.println("444444444444444444444444444444444");
		{
			String REGEX = "dog";
			String INPUT = "The dog says meow. " + "All dogs say meow.";
			String REPLACE = "cat";
			Pattern p = Pattern.compile(REGEX);
			// get a matcher object
			Matcher m = p.matcher(INPUT);
			INPUT = m.replaceAll(REPLACE);
			System.out.println(INPUT);
		}
		System.out.println("555555555555555555555555555555555");
		{
			String REGEX = "a*b";
			String INPUT = "aabfooaabfooabfoob";
			String REPLACE = "-";
			Pattern p = Pattern.compile(REGEX);
			// get a matcher object
			Matcher m = p.matcher(INPUT);
			StringBuffer sb = new StringBuffer();
			while (m.find()) {
				m.appendReplacement(sb, REPLACE);
			}
			m.appendTail(sb);
			System.out.println(sb.toString());

		}
	}

	/**
	 * For example, the following will match "A" if "a" is not followed by "B".
	 */
	private static void negativeLookAhead() {
		System.out.println(TEST_STRING);
		{
			Pattern pattern = Pattern.compile("A(?!BC)");
			Matcher matcher = pattern.matcher(TEST_STRING);
			while (matcher.find()) {
				System.out.print("Start index: " + matcher.start());
				System.out.print(" End index: " + matcher.end() + " ");
				System.out.println(matcher.group());
				System.out.println(matcher.replaceAll("*"));
			}
		}

	}

	private static void groupingExample() {
		// Removes whitespace between a word character and . or ,
		String pattern = "(\\w)(\\s+)([\\.,])";
		System.out.println(EXAMPLE_TEST);
		System.out.println("Replace:"+EXAMPLE_TEST.replaceAll(pattern, "$1$3"));

		// Extract the text between the two title elements
		pattern = "(?i)(<title.*?>)(.+?)(</title>)";
		System.out.println("Replace1:"+EXAMPLE_TEST.replaceAll(pattern, "$1"));
		System.out.println("Replace2:"+EXAMPLE_TEST.replaceAll(pattern, "$2"));
		
		System.out.println("Replace3:"+EXAMPLE_TEST.replaceAll(pattern, "$3"));
		System.out.println("Replace4:"+EXAMPLE_TEST.replaceAll(pattern, "$1$3"));

	}

	/**
	 * {X,Y} Occurs between X and Y times,
	 */
	private static void occursBetweenXAndYTime() {
		System.out.println(TEST_STRING);
		{
			Pattern pattern = Pattern.compile("\\d{4,6}");
			Matcher matcher = pattern.matcher(TEST_STRING);
			while (matcher.find()) {
				//System.out.print("Start index: " + matcher.start());
				//System.out.print(" End index: " + matcher.end() + " ");
				//System.out.println(matcher.group());
				System.out.println(matcher.replaceAll("*"));
			}
		}
		System.out.println("Another Example");
		System.out.println(TEST_STRING);
		{
			Pattern pattern = Pattern.compile("\\w{3,5}");
			Matcher matcher = pattern.matcher(TEST_STRING);
			while (matcher.find()) {
				//System.out.print("Start index: " + matcher.start());
				//System.out.print(" End index: " + matcher.end() + " ");
				//System.out.println(matcher.group());
				System.out.println(matcher.replaceAll("*"));
			}
		}
	}

	/**
	 * {X} Occurs X number of times, {} describes the order of the preceding
	 * liberal
	 */
	private static void occursXTime() {
		System.out.println(TEST_STRING);
		{
			Pattern pattern = Pattern.compile("\\d{3}");
			Matcher matcher = pattern.matcher(TEST_STRING);
			while (matcher.find()) {
				//System.out.print("Start index: " + matcher.start());
				//System.out.print(" End index: " + matcher.end() + " ");
				//System.out.println(matcher.group());
				System.out.println(matcher.replaceAll("*"));
			}
		}
		System.out.println("Another Example");
		System.out.println(TEST_STRING);
		{
			Pattern pattern = Pattern.compile("\\w{4}");
			Matcher matcher = pattern.matcher(TEST_STRING);
			while (matcher.find()) {
				//System.out.print("Start index: " + matcher.start());
				//System.out.print(" End index: " + matcher.end() + " ");
				//System.out.println(matcher.group());
				System.out.println(matcher.replaceAll("*"));
			}
		}
	}

	/**
	 * ? Occurs no or one times, ? is short for {0,1}.
	 */
	private static void occursZeroOrOneTime() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("A?");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * + Occurs one or more times, is short for {1,}
	 */
	private static void occursOneOrMoreTimes() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("A+");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * * Occurs zero or more times, is short for {0,}
	 */
	private static void occursZeroOrMoreTimes() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("A*");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \b Matches a word boundary where a word character is [a-zA-Z0-9_].
	 */
	private static void matchWordBoundry() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\b");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \S+ Several non-whitespace characters
	 */
	private static void findSeveralNonWhiteSpace() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\S+");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \s+ Several non-whitespace characters
	 */
	private static void findSeveralWhiteSpace() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\s+");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}
	/**
	 * \W A non word character, short for [^a-zA-Z_0-9]
	 */
	private static void findAnyNonWordCharacter() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\W");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \w A word character, short for [a-zA-Z_0-9]
	 */
	private static void findAnyWordCharacter() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\w");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \S A non-whitespace character, short for [^\s]
	 */
	private static void findAnyNonWhiteSpace() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\S");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \s A whitespace character, short for [ \t\n\x0b\r\f]
	 */

	private static void findAnyWhiteSpace() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \D A non-digit, short for [^0-9] includes symbols
	 */
	private static void findAnyNonDigit() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\D");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * \d Any digit, short for [0-9]
	 */
	private static void findAnyDigit() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * 34 Finds 3 directly followed by 4.
	 */

	private static void findOneDirectlyFollowedOtherCharacter() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("34");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}
	}

	/**
	 * D|4 Finds D or 4.
	 */
	private static void findOneorOtherCharacter() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("D|4");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * [A-D4-7] Ranges: matches a letter between A and D and figures from 4 to
	 * 7, but not d4.
	 */
	private static void matchAnyCharacterInRange() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("[A-D4-7]");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * [^ABC] When a caret appears as the first character inside square
	 * brackets, it negates the pattern. This ccontent/an match any character
	 * except a or b or c.
	 */
	private static void doNotMatchAnyCharacterInGroup() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("[^ABC][\\s]");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * [ABC][DE] Set definition, can match a or b or c followed by either d or
	 * e.
	 */
	private static void matchAnyCharacterInOneGroupFollowedByAnother() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("[ABC][DE]");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * [ABC] Set definition, can match the letter A or B or C.
	 */
	private static void matchAnyCharacterInGroup() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("[ABC]");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * regex$ Finds regex that must match at the end of the line.
	 */
	private static void matchEndOfLine() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("AAA$");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * ^regex Finds regex that must match at the beginning of the line.
	 */
	private static void matchBegeningOfLine() {
		Pattern pattern = Pattern.compile("^ABC");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("*"));
		}

	}

	/**
	 * . Matches any character
	 */
	public static void matchAnyCharacter() {
		System.out.println(TEST_STRING);
		Pattern pattern = Pattern.compile("A*");
		Matcher matcher = pattern.matcher(TEST_STRING);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println("Group:" +matcher.group());
			System.out.println("ReplaceAll:"+matcher.replaceAll("*"));
		}
	}
	
}