package com.edu.abhi.designpatterns.singleton.practice;

public class ThreadSafeSingleton {

	private ThreadSafeSingleton instance;
	
	private ThreadSafeSingleton(){
		
	}
	
	public ThreadSafeSingleton getInstance(){
		if(instance==null){
			synchronized (ThreadSafeSingleton.class) {
				if(instance==null){
					instance= new ThreadSafeSingleton();
				}
			}
		}
		
		return instance;
	}
}
