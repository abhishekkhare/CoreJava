package com.edu.abhi.designpatterns.observer.practice;

public class ObserverImpl implements Observer {
	private String ss;
	private final String nameOfObserver;
	
	public ObserverImpl(Subject s, String ss,String nameOfObserver){
		this.ss = ss;
		this.nameOfObserver =nameOfObserver;
		s.register(this);
	}
	
	@Override
	public void update(String ss) {
		this.ss = ss;
		System.out.println(nameOfObserver +" --"+ ss);

	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

}
