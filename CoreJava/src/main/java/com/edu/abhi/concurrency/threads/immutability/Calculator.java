package com.edu.abhi.concurrency.threads.immutability;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

/**
 * The Calculator class holds a reference to an ImmutableValue instance. Notice
 * how it is possible to change that reference through both the setValue() and
 * add() methods. Therefore, even if the Calculator class uses an immutable
 * object internally, it is not itself immutable, and therefore not thread safe.
 * In other words: The ImmutableValue class is thread safe, but the use of it is
 * not. This is something to keep in mind when trying to achieve thread safety
 * through immutability.
 * 
 * To make the Calculator class thread safe you could have declared the
 * getValue(), setValue(), and add() methods synchronized. That would have done
 * the trick.
 * 
 * @author abhishekkhare
 *
 */
@NotThreadSafe
public class Calculator {
	private ImmutableValue currentValue = null;

	public ImmutableValue getValue() {
		return currentValue;
	}

	public void setValue(ImmutableValue newValue) {
		this.currentValue = newValue;
	}

	public void add(int newValue) {
		this.currentValue = this.currentValue.add(newValue);
	}
}