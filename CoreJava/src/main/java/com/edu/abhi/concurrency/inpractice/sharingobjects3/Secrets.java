package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import java.util.HashSet;
import java.util.Set;

public class Secrets {
	public static Set<Secret> knownSecrets;

	public void initialize() {
		knownSecrets = new HashSet<Secret>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Secret {
		String name;
		Secret(String name){
			this.name=name;
		}
	}
}
