package com.edu.abhi.concurrency.inpractice.composingobjects4;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class MutablePoint {
	public int x, y;

	public MutablePoint() {
		x = 0;
		y = 0;
	}

	public MutablePoint(MutablePoint p) {
		this.x = p.x;
		this.y = p.y;
	}
}