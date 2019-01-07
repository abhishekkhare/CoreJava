package com.edu.abhi.concurrency.threads.threadsignaling;

class Chat {
	boolean flag = false;

	public synchronized void question(String msg) {
		if (flag) {
			try {
				System.out.println("Question Waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void answer(String msg) {
		if (!flag) {

			try {
				System.out.println("Answer Waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = false;
		notify();
	}
}

class Question implements Runnable {
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	public Question(Chat m1) {
		this.m = m1;
		new Thread(this, "Question").start();
	}

	public void run() {

		for (int i = 0; i < s1.length; i++) {
			m.question(s1[i]);
		}
	}
}

class Answer implements Runnable {
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public Answer(Chat m2) {
		this.m = m2;
		new Thread(this, "Answer").start();
	}

	public void run() {

		for (int i = 0; i < s2.length; i++) {
			m.answer(s2[i]);
		}
	}
}

public class InterThreadCommunicationExample2 {

	public static void main(String args[]) {

		Chat m = new Chat();
		new Question(m);
		new Answer(m);

	}
}