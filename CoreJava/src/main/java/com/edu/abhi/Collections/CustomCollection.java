package com.edu.abhi.Collections;

import com.edu.abhi.CustomIterable;
import com.edu.abhi.CustomIterator;

/**
 * @author abhishekkhare
 * 
 *         The root interface in the collection hierarchy. A collection
 *         represents a group of objects, known as its elements. Some
 *         collections allow duplicate elements and others do not Some are
 *         ordered and others unordered. The JDK does not provide any direct
 *         implementations of this interface: it provides implementations of
 *         more specific subinterfaces like Set and List.
 * 
 *         All general-purpose Collection implementation classes (which
 *         typically implement Collection indirectly through one of its
 *         subinterfaces) should provide two "standard" constructors: a void (no
 *         arguments) constructor, which creates an empty collection, and a
 *         constructor with a single argument of type Collection, which creates
 *         a new collection with the same elements as its argument. In effect,
 *         the latter constructor allows the user to copy any collection,
 *         producing an equivalent collection of the desired implementation
 *         type. There is no way to enforce this convention (as interfaces
 *         cannot contain constructors) but all of the general-purpose
 *         Collection implementations in the Java platform libraries comply.
 * 
 *         The "destructive" methods contained in this interface, that is, the
 *         methods that modify the collection on which they operate, are
 *         specified to throw UnsupportedOperationException if this collection
 *         does not support the operation. If this is the case, these methods
 *         may, but are not required to, throw an UnsupportedOperationException
 *         if the invocation would have no effect on the collection.
 * 
 *         Some collection implementations have restrictions on the elements
 *         that they may contain. For example, some implementations prohibit
 *         null elements, and some have restrictions on the types of their
 *         elements. Attempting to add an ineligible element throws an unchecked
 *         exception, typically NullPointerException or ClassCastException.
 *         Attempting to query the presence of an ineligible element may throw
 *         an exception, or it may simply return false; some implementations
 *         will exhibit the former behavior and some will exhibit the latter.
 *         More generally, attempting an operation on an ineligible element
 *         whose completion would not result in the insertion of an ineligible
 *         element into the collection may throw an exception or it may succeed,
 *         at the option of the implementation. Such exceptions are marked as
 *         "optional" in the specification for this interface.
 * 
 *         Many methods in Collections Framework interfaces are defined in terms
 *         of the equals method. For example, the specification for the
 *         contains(Object o) method says:
 *         "returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e))."
 *         This specification should not be construed to imply that invoking
 *         Collection.contains with a non-null argument o will cause o.equals(e)
 *         to be invoked for any element e. Implementations are free to
 *         implement optimizations whereby the equals invocation is avoided, for
 *         example, by first comparing the hash codes of the two elements.
 * 
 * @param <E>
 */
public interface CustomCollection<E> extends CustomIterable<E> {

	/*
	 * Returns the number of elements in this collection. If this collection
	 * contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 */
	public int size();

	public boolean isEmpty();

	public boolean contains(Object o);

	/**
	 * Returns an iterator over the elements in this collection. There are no
	 * guarantees concerning the order in which the elements are returned
	 * (unless this collection is an instance of some class that provides a
	 * guarantee).
	 */
	
	public CustomIterator<E> iterator();

	
	public Object[] toArray();

	
	public <T> T[] toArray(T[] a);

	
	public boolean add(E e);

	
	public boolean remove(Object o);

	
	public boolean containsAll(CustomCollection<?> c);

	
	public boolean addAll(CustomCollection<? extends E> c);

	
	public boolean removeAll(CustomCollection<?> c);

	
	public boolean retainAll(CustomCollection<?> c);

	
	public void clear();

}
