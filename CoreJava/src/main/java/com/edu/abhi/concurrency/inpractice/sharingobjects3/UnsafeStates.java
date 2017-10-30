package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import java.util.Arrays;

public class UnsafeStates {
	private String[] states = new String[] { "AK", "AL" };

	public String[] getStates() {
		return states;
	}

	public static void main(String[] args) {
		UnsafeStates states = new UnsafeStates();
		states.getStates()[0]="AF";
		String[] state = states.getStates();
		System.out.println(Arrays.toString(state));
	}
}
