package com.edu.abhi.concurrency;

import java.io.IOException;

public class TerminatingThreadUsingInterrupt {

	public static void main(String[] args) throws IOException {
		MyRunnable1 obj = new MyRunnable1();
        Thread t = new Thread(obj, "Thread-1");
        t.start();

        System.out.println(Thread.currentThread().getName()
                     + " thread waiting for user to press enter");
        System.in.read();
        t.interrupt();

        System.out.println(Thread.currentThread().getName() + " thread ENDED");

	}

}

class MyRunnable1 implements Runnable {
	 
    public void run() {
           int i = 0;
 
           try {
                  while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(1000);
                        System.out.println(i++ + " Please press enter key to stop "
                                      + Thread.currentThread().getName());
                  }
           } catch (InterruptedException e) {
                  System.out.println(Thread.currentThread().getName() + " ENDED");
           }
    }
}