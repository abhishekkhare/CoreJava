package com.edu.abhi.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Java8StreamExample {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<10000000; i++) myList.add(i);
		
		//sequential stream	
		{
			long before = System.currentTimeMillis();
			Stream<Integer> sequentialStream = myList.stream();
			Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p%10000 == 0);
			//highNumsSeq.forEach(item->System.out.println(item));
			long after  = System.currentTimeMillis();
			System.out.println("Diff Seq::" + (after-before));
		}
		//parallel stream
		{
			long before = System.currentTimeMillis();
			Stream<Integer> parallelStream = myList.parallelStream();
			Stream<Integer> highNumsSeq1 = parallelStream.filter(p -> p%10000 == 0);
			//highNumsSeq1.forEach(item->System.out.println(item));
			long after  = System.currentTimeMillis();
			System.out.println("Diff Parallel::" + (after-before));
			
		}
		/**
		 * In most cases for system with multi core, the parallelStream would have better performance.
		 */
		
	}
}
