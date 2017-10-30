package com.edu.abhi.concurrency.inpractice.sharingobjects3;


public class StuffIntoPublic {
	public Holder holder;

    public void initialize(int n) {
        holder = new Holder(n);
    }
    
    public static void main(String [] args){
    	StuffIntoPublic object = new StuffIntoPublic();
    	
    	new Thread(new Runnable() {
			@Override
			public void run() {
				object.initialize(42);
				object.initialize(44);
				
			}
		}).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
    	
    	new Thread(new Runnable() {
			@Override
			public void run() {
				object.holder.assertSanity();
				
			}
		}).start();
    }
}
