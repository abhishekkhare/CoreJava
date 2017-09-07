package com.edu.abhi.dessignpatterns.observer.practiceagain;

import java.util.Observable;
import java.util.Observer;

public class Observer2 implements Observer {
	Observable o;
	Observer2(Observable o){
		this.o=o;
	}
	
	@Override
	public void update(Observable o, Object date) {
		System.out.println("Updated at :" + date);

	}

}
