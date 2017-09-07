package com.edu.abhi.designpatterns.singleton;

public class SingletonWithoutSynchronized {
	private SingletonWithoutSynchronized() {
	}

	private static class HoldInstance {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return HoldInstance.INSTANCE;
	}
}
