package com.edu.abhi.java8.multipleinheritance;

public interface Crawlable {
	default void crawl() {
		System.out.println("I am crawling !!");
	}

	default void run() {
		System.out.println("I am running, daddy !!");
	}
	
	void test();
}
