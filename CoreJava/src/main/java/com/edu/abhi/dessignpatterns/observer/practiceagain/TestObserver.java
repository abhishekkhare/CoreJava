package com.edu.abhi.dessignpatterns.observer.practiceagain;

public class TestObserver {

	public static void main(String[] args) throws InterruptedException {
		Subject s = new Subject();
		Observer1 o1 = new Observer1(s);
		Observer2 o2 = new Observer2(s);
		Observer3 o3 = new Observer3(s);
		s.addObserver(o1);
		s.addObserver(o2);
		s.addObserver(o3);
		s.makeChange();
		Thread.sleep(3000);
		s.makeChange();
		Thread.sleep(3000);
		s.makeChange();
		Thread.sleep(3000);

	}

}
