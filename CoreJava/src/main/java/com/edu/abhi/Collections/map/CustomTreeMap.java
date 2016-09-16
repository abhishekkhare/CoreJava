package com.edu.abhi.Collections.map;

import com.edu.abhi.CustomComparator;
import com.edu.abhi.Collections.set.CustomNavigableSet;
import com.edu.abhi.Collections.set.CustomSet;

/**
 * 
 * A Red-Black tree based NavigableMap implementation. The map is sorted
 * according to the natural ordering of its keys, or by a Comparator provided at
 * map creation time, depending on which constructor is used. This
 * implementation provides guaranteed log(n) time cost for the containsKey, get,
 * put and remove operations. Algorithms are adaptations of those in Cormen,
 * Leiserson, and Rivest's Introduction to Algorithms. Note that the ordering
 * maintained by a sorted map (whether or not an explicit comparator is
 * provided) must be consistent with equals if this sorted map is to correctly
 * implement the Map interface. (See Comparable or Comparator for a precise
 * definition of consistent with equals.) This is so because the Map interface
 * is defined in terms of the equals operation, but a map performs all key
 * comparisons using its compareTo (or compare) method, so two keys that are
 * deemed equal by this method are, from the standpoint of the sorted map,
 * equal. The behavior of a sorted map is well-defined even if its ordering is
 * inconsistent with equals; it just fails to obey the general contract of the
 * Map interface. Note that this implementation is not synchronized. If multiple
 * threads access a map concurrently, and at least one of the threads modifies
 * the map structurally, it must be synchronized externally. (A structural
 * modification is any operation that adds or deletes one or more mappings;
 * merely changing the value associated with an existing key is not a structural
 * modification.) This is typically accomplished by synchronizing on some object
 * that naturally encapsulates the map. If no such object exists, the map should
 * be "wrapped" using the Collections.synchronizedSortedMap method. This is best
 * done at creation time, to prevent accidental unsynchronized access to the
 * map: SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...)); The
 * iterators returned by the iterator method of the collections returned by all
 * of this class's "collection view methods" are fail-fast: if the map is
 * structurally modified at any time after the iterator is created, in any way
 * except through the iterator's own remove method, the iterator will throw a
 * ConcurrentModificationException. Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the future.
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it
 * is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators throw
 * ConcurrentModificationException on a best-effort basis. Therefore, it would
 * be wrong to write a program that depended on this exception for its
 * correctness: the fail-fast behavior of iterators should be used only to
 * detect bugs. All Map.Entry pairs returned by methods in this class and its
 * views represent snapshots of mappings at the time they were produced. They do
 * not support the Entry.setValue method. (Note however that it is possible to
 * change mappings in the associated map using put.) This class is a member of
 * the Java Collections Framework.
 * 
 * 
 * @author abhishekkhare
 * 
 * @param <K>
 * @param <V>
 */


public  class CustomTreeMap<K, V> extends CustomAbstractMap<K, V> implements CustomNavigableMap<K, V>, Cloneable, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660808681561128694L;
	
	@Override
	public CustomComparator<? super K> comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K firstKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K lastKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> lowerEntry(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K lowerKey(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> floorEntry(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K floorKey(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> ceilingEntry(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K ceilingKey(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> higherEntry(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K higherKey(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> lastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> pollFirstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMap.CustomEntry<K, V> pollLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableMap<K, V> descendingMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableSet<K> navigableKeySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableSet<K> descendingKeySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableMap<K, V> subMap(K fromKey, boolean fromInclusive,
			K toKey, boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableMap<K, V> headMap(K toKey, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomNavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSortedMap<K, V> subMap(K fromKey, K toKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSortedMap<K, V> headMap(K toKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSortedMap<K, V> tailMap(K fromKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomSet<CustomMap.CustomEntry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
