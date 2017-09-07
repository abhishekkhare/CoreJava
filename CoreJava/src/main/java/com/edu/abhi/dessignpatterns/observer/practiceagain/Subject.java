package com.edu.abhi.dessignpatterns.observer.practiceagain;

import java.util.Date;
import java.util.Observable;

public class Subject extends Observable{
	
	void makeChange(){
		setChanged();
		Date d = new Date(System.currentTimeMillis());
		notifyObservers(d);
	}

}
