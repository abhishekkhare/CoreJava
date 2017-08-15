package com.edu.abhi.dessignpatterns.singleton.practice;

import java.util.Date;

public enum SingletonAsEnum {
	INSTANCE;
	private final Date date;
	
	private SingletonAsEnum(){
		System.out.println("Here");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.date = new Date();
	}
	public Date getDate() {
		return date;
	}

	public static void main(String [] args){
		SingletonAsEnum  a = SingletonAsEnum.INSTANCE;
		SingletonAsEnum  b = SingletonAsEnum.INSTANCE;
		if(a==b && a.getDate()==b.getDate())
			System.out.println("TRUE");
		
		System.out.println("DONE");
	}
}
