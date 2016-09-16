package com.edu.abhi.threads;

/**
 * Sample Java class to illustrate How to join two threads in Java.
 * join() method allows you to serialize processing of two threads.
 */

public class Join {
  
    public static void main(String args[]) throws InterruptedException{
      
        System.out.println(Thread.currentThread().getName() + " is Started");
        Thread T2 = new Thread(){
            public void run(){
            	Thread.currentThread().setName("T2");
            	System.out.println(Thread.currentThread().getName() + " is Started");
            	Thread T1 = new Thread(){
                    public void run(){
                    	Thread.currentThread().setName("T1");
                        try {
                            System.out.println(Thread.currentThread().getName() + " is Started");
                            Thread.sleep(5000);
                            System.out.println(Thread.currentThread().getName() + " is Completed");
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                T1.start();
                try {
					T1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                    
                    System.out.println(Thread.currentThread().getName() + " is Completed");
            }
        };
      
        T2.start();
        T2.join();
      
        System.out.println(Thread.currentThread().getName() + " is Completed");
    }
  
}
