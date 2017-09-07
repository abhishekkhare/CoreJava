package com.edu.abhi.designpatterns.observer.practice;

public class Test {

	public static void main(String[] args) {
		SubjectImpl s = new SubjectImpl();
		ObserverImpl o1 = new ObserverImpl(s, "Hello", "1");
		ObserverImpl o2 = new ObserverImpl(s, "Hello", "2");
		ObserverImpl o3 = new ObserverImpl(s, "Hello", "3");
		ObserverImpl o4 = new ObserverImpl(s, "Hello", "4");
		ObserverImpl o5 = new ObserverImpl(s, "Hello", "5");
		
		s.register(o1);
		s.register(o2);
		s.register(o3);
		s.register(o4);
		s.register(o5);
		
		s.setName("Hi");
		s.unRegister(o3);
		s.unRegister(o4);
		
		s.setName("Namaste");

		
		
	}

}
