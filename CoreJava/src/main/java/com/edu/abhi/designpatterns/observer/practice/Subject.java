package com.edu.abhi.designpatterns.observer.practice;

public interface Subject {

	void register(Observer o);
	void unRegister(Observer o);
	void notifyObserver();
}
