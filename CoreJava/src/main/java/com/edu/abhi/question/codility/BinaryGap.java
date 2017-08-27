package com.edu.abhi.question.codility;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://codility.com/programmers/lessons/1-iterations/binary_gap/
 * @author abhishekkhare
 *
 */
public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(solution(0));
		System.out.println(solution(9));
		System.out.println(solution(529));
		System.out.println(solution(20));
		System.out.println(solution(15));
		System.out.println(solution(1041));
		System.out.println(solution(10985));
		System.out.println(solution(1234567));
		System.out.println(solution(475769));
		System.out.println(solution(46586936));
		System.out.println(solution(1041));

	}

	public static int solution(int N) {
		int maxGap=0;
		Set<Integer> set = new TreeSet<Integer>();
		String binarString = Integer.toBinaryString(N);
		System.out.println(N+"--"+binarString);
		String temp = binarString;
		while(true){
			//System.out.println(temp);
			int i1 = temp.indexOf("1");
			if(i1<0){
				break;
			}
			set.add(i1);
			temp = temp.substring(i1+1, temp.length());
			
		}
		
		for (Iterator <Integer>iterator = set.iterator(); iterator.hasNext();) {
			Integer integer =  iterator.next();
			//System.out.println(integer);
			if(maxGap<integer){
				maxGap=integer;
			}
			
		}
		return maxGap;
	}

	static int findIndex(int startIndex, String input, int maxGap) {
		int i1 = input.indexOf("1", startIndex);
		if (i1 > -1) {
			int i2 = input.indexOf("1", i1 + 1);
			if (i2 > -1) {
				int diff = i2 - i1-1;
				//System.out.println(i1 +" "+ i2);
				if (diff > maxGap) {
					maxGap = diff;
					if(i2+1<input.length())
						findIndex(i2+1, input.substring(i2+1,input.length()), maxGap);
				}
			}

		}
		return maxGap;
	}
}
