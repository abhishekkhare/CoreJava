package com.edu.abhi.designpatterns.observer.practiceagain;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {
	Observable o;
	Observer1(Observable o){
		this.o=o;
	}
	
	@Override
	public void update(Observable o, Object date) {
		System.out.println("Updated at :" + date);

	}

}
