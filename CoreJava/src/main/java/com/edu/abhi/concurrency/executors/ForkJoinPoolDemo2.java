package com.edu.abhi.concurrency.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo2 {

	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[500000000];   
		for (int i = 0; i < 500000000; i++) {
			array[i]  = (int) (Math.random()*10000);
		}
		//System.out.println(Arrays.toString(array));
		long starTime = System.currentTimeMillis();
		System.out.println(Sum.sumArray(array));
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken Parallel::" + (endTime-starTime));
		long sum =0;
		starTime = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		System.out.println(sum);
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken " + (endTime-starTime));
	}

}
class Sum extends RecursiveTask<Long> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final int SEQUENTIAL_THRESHOLD = 50000;

    int low;
    int high;
    int[] array;

    Sum(int[] arr, int lo, int hi) {
        array = arr;
        low   = lo;
        high  = hi;
    }

    @Override
    protected Long compute() {
        if(high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for(int i=low; i < high; ++i) 
                sum += array[i];
            return sum;
         } else {
            int mid = low + (high - low) / 2;
            Sum left  = new Sum(array, low, mid);
            Sum right = new Sum(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns  = left.join();
            return leftAns + rightAns;
         }
     }

     static long sumArray(int[] array) {
         return ForkJoinPool.commonPool().invoke(new Sum(array,0,array.length));
     }
}