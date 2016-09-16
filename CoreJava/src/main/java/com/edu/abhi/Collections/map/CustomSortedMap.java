package com.edu.abhi.Collections.map;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Set;

import com.edu.abhi.CustomComparator;
import com.edu.abhi.Collections.CustomCollection;
import com.edu.abhi.Collections.set.CustomSet;

/**
 * 
 * A Map that further provides a total ordering on its keys. The map is ordered
 * according to the natural ordering of its keys, or by a Comparator typically
 * provided at sorted map creation time. This order is reflected when iterating
 * over the sorted map's collection views (returned by the entrySet, keySet and
 * values methods). Several additional operations are provided to take advantage
 * of the ordering. (This interface is the map analogue of SortedSet.)
 * 
 * All keys inserted into a sorted map must implement the Comparable interface
 * (or be accepted by the specified comparator). Furthermore, all such keys must
 * be mutually comparable: k1.compareTo(k2) (or comparator.compare(k1, k2)) must
 * not throw a ClassCastException for any keys k1 and k2 in the sorted map.
 * Attempts to violate this restriction will cause the offending method or
 * constructor invocation to throw a ClassCastException.
 * 
 * Note that the ordering maintained by a sorted map (whether or not an explicit
 * comparator is provided) must be consistent with equals if the sorted map is
 * to correctly implement the Map interface. (See the Comparable interface or
 * Comparator interface for a precise definition of consistent with equals.)
 * This is so because the Map interface is defined in terms of the equals
 * operation, but a sorted map performs all key comparisons using its compareTo
 * (or compare) method, so two keys that are deemed equal by this method are,
 * from the standpoint of the sorted map, equal.
 * 
 * The behavior of a tree map is well-defined even if its ordering is
 * inconsistent with equals; it just fails to obey the general contract of the
 * Map interface. All general-purpose sorted map implementation classes should
 * provide four "standard" constructors:
 * 
 * 1) A void (no arguments) constructor, which creates an empty sorted map
 * sorted according to the natural ordering of its keys.
 * 
 * 2) A constructor with a single argument of type Comparator, which creates an
 * empty sorted map sorted according to the specified comparator.
 * 
 * 3) A constructor with a single argument of type Map, which creates a new map
 * with the same key-value mappings as its argument, sorted according to the
 * keys' natural ordering.
 * 
 * 4) A constructor with a single argument of type SortedMap, which creates a
 * new sorted map with the same key-value mappings and the same ordering as the
 * input sorted map. There is no way to enforce this recommendation, as
 * interfaces cannot contain constructors.
 * 
 * Note: several methods return submaps with restricted key ranges. Such ranges
 * are half-open, that is, they include their low endpoint but not their high
 * endpoint (where applicable). If you need a closed range (which includes both
 * endpoints), and the key type allows for calculation of the successor of a
 * given key, merely request the subrange from lowEndpoint to
 * successor(highEndpoint). For example, suppose that m is a map whose keys are
 * strings. The following idiom obtains a view containing all of the key-value
 * mappings in m whose keys are between low and high, inclusive:
 * SortedMap<String, V> sub = m.subMap(low, high+"\0"); A similar technique can
 * be used to generate an open range (which contains neither endpoint). The
 * following idiom obtains a view containing all of the key-value mappings in m
 * whose keys are between low and high, exclusive: SortedMap<String, V> sub =
 * m.subMap(low+"\0", high);
 * 
 * @author abhishekkhare
 * 
 * @param <K>
 * @param <V>
 */
public interface CustomSortedMap<K, V> extends CustomMap<K, V> {

	/**
     * Returns the comparator used to order the keys in this map, or
     * <tt>null</tt> if this map uses the {@linkplain Comparable
     * natural ordering} of its keys.
     *
     * @return the comparator used to order the keys in this map,
     *         or <tt>null</tt> if this map uses the natural ordering
     *         of its keys
     */
    CustomComparator<? super K> comparator();

    /**
     * Returns a view of the portion of this map whose keys range from
     * <tt>fromKey</tt>, inclusive, to <tt>toKey</tt>, exclusive.  (If
     * <tt>fromKey</tt> and <tt>toKey</tt> are equal, the returned map
     * is empty.)  The returned map is backed by this map, so changes
     * in the returned map are reflected in this map, and vice-versa.
     * The returned map supports all optional map operations that this
     * map supports.
     *
     * <p>The returned map will throw an <tt>IllegalArgumentException</tt>
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey low endpoint (inclusive) of the keys in the returned map
     * @param toKey high endpoint (exclusive) of the keys in the returned map
     * @return a view of the portion of this map whose keys range from
     *         <tt>fromKey</tt>, inclusive, to <tt>toKey</tt>, exclusive
     * @throws ClassCastException if <tt>fromKey</tt> and <tt>toKey</tt>
     *         cannot be compared to one another using this map's comparator
     *         (or, if the map has no comparator, using natural ordering).
     *         Implementations may, but are not required to, throw this
     *         exception if <tt>fromKey</tt> or <tt>toKey</tt>
     *         cannot be compared to keys currently in the map.
     * @throws NullPointerException if <tt>fromKey</tt> or <tt>toKey</tt>
     *         is null and this map does not permit null keys
     * @throws IllegalArgumentException if <tt>fromKey</tt> is greater than
     *         <tt>toKey</tt>; or if this map itself has a restricted
     *         range, and <tt>fromKey</tt> or <tt>toKey</tt> lies
     *         outside the bounds of the range
     */
    CustomSortedMap<K,V> subMap(K fromKey, K toKey);

    /**
     * Returns a view of the portion of this map whose keys are
     * strictly less than <tt>toKey</tt>.  The returned map is backed
     * by this map, so changes in the returned map are reflected in
     * this map, and vice-versa.  The returned map supports all
     * optional map operations that this map supports.
     *
     * <p>The returned map will throw an <tt>IllegalArgumentException</tt>
     * on an attempt to insert a key outside its range.
     *
     * @param toKey high endpoint (exclusive) of the keys in the returned map
     * @return a view of the portion of this map whose keys are strictly
     *         less than <tt>toKey</tt>
     * @throws ClassCastException if <tt>toKey</tt> is not compatible
     *         with this map's comparator (or, if the map has no comparator,
     *         if <tt>toKey</tt> does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if <tt>toKey</tt> cannot be compared to keys
     *         currently in the map.
     * @throws NullPointerException if <tt>toKey</tt> is null and
     *         this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *         restricted range, and <tt>toKey</tt> lies outside the
     *         bounds of the range
     */
    CustomSortedMap<K,V> headMap(K toKey);

    /**
     * Returns a view of the portion of this map whose keys are
     * greater than or equal to <tt>fromKey</tt>.  The returned map is
     * backed by this map, so changes in the returned map are
     * reflected in this map, and vice-versa.  The returned map
     * supports all optional map operations that this map supports.
     *
     * <p>The returned map will throw an <tt>IllegalArgumentException</tt>
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey low endpoint (inclusive) of the keys in the returned map
     * @return a view of the portion of this map whose keys are greater
     *         than or equal to <tt>fromKey</tt>
     * @throws ClassCastException if <tt>fromKey</tt> is not compatible
     *         with this map's comparator (or, if the map has no comparator,
     *         if <tt>fromKey</tt> does not implement {@link Comparable}).
     *         Implementations may, but are not required to, throw this
     *         exception if <tt>fromKey</tt> cannot be compared to keys
     *         currently in the map.
     * @throws NullPointerException if <tt>fromKey</tt> is null and
     *         this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *         restricted range, and <tt>fromKey</tt> lies outside the
     *         bounds of the range
     */
    CustomSortedMap<K,V> tailMap(K fromKey);

    /**
     * Returns the first (lowest) key currently in this map.
     *
     * @return the first (lowest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    K firstKey();

    /**
     * Returns the last (highest) key currently in this map.
     *
     * @return the last (highest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    K lastKey();

    /**
     * Returns a {@link Set} view of the keys contained in this map.
     * The set's iterator returns the keys in ascending order.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation), the results of
     * the iteration are undefined.  The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
     * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
     * operations.
     *
     * @return a set view of the keys contained in this map, sorted in
     *         ascending order
     */
    CustomSet<K> keySet();

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     * The collection's iterator returns the values in ascending order
     * of the corresponding keys.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a collection view of the values contained in this map,
     *         sorted in ascending key order
     */
    CustomCollection<V> values();

    /**
     * Returns a {@link Set} view of the mappings contained in this map.
     * The set's iterator returns the entries in ascending key order.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation, or through the
     * <tt>setValue</tt> operation on a map entry returned by the
     * iterator) the results of the iteration are undefined.  The set
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
     * <tt>clear</tt> operations.  It does not support the
     * <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a set view of the mappings contained in this map,
     *         sorted in ascending key order
     */
    CustomSet<CustomMap.CustomEntry<K, V>> entrySet();
}
