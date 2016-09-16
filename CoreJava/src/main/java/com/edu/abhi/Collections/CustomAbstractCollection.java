package com.edu.abhi.Collections;

import java.util.Arrays;


import com.edu.abhi.CustomIterator;

/**
 * @author abhishekkhare
 * 
 *         This class provides a skeletal implementation of the Collection
 *         interface, to minimize the effort required to implement this
 *         interface.
 * 
 *         To implement an unmodifiable collection, the programmer needs only to
 *         extend this class and provide implementations for the iterator and
 *         size methods. (The iterator returned by the iterator method must
 *         implement hasNext and next.)
 * 
 *         To implement a modifiable collection, the programmer must
 *         additionally override this class's add method (which otherwise throws
 *         an UnsupportedOperationException), and the iterator returned by the
 *         iterator method must additionally implement its remove method.
 * @param <E>
 */
public  abstract class CustomAbstractCollection<E> implements
		CustomCollection<E> {

	protected CustomAbstractCollection() {

	}

	public abstract CustomIterator<E> iterator();

	public abstract int size();

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		CustomIterator<E> e = iterator();
		if (o == null) {
			while (e.hasNext())
				if (e.next() == null)
					return true;
		} else {
			while (e.hasNext())
				if (o.equals(e.next()))
					return true;
		}
		return false;
	}

	/**
	 * This implementation returns an array containing all the elements returned
	 * by this collection's iterator, in the same order, stored in consecutive
	 * elements of the array, starting with index 0. The length of the returned
	 * array is equal to the number of elements returned by the iterator, even
	 * if the size of this collection changes during iteration, as might happen
	 * if the collection permits concurrent modification during iteration. The
	 * size method is called only as an optimization hint; the correct result is
	 * returned even if the iterator returns a different number of elements.
	 */
	public Object[] toArray() {

		// Estimate size of array; be prepared to see more or fewer elements
		Object[] r = new Object[size()];
		CustomIterator<E> it = iterator();
		for (int i = 0; i < r.length; i++) {
			if (!it.hasNext()) // fewer elements than expected
				return Arrays.copyOf(r, i);
			r[i] = it.next();
		}
		return it.hasNext() ? finishToArray(r, it) : r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		// Estimate size of array; be prepared to see more or fewer elements
		int size = size();
		T[] r = a.length >= size ? a : (T[]) java.lang.reflect.Array
				.newInstance(a.getClass().getComponentType(), size);
		CustomIterator<E> it = iterator();

		for (int i = 0; i < r.length; i++) {
			if (!it.hasNext()) { // fewer elements than expected
				if (a != r)
					return Arrays.copyOf(r, i);
				r[i] = null; // null-terminate
				return r;
			}
			r[i] = (T) it.next();
		}
		return it.hasNext() ? finishToArray(r, it) : r;
	}

	/**
	 * Reallocates the array being used within toArray when the iterator
	 * returned more elements than expected, and finishes filling it from the
	 * iterator.
	 * 
	 * @param r
	 *            the array, replete with previously stored elements
	 * @param it
	 *            the in-progress iterator over this collection
	 * @return array containing the elements in the given array, plus any
	 *         further elements returned by the iterator, trimmed to size
	 */
	@SuppressWarnings("unchecked")
	private static <T> T[] finishToArray(T[] r, CustomIterator<?> it) {
		int i = r.length;
		while (it.hasNext()) {
			int cap = r.length;
			if (i == cap) {
				int newCap = ((cap / 2) + 1) * 3;
				if (newCap <= cap) { // integer overflow
					if (cap == Integer.MAX_VALUE)
						throw new OutOfMemoryError(
								"Required array size too large");
					newCap = Integer.MAX_VALUE;
				}
				r = Arrays.copyOf(r, newCap);
			}
			r[i++] = (T) it.next();
		}
		// trim if overallocated
		return (i == r.length) ? r : Arrays.copyOf(r, i);
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This implementation iterates over the collection looking for the
	 * specified element. If it finds the element, it removes the element from
	 * the collection using the iterator's remove method. Note that this
	 * implementation throws an UnsupportedOperationException if the iterator
	 * returned by this collection's iterator method does not implement the
	 * remove method and this collection contains the specified object.
	 */
	public boolean remove(Object o) {
		CustomIterator<E> e = iterator();
		if (o == null) {
			while (e.hasNext()) {
				if (e.next() == null) {
					e.remove();
					return true;
				}
			}
		} else {
			while (e.hasNext()) {
				if (o.equals(e.next())) {
					e.remove();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(CustomCollection<?> c) {
		CustomIterator<?> e = c.iterator();
		while (e.hasNext())
			if (!contains(e.next()))
				return false;
		return true;
	}

	@Override
	public boolean addAll(CustomCollection<? extends E> c) {
		boolean modified = false;
		CustomIterator<? extends E> e = c.iterator();
		while (e.hasNext()) {
			if (add(e.next()))
				modified = true;
		}
		return modified;
	}

	@Override
	public boolean removeAll(CustomCollection<?> c) {
		boolean modified = false;
		CustomIterator<?> e = iterator();
		while (e.hasNext()) {
			if (c.contains(e.next())) {
				e.remove();
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * This implementation iterates over this collection, checking each element
	 * returned by the iterator in turn to see if it's contained in the
	 * specified collection. If it's not so contained, it's removed from this
	 * collection with the iterator's remove method. Note that this
	 * implementation will throw an UnsupportedOperationException if the
	 * iterator returned by the iterator method does not implement the remove
	 * method and this collection contains one or more elements not present in
	 * the specified collection.
	 */
	public boolean retainAll(CustomCollection<?> c) {
		boolean modified = false;
		CustomIterator<E> e = iterator();
		while (e.hasNext()) {
			if (!c.contains(e.next())) {
				e.remove();
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		CustomIterator<E> e = iterator();
		while (e.hasNext()) {
			e.next();
			e.remove();
		}

	}
	
	@Override
	public String toString() {
		CustomIterator<E> i = iterator();
        if (! i.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = i.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! i.hasNext())
                return sb.append(']').toString();
            sb.append(", ");
        }
    }

}
