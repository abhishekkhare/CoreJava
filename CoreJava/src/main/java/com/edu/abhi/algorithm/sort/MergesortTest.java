package com.edu.abhi.algorithm.sort;

import java.util.Random;

public class MergesortTest{
	 private static int[] numbers;
	  private final static int SIZE = 50;
	  private final static int MAX = 50;
	  
	  public static void main(String [] args){
		  numbers = new int[SIZE];
		    Random generator = new Random();
		    for (int i = 0; i < numbers.length; i++) {
		      numbers[i] = generator.nextInt(MAX);
		    }
		    
		    Mergesort sorter = new Mergesort(numbers);
		    sorter.printHorzArrayBig(numbers.length, -1);
		    sorter.sort();
		    sorter.printHorzArrayBig(numbers.length, -1);
	  }
	  
	 
}
