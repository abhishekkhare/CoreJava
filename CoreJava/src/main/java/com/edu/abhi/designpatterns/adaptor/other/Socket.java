package com.edu.abhi.designpatterns.adaptor.other;

public class Socket {

	public Volt getVolt() {
		return new Volt(120);
	}
}
