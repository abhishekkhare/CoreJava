package com.edu.abhi.dessignpatterns.singleton.practice;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton instance;
	private ThreadSafeSingleton(){
		
	}
	public static ThreadSafeSingleton getInstance(){
		if(instance==null){
			synchronized (ThreadSafeSingleton.class) {
				if(instance==null){
					instance=new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

}
