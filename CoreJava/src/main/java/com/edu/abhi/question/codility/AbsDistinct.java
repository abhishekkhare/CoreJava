package com.edu.abhi.question.codility;

/*
 * 
 */
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author abhishekkhare
 *
 */
public class AbsDistinct {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{-5,-3,-1,0,3,6}));
	}

	static int solution(int A[]){
		Set<Integer> temp = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if(A[i]<0){
				temp.add(A[i]*-1);
			}else{
				temp.add(A[i]);
			}
		}
		
		return temp.size();
	}
}

