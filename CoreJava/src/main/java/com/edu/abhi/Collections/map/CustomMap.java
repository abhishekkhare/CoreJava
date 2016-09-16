package com.edu.abhi.Collections.map;

import com.edu.abhi.Collections.CustomCollection;
import com.edu.abhi.Collections.set.CustomSet;

/**
 * 
 * 
 * An object that maps keys to values. A map cannot contain duplicate keys; each
 * key can map to at most one value.
 * 
 * The Map interface provides three collection views, which allow a map's
 * contents to be viewed as a set of keys, collection of values, or set of
 * key-value mappings. The order of a map is defined as the order in which the
 * iterators on the map's collection views return their elements. Some map
 * implementations, like the TreeMap class, make specific guarantees as to their
 * order; others, like the HashMap class, do not.
 * 
 * Note: great care must be exercised if mutable objects are used as map keys.
 * The behavior of a map is not specified if the value of an object is changed
 * in a manner that affects equals comparisons while the object is a key in the
 * map.
 * 
 * A special case of this prohibition is that it is not permissible for a map to
 * contain itself as a key. While it is permissible for a map to contain itself
 * as a value, extreme caution is advised: the equals and hashCode methods are
 * no longer well defined on such a map.
 * 
 * All general-purpose map implementation classes should provide two "standard"
 * constructors: a void (no arguments) constructor which creates an empty map,
 * and a constructor with a single argument of type Map, which creates a new map
 * with the same key-value mappings as its argument. In effect, the latter
 * constructor allows the user to copy any map, producing an equivalent map of
 * the desired class.
 * 
 * There is no way to enforce this recommendation (as interfaces cannot contain
 * constructors) but all of the general-purpose map implementations in the JDK
 * comply.
 * 
 * The "destructive" methods contained in this interface, that is, the methods
 * that modify the map on which they operate, are specified to throw
 * UnsupportedOperationException if this map does not support the operation. If
 * this is the case, these methods may, but are not required to, throw an
 * UnsupportedOperationException if the invocation would have no effect on the
 * map. For example, invoking the putAll(java.util.Map) method on an
 * unmodifiable map may, but is not required to, throw the exception if the map
 * whose mappings are to be "superimposed" is empty.
 * 
 * Some map implementations have restrictions on the keys and values they may
 * contain. For example, some implementations prohibit null keys and values, and
 * some have restrictions on the types of their keys. Attempting to insert an
 * ineligible key or value throws an unchecked exception, typically
 * NullPointerException or ClassCastException.
 * 
 * Attempting to query the presence of an ineligible key or value may throw an
 * exception, or it may simply return false; some implementations will exhibit
 * the former behavior and some will exhibit the latter. More generally,
 * attempting an operation on an ineligible key or value whose completion would
 * not result in the insertion of an ineligible element into the map may throw
 * an exception or it may succeed, at the option of the implementation. Such
 * exceptions are marked as "optional" in the specification for this interface.
 * This interface is a member of the Java Collections Framework.
 * 
 * Many methods in Collections Framework interfaces are defined in terms of the
 * equals method. For example, the specification for the containsKey(Object key)
 * method says:
 * "returns true if and only if this map contains a mapping for a key k such that (key==null ? k==null : key.equals(k))."
 * This specification should not be construed to imply that invoking
 * Map.containsKey with a non-null argument key will cause key.equals(k) to be
 * invoked for any key k. Implementations are free to implement optimizations
 * whereby the equals invocation is avoided, for example, by first comparing the
 * hash codes of the two keys. (The java.lang.Object.hashCode() specification
 * guarantees that two objects with unequal hash codes cannot be equal.) More
 * generally, implementations of the various Collections Framework interfaces
 * are free to take advantage of the specified behavior of underlying
 * java.lang.Object methods wherever the implementor deems it appropriate.
 * 
 * @param <K>
 * @param <V>
 */
public interface CustomMap<K, V> {

	
	public int size();

	/**
	 * Returns true if this map contains no key-value mappings.
	 */
	public boolean isEmpty();

	/**
	 * Returns true if this map contains a mapping for the specified key. More
	 * formally, returns true if and only if this map contains a mapping for a
	 * key k such that (key==null ? k==null : key.equals(k)). (There can be at
	 * most one such mapping.)
	 */
	public boolean containsKey(Object key);

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * More formally, returns true if and only if this map contains at least one
	 * mapping to a value v such that (value==null ? v==null : value.equals(v)).
	 * This operation will probably require time linear in the map size for most
	 * implementations of the Map interface.
	 */
	public boolean containsValue(Object value);

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key. More formally, if this map contains
	 * a mapping from a key k to a value v such that (key==null ? k==null :
	 * key.equals(k)), then this method returns v; otherwise it returns null.
	 * (There can be at most one such mapping.) If this map permits null values,
	 * then a return value of null does not necessarily indicate that the map
	 * contains no mapping for the key; it's also possible that the map
	 * explicitly maps the key to null. The containsKey operation may be used to
	 * distinguish these two cases.
	 * 
	 * @param key
	 *            key the key whose associated value is to be returned
	 * 
	 * @return the value to which the specified key is mapped, or null if this
	 *         map contains no mapping for the key
	 * @throws ClassCastException
	 *             if the key is of an inappropriate type for this map
	 *             (optional)
	 * @throws NullPointerException
	 *             if the specified key is null and this map does not permit
	 *             null keys (optional)
	 */
	public V get(Object key);

	/**
	 * Associates the specified value with the specified key in this map
	 * (optional operation). If the map previously contained a mapping for the
	 * key, the old value is replaced by the specified value. (A map m is said
	 * to contain a mapping for a key k if and only if m.containsKey(k) would
	 * return true.)
	 * 
	 * @param key
	 *            key with which the specified value is to be associated
	 * 
	 * @param value
	 *            value to be associated with the specified key
	 * 
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key. (A null return can also indicate that the map
	 *         previously associated null with key, if the implementation
	 *         supports null values.)
	 * @throws UnsupportedOperationException
	 *             if the <tt>put</tt> operation is not supported by this map
	 * @throws ClassCastException
	 *             if the class of the specified key or value prevents it from
	 *             being stored in this map
	 * @throws NullPointerException
	 *             if the specified key or value is null and this map does not
	 *             permit null keys or values
	 * @throws IllegalArgumentException
	 *             if some property of the specified key or value prevents it
	 *             from being stored in this map
	 */
	public V put(K key, V value);

	/**
	 * Removes the mapping for a key from this map if it is present (optional
	 * operation). More formally, if this map contains a mapping from key k to
	 * value v such that (key==null ? k==null : key.equals(k)), that mapping is
	 * removed. (The map can contain at most one such mapping.) Returns the
	 * value to which this map previously associated the key, or null if the map
	 * contained no mapping for the key. If this map permits null values, then a
	 * return value of null does not necessarily indicate that the map contained
	 * no mapping for the key; it's also possible that the map explicitly mapped
	 * the key to null. The map will not contain a mapping for the specified key
	 * once the call returns.
	 * 
	 * 
	 * @param key
	 *            key whose mapping is to be removed from the map
	 * 
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 * 
	 * @throws java.lang.UnsupportedOperationException
	 *             if the remove operation is not supported by this map
	 * 
	 * @throws java.lang.ClassCastException
	 *             if the key is of an inappropriate type for this map
	 *             (optional)
	 * 
	 * @throws java.lang.NullPointerException
	 *             if the specified key is null and this map does not permit
	 *             null keys (optional)
	 * 
	 */
	public V remove(Object key);

	/**
	 * Copies all of the mappings from the specified map to this map (optional
	 * operation). The effect of this call is equivalent to that of calling
	 * put(k, v) on this map once for each mapping from key k to value v in the
	 * specified map. The behavior of this operation is undefined if the
	 * specified map is modified while the operation is in progress.
	 * 
	 * @param m
	 *            mappings to be stored in this map
	 * 
	 * @throws java.lang.UnsupportedOperationException
	 *             if the putAll operation is not supported by this map
	 * 
	 * @throws java.lang.ClassCastException
	 *             if the class of a key or value in the specified map prevents
	 *             it from being stored in this map
	 * 
	 * @throws java.lang.NullPointerException
	 *             if the specified map is null, or if this map does not permit
	 *             null keys or values, and the specified map contains null keys
	 *             or values
	 * 
	 * @throws java.lang.IllegalArgumentException
	 *             if some property of a key or value in the specified map
	 *             prevents it from being stored in this map
	 */
	public void putAll(CustomMap<? extends K, ? extends V> m);

	/**
	 * Removes all of the mappings from this map (optional operation). The map
	 * will be empty after this call returns.
	 * 
	 * @throws java.lang.UnsupportedOperationException
	 *             if the clear operation is not supported by this map
	 */
	public void clear();

	/**
	 * Returns a Set view of the keys contained in this map. The set is backed
	 * by the map, so changes to the map are reflected in the set, and
	 * vice-versa. If the map is modified while an iteration over the set is in
	 * progress (except through the iterator's own remove operation), the
	 * results of the iteration are undefined.
	 * 
	 * The set supports element removal, which removes the corresponding mapping
	 * from the map, via the Iterator.remove, Set.remove, removeAll, retainAll,
	 * and clear operations. It does not support the add or addAll operations.
	 */
	public CustomSet<K> keySet();

	/**
	 * Returns a Collection view of the values contained in this map. The
	 * collection is backed by the map, so changes to the map are reflected in
	 * the collection, and vice-versa. If the map is modified while an iteration
	 * over the collection is in progress (except through the iterator's own
	 * remove operation), the results of the iteration are undefined. The
	 * collection supports element removal, which removes the corresponding
	 * mapping from the map, via the Iterator.remove, Collection.remove,
	 * removeAll, retainAll and clear operations. It does not support the add or
	 * addAll operations.
	 */
	public CustomCollection<V> values();

	/**
	 * Returns a Set view of the mappings contained in this map. The set is
	 * backed by the map, so changes to the map are reflected in the set, and
	 * vice-versa. If the map is modified while an iteration over the set is in
	 * progress (except through the iterator's own remove operation, or through
	 * the setValue operation on a map entry returned by the iterator) the
	 * results of the iteration are undefined. The set supports element removal,
	 * which removes the corresponding mapping from the map, via the
	 * Iterator.remove, Set.remove, removeAll, retainAll and clear operations.
	 * It does not support the add or addAll operations.
	 */
	public CustomSet<CustomMap.CustomEntry<K, V>> entrySet();

	/**
	 * 
	 * ????????????????????
	 * 
	 * @param <K>
	 * @param <V>
	 */
	interface CustomEntry<K, V>{


		public K getKey();


		public V getValue();


		public V setValue(V value);


		public boolean equals(Object o);


		public int hashCode();
	}

	/**
	 * Compares the specified object with this map for equality. Returns true if
	 * the given object is also a map and the two maps represent the same
	 * mappings. More formally, two maps m1 and m2 represent the same mappings
	 * if m1.entrySet().equals(m2.entrySet()). This ensures that the equals
	 * method works properly across different implementations of the Map
	 * interface.
	 */
	public boolean equals(Object o);

	/**
	 * Returns the hash code value for this map. The hash code of a map is
	 * defined to be the sum of the hash codes of each entry in the map's
	 * entrySet() view. This ensures that m1.equals(m2) implies that
	 * m1.hashCode()==m2.hashCode() for any two maps m1 and m2, as required by
	 * the general contract of java.lang.Object.hashCode().
	 */
	public int hashCode();
}
