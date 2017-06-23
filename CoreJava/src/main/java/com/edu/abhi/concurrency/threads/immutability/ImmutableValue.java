package com.edu.abhi.concurrency.threads.immutability;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class ImmutableValue {
	private int value = 0;

	public ImmutableValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	/**
	 * Notice how the add() method returns a new ImmutableValue instance with
	 * the result of the add operation, rather than adding the value to itself.
	 * 
	 * @param valueToAdd
	 * @return
	 */
	public ImmutableValue add(int valueToAdd) {
		return new ImmutableValue(this.value + valueToAdd);
	}

}
