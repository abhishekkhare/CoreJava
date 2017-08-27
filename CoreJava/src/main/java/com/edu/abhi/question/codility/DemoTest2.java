package com.edu.abhi.question.codility;

public class DemoTest2 {

	public static void main(String[] args) {
		System.out.println(solution(12, 56));
		System.out.println(solution(56, 12));
		System.out.println(solution(12345, 678));
		System.out.println(solution(123, 67890));
		System.out.println(solution(0, 10234));
		System.out.println(solution(10234, 0));
		System.out.println(solution(0, 0));
		System.out.println(solution(123, 123));
		System.out.println(solution(123, 123));
		System.out.println(solution(12345, 67890));
		System.out.println(solution(2, 1));
		System.out.println(solution(222, 000));
		System.out.println(solution(100000000,100000000));
	}

	public static int solution(int A, int B) {
		String aS = ""+A;
		String bS = ""+B;
		int counter=0;
		int aLen = aS.length();
		int bLen = bS.length();
		if(aLen>bLen){
			counter=aLen;
		}else{
			counter=bLen;
		}
		StringBuffer sb = new StringBuffer();
		System.out.println(aS +" -- "+ bS);
		for (int i = 0; i < counter; i++) {
			if(i<aLen)
				sb.append(aS.charAt(i));
			if(i<bLen)
				sb.append(bS.charAt(i));
		}
		
		long zip = Long.parseLong(sb.toString());
		System.out.println("zip=" + zip);
		if(zip > 100000000)
			return -1;		
		return (int)zip;

	}
}
