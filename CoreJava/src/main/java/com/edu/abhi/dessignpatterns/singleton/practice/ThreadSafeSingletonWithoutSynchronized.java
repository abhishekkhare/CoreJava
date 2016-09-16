package com.edu.abhi.dessignpatterns.singleton.practice;

public class ThreadSafeSingletonWithoutSynchronized {
	private ThreadSafeSingletonWithoutSynchronized() {

	}
	private static class HoldInstance {
		private static final ThreadSafeSingletonWithoutSynchronized instance = new ThreadSafeSingletonWithoutSynchronized();
	}
	public ThreadSafeSingletonWithoutSynchronized getInstace() {
		return HoldInstance.instance;
	}

}
