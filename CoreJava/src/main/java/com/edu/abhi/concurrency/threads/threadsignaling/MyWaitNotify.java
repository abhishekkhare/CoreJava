package com.edu.abhi.concurrency.threads.threadsignaling;

public class MyWaitNotify {

	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait(){
	    synchronized(myMonitorObject){
	      try{
	        myMonitorObject.wait();
	      } catch(InterruptedException e){
	    	  e.printStackTrace();
	      }
	    }
	  }

	public void doNotify() {
		synchronized (myMonitorObject) {
			myMonitorObject.notify();
		}
	}
}