package com.edu.abhi.Collections.set;

import com.edu.abhi.CustomComparator;
import com.edu.abhi.CustomIterator;

/**
 * 
 * * A {@link NavigableSet} implementation based on a {@link TreeMap}. The
 * elements are ordered using their {@linkplain Comparable natural ordering}, or
 * by a {@link Comparator} provided at set creation time, depending on which
 * constructor is used.
 * 
 * <p>
 * This implementation provides guaranteed log(n) time cost for the basic
 * operations ({@code add}, {@code remove} and {@code contains}).
 * 
 * <p>
 * Note that the ordering maintained by a set (whether or not an explicit
 * comparator is provided) must be <i>consistent with equals</i> if it is to
 * correctly implement the {@code Set} interface. (See {@code Comparable} or
 * {@code Comparator} for a precise definition of <i>consistent with
 * equals</i>.) This is so because the {@code Set} interface is defined in terms
 * of the {@code equals} operation, but a {@code TreeSet} instance performs all
 * element comparisons using its {@code compareTo} (or {@code compare}) method,
 * so two elements that are deemed equal by this method are, from the standpoint
 * of the set, equal. The behavior of a set <i>is</i> well-defined even if its
 * ordering is inconsistent with equals; it just fails to obey the general
 * contract of the {@code Set} interface.
 * 
 * <p>
 * <strong>Note that this implementation is not synchronized.</strong> If
 * multiple threads access a tree set concurrently, and at least one of the
 * threads modifies the set, it <i>must</i> be synchronized externally. This is
 * typically accomplished by synchronizing on some object that naturally
 * encapsulates the set. If no such object exists, the set should be "wrapped"
 * using the {@link Collections#synchronizedSortedSet
 * Collections.synchronizedSortedSet} method. This is best done at creation
 * time, to prevent accidental unsynchronized access to the set:
 * 
 * <pre>
 *   SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...));
 * </pre>
 * 
 * <p>
 * The iterators returned by this class's {@code iterator} method are
 * <i>fail-fast</i>: if the set is modified at any time after the iterator is
 * created, in any way except through the iterator's own {@code remove} method,
 * the iterator will throw a {@link ConcurrentModificationException}. Thus, in
 * the face of concurrent modification, the iterator fails quickly and cleanly,
 * rather than risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 * 
 * <p>
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it
 * is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators throw
 * {@code ConcurrentModificationException} on a best-effort basis. Therefore, it
 * would be wrong to write a program that depended on this exception for its
 * correctness: <i>the fail-fast behavior of iterators should be used only to
 * detect bugs.</i>
 * 
 * 
 * @author abhishekkhare
 * 
 * @param <E>
 */

public class CustomTreeSet<E> extends CustomAbstractSet<E> implements
		CustomNavigableSet<E>, Cloneable, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660808681561128694L;

	@Override
	public CustomComparator<? super E> comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E lower(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E floor(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E ceiling(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E higher(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableSet<E> descendingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomIterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableSet<E> subSet(E fromElement, boolean fromInclusive,
			E toElement, boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableSet<E> headSet(E toElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSortedSet<E> subSet(E fromElement, E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSortedSet<E> headSet(E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSortedSet<E> tailSet(E fromElement) {
		// TODO Auto-generated method stub
		return null;
	}

}
