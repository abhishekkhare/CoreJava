package com.edu.abhi.designpatterns.observer.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SubjectImpl implements Subject {

	private String name;
	Set<Observer> observerSet = new HashSet<Observer>();
	
	@Override
	public void register(Observer o) {
		observerSet.add(o);

	}

	@Override
	public void unRegister(Observer o) {
		observerSet.remove(o);

	}

	@Override
	public void notifyObserver() {
		for (Iterator <Observer>iterator = observerSet.iterator(); iterator.hasNext();) {
			Observer o  =  iterator.next();
			o.update(this.name);			
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObserver();
	}

}
