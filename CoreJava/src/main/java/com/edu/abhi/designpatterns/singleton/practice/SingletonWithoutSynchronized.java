package com.edu.abhi.designpatterns.singleton.practice;

public class SingletonWithoutSynchronized {
	
	private SingletonWithoutSynchronized(){
		
	}

	private static class HoldInstance{
		private static final SingletonWithoutSynchronized intance = new SingletonWithoutSynchronized();
	}
	
	public SingletonWithoutSynchronized getInstance(){
		return SingletonWithoutSynchronized.HoldInstance.intance;
	}
}
