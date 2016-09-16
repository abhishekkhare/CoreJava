package com.edu.abhi.Collections;

import java.util.Iterator;

/**
 * An iterator over a collection. It takes the place of Enumeration in the Java
 * Collections Framework. Iterators differ from enumerations as Iterators allow
 * the caller to remove elements from the underlying collection during the
 * iteration with well-defined semantics.
 */
public interface CustomIterator<E> extends Iterator<E> {
	/**
	 * Returns true if the iteration has more elements. (In other words, returns
	 * true if next() would return an element rather than throwing an
	 * exception.)
	 * 
	 * Returns: true if the iteration has more elements
	 */
	boolean hasNext();

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration
	 * @throws NoSuchElementException
	 *             if the iteration has no more elements
	 */
	E next();

	/**
	 * Removes from the underlying collection the last element returned by this
	 * iterator (optional operation). This method can be called only once per
	 * call to next(). The behavior of an iterator is unspecified if the
	 * underlying collection is modified while the iteration is in progress in
	 * any way other than by calling this method.
	 * 
	 * @throws UnsupportedOperationException
	 *             if the operation is not supported by this
	 *             iterator
	 * 
	 * @throws IllegalStateException
	 *             if the next method has not yet been called, or the
	 *             remove method has already been called after the last
	 *             call to the next method
	 */
	void remove();
}
