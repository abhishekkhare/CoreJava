package com.edu.abhi.concurrency.inpractice.composingobjects4;

import com.edu.abhi.concurrency.inpractice.annotations.GuardedBy;
import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author abhishekkhare
 *
 *         The state of PersonSet is managed by a HashSet, which is not
 *         thread-safe. But because mySet is private and not allowed to escape,
 *         the HashSet is confined to the PersonSet. The only code paths that
 *         can access mySet are addPerson and containsPerson, and each of these
 *         acquires the lock on the PersonSet. All its state is guarded by its
 *         intrinsic lock, making PersonSet thread-safe.
 */
@ThreadSafe
public class PersonSet {
	@GuardedBy("this")
	private final Set<Person> mySet = new HashSet<Person>();

	public synchronized void addPerson(Person p) {
		mySet.add(p);
	}

	public synchronized boolean containsPerson(Person p) {
		return mySet.contains(p);
	}

	interface Person {
	}
}