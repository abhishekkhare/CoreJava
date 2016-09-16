package com.edu.abhi.Collections.map;

import java.util.Map;

import com.edu.abhi.Collections.CustomAbstractCollection;
import com.edu.abhi.Collections.CustomCollection;
import com.edu.abhi.Collections.CustomIterator;
import com.edu.abhi.Collections.set.CustomAbstractSet;
import com.edu.abhi.Collections.set.CustomSet;

public abstract class CustomAbstractMap<K, V> implements CustomMap<K, V> {

	/**
	 * Sole constructor. (For invocation by subclass constructors, typically
	 * implicit.)
	 */

	protected CustomAbstractMap() {

	}

	@Override
	public int size() {
		return entrySet().size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * This implementation iterates over entrySet() searching for an entry with
	 * the specified key. If such an entry is found, true is returned. If the
	 * iteration terminates without finding such an entry, false is returned.
	 * Note that this implementation requires linear time in the size of the
	 * map; many implementations will override this method.
	 */
	public boolean containsKey(Object key) {
		CustomIterator<CustomMap.CustomEntry<K, V>> i = entrySet().iterator();
		if (key == null) {
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (e.getKey() == null)
					return true;
			}
		} else {
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (key.equals(e.getKey()))
					return true;
			}
		}
		return false;
	}

	/**
	 * This implementation iterates over entrySet() searching for an entry with
	 * the specified value. If such an entry is found, true is returned. If the
	 * iteration terminates without finding such an entry, false is returned.
	 * Note that this implementation requires linear time in the size of the
	 * map.
	 */
	public boolean containsValue(Object value) {
		CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();
		if (value == null) {
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (e.getValue() == null)
					return true;
			}
		} else {
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (value.equals(e.getValue()))
					return true;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();
		if (key == null) {
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (e.getKey() == null)
					return e.getValue();
			}
		} else {
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (key.equals(e.getKey()))
					return e.getValue();
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This implementation iterates over entrySet() searching for an entry with
	 * the specified key. If such an entry is found, its value is obtained with
	 * its getValue operation, the entry is removed from the collection (and the
	 * backing map) with the iterator's remove operation, and the saved value is
	 * returned. If the iteration terminates without finding such an entry, null
	 * is returned.
	 * 
	 * Note that this implementation requires linear time in the size of the
	 * map; many implementations will override this method. Note that this
	 * implementation throws an UnsupportedOperationException if the entrySet
	 * iterator does not support the remove method and this map contains a
	 * mapping for the specified key.
	 * 
	 * 
	 * @throws java.lang.UnsupportedOperationException
	 * 
	 * @throws java.lang.ClassCastException
	 * 
	 * @throws java.lang.NullPointerException
	 */

	public V remove(Object key) {
		CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();
		CustomEntry<K, V> correctEntry = null;
		if (key == null) {
			while (correctEntry == null && i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (e.getKey() == null)
					correctEntry = e;
			}
		} else {
			while (correctEntry == null && i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				if (key.equals(e.getKey()))
					correctEntry = e;
			}
		}

		V oldValue = null;
		if (correctEntry != null) {
			oldValue = correctEntry.getValue();
			i.remove();
		}
		return oldValue;
	}

	@Override
	public void putAll(CustomMap<? extends K, ? extends V> m) {
		for (CustomMap.CustomEntry<? extends K, ? extends V> e : m.entrySet())
			put(e.getKey(), e.getValue());

	}

	@Override
	public void clear() {
		entrySet().clear();

	}

	/**
	 * Each of these fields are initialized to contain an instance of the
	 * appropriate view the first time this view is requested. The views are
	 * stateless, so there's no reason to create more than one of each.
	 */
	transient volatile CustomSet<K> keySet = null;
	transient volatile CustomCollection<V> values = null;

	/**
	 * This implementation returns a set that subclasses AbstractSet. The
	 * subclass's iterator method returns a "wrapper object" over this map's
	 * entrySet() iterator. The size method delegates to this map's size method
	 * and the contains method delegates to this map's containsKey method. The
	 * set is created the first time this method is called, and returned in
	 * response to all subsequent calls. No synchronization is performed, so
	 * there is a slight chance that multiple calls to this method will not all
	 * return the same set.
	 */
	public CustomSet<K> keySet() {
		if (keySet == null) {
			keySet = new CustomAbstractSet<K>() {
				public CustomIterator<K> iterator() {
					return new CustomIterator<K>() {
						private CustomIterator<CustomEntry<K, V>> i = entrySet()
								.iterator();

						public boolean hasNext() {
							return i.hasNext();
						}

						public K next() {
							return i.next().getKey();
						}

						public void remove() {
							i.remove();
						}
					};
				}

				public int size() {
					return CustomAbstractMap.this.size();
				}

				public boolean isEmpty() {
					return CustomAbstractMap.this.isEmpty();
				}

				public void clear() {
					CustomAbstractMap.this.clear();
				}

				public boolean contains(Object k) {
					return CustomAbstractMap.this.containsKey(k);
				}
			};
		}
		return keySet;
	}

	/**
	 * This implementation returns a collection that subclasses
	 * AbstractCollection. The subclass's iterator method returns a
	 * "wrapper object" over this map's entrySet() iterator. The size method
	 * delegates to this map's size method and the contains method delegates to
	 * this map's containsValue method. The collection is created the first time
	 * this method is called, and returned in response to all subsequent calls.
	 * No synchronization is performed, so there is a slight chance that
	 * multiple calls to this method will not all return the same collection.
	 */
	public CustomCollection<V> values() {
		if (values == null) {
			values = new CustomAbstractCollection<V>() {
				public CustomIterator<V> iterator() {
					return new CustomIterator<V>() {
						private CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();

						public boolean hasNext() {
							return i.hasNext();
						}

						public V next() {
							return i.next().getValue();
						}

						public void remove() {
							i.remove();
						}
					};
				}

				public int size() {
					return CustomAbstractMap.this.size();
				}

				public boolean isEmpty() {
					return CustomAbstractMap.this.isEmpty();
				}

				public void clear() {
					CustomAbstractMap.this.clear();
				}

				public boolean contains(Object v) {
					return CustomAbstractMap.this.containsValue(v);
				}

			};
		}
		return values;
	}
	
	@Override
	public abstract CustomSet<CustomMap.CustomEntry<K, V>> entrySet();

	/**
	 * Compares the specified object with this map for equality. Returns true if
	 * the given object is also a map and the two maps represent the same
	 * mappings. More formally, two maps m1 and m2 represent the same mappings
	 * if m1.entrySet().equals(m2.entrySet()). This ensures that the equals
	 * method works properly across different implementations of the Map
	 * interface. This implementation first checks if the specified object is
	 * this map; if so it returns true. Then, it checks if the specified object
	 * is a map whose size is identical to the size of this map; if not, it
	 * returns false. If so, it iterates over this map's entrySet collection,
	 * and checks that the specified map contains each mapping that this map
	 * contains. If the specified map fails to contain such a mapping, false is
	 * returned. If the iteration completes, true is returned.
	 */

	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof Map))
			return false;
		@SuppressWarnings("unchecked")
		Map<K, V> m = (Map<K, V>) o;
		if (m.size() != size())
			return false;

		try {
			CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();
			while (i.hasNext()) {
				CustomEntry<K, V> e = i.next();
				K key = e.getKey();
				V value = e.getValue();
				if (value == null) {
					if (!(m.get(key) == null && m.containsKey(key)))
						return false;
				} else {
					if (!value.equals(m.get(key)))
						return false;
				}
			}
		} catch (ClassCastException unused) {
			return false;
		} catch (NullPointerException unused) {
			return false;
		}

		return true;
	}
	
	

	/**
	 * Returns the hash code value for this map. The hash code of a map is
	 * defined to be the sum of the hash codes of each entry in the map's
	 * entrySet() view. This ensures that m1.equals(m2) implies that
	 * m1.hashCode()==m2.hashCode() for any two maps m1 and m2, as required by
	 * the general contract of java.lang.Object.hashCode(). This implementation
	 * iterates over entrySet(), calling hashCode() on each element (entry) in
	 * the set, and adding up the results.
	 */
	public int hashCode() {
		int h = 0;
		CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();
		while (i.hasNext())
			h += i.next().hashCode();
		return h;
	}

	@Override
	public String toString() {
		CustomIterator<CustomEntry<K, V>> i = entrySet().iterator();
		if (!i.hasNext())
			return "{}";

		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (;;) {
			CustomEntry<K, V> e = i.next();
			K key = e.getKey();
			V value = e.getValue();
			sb.append(key == this ? "(this Map)" : key);
			sb.append('=');
			sb.append(value == this ? "(this Map)" : value);
			if (!i.hasNext())
				return sb.append('}').toString();
			sb.append(", ");
		}
	}

	/**
     * Returns a shallow copy of this <tt>AbstractMap</tt> instance: the keys
     * and values themselves are not cloned.
     *
     * @return a shallow copy of this map
     */
    protected Object clone() throws CloneNotSupportedException {
        @SuppressWarnings("unchecked")
		CustomAbstractMap<K,V> result = (CustomAbstractMap<K,V>)super.clone();
        result.keySet = null;
        result.values = null;
        return result;
    }

    /**
     * Utility method for SimpleEntry and SimpleImmutableEntry.
     * Test for equality, checking for nulls.
     */
    private static boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    // Implementation Note: SimpleEntry and SimpleImmutableEntry
    // are distinct unrelated classes, even though they share
    // some code. Since you can't add or subtract final-ness
    // of a field in a subclass, they can't share representations,
    // and the amount of duplicated code is too small to warrant
    // exposing a common abstract class.


    /**
     * An Entry maintaining a key and a value.  The value may be
     * changed using the <tt>setValue</tt> method.  This class
     * facilitates the process of building custom map
     * implementations. For example, it may be convenient to return
     * arrays of <tt>SimpleEntry</tt> instances in method
     * <tt>Map.entrySet().toArray</tt>.
     *
     * @since 1.6
     */
    public static class SimpleEntry<K,V>
        implements CustomEntry<K,V>, java.io.Serializable
    {
        private static final long serialVersionUID = -8499721149061103585L;

        private final K key;
        private V value;

        /**
         * Creates an entry representing a mapping from the specified
         * key to the specified value.
         *
         * @param key the key represented by this entry
         * @param value the value represented by this entry
         */
        public SimpleEntry(K key, V value) {
            this.key   = key;
            this.value = value;
        }

        /**
         * Creates an entry representing the same mapping as the
         * specified entry.
         *
         * @param entry the entry to copy
         */
        public SimpleEntry(CustomEntry<? extends K, ? extends V> entry) {
            this.key   = entry.getKey();
            this.value = entry.getValue();
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         */
        public K getKey() {
            return key;
        }

        /**
         * Returns the value corresponding to this entry.
         *
         * @return the value corresponding to this entry
         */
        public V getValue() {
            return value;
        }

        /**
         * Replaces the value corresponding to this entry with the specified
         * value.
         *
         * @param value new value to be stored in this entry
         * @return the old value corresponding to the entry
         */
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        /**
         * Compares the specified object with this entry for equality.
         * Returns {@code true} if the given object is also a map entry and
         * the two entries represent the same mapping.  More formally, two
         * entries {@code e1} and {@code e2} represent the same mapping
         * if<pre>
         *   (e1.getKey()==null ?
         *    e2.getKey()==null :
         *    e1.getKey().equals(e2.getKey()))
         *   &amp;&amp;
         *   (e1.getValue()==null ?
         *    e2.getValue()==null :
         *    e1.getValue().equals(e2.getValue()))</pre>
         * This ensures that the {@code equals} method works properly across
         * different implementations of the {@code Map.Entry} interface.
         *
         * @param o object to be compared for equality with this map entry
         * @return {@code true} if the specified object is equal to this map
         *         entry
         * @see    #hashCode
         */
        public boolean equals(Object o) {
            if (!(o instanceof CustomMap.CustomEntry))
                return false;
            @SuppressWarnings("rawtypes")
            CustomMap.CustomEntry e = (CustomMap.CustomEntry)o;
            return eq(key, e.getKey()) && eq(value, e.getValue());
        }

        /**
         * Returns the hash code value for this map entry.  The hash code
         * of a map entry {@code e} is defined to be: <pre>
         *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
         *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
         * This ensures that {@code e1.equals(e2)} implies that
         * {@code e1.hashCode()==e2.hashCode()} for any two Entries
         * {@code e1} and {@code e2}, as required by the general
         * contract of {@link Object#hashCode}.
         *
         * @return the hash code value for this map entry
         * @see    #equals
         */
        public int hashCode() {
            return (key   == null ? 0 :   key.hashCode()) ^
                   (value == null ? 0 : value.hashCode());
        }

        /**
         * Returns a String representation of this map entry.  This
         * implementation returns the string representation of this
         * entry's key followed by the equals character ("<tt>=</tt>")
         * followed by the string representation of this entry's value.
         *
         * @return a String representation of this map entry
         */
        public String toString() {
            return key + "=" + value;
        }

    }

    /**
     * An Entry maintaining an immutable key and value.  This class
     * does not support method <tt>setValue</tt>.  This class may be
     * convenient in methods that return thread-safe snapshots of
     * key-value mappings.
     *
     * @since 1.6
     */
    public static class SimpleImmutableEntry<K,V>
        implements CustomEntry<K,V>, java.io.Serializable
    {
        private static final long serialVersionUID = 7138329143949025153L;

        private final K key;
        private final V value;

        /**
         * Creates an entry representing a mapping from the specified
         * key to the specified value.
         *
         * @param key the key represented by this entry
         * @param value the value represented by this entry
         */
        public SimpleImmutableEntry(K key, V value) {
            this.key   = key;
            this.value = value;
        }

        /**
         * Creates an entry representing the same mapping as the
         * specified entry.
         *
         * @param entry the entry to copy
         */
        public SimpleImmutableEntry(CustomEntry<? extends K, ? extends V> entry) {
            this.key   = entry.getKey();
            this.value = entry.getValue();
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         */
        public K getKey() {
            return key;
        }

        /**
         * Returns the value corresponding to this entry.
         *
         * @return the value corresponding to this entry
         */
        public V getValue() {
            return value;
        }

        /**
         * Replaces the value corresponding to this entry with the specified
         * value (optional operation).  This implementation simply throws
         * <tt>UnsupportedOperationException</tt>, as this class implements
         * an <i>immutable</i> map entry.
         *
         * @param value new value to be stored in this entry
         * @return (Does not return)
         * @throws UnsupportedOperationException always
         */
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        /**
         * Compares the specified object with this entry for equality.
         * Returns {@code true} if the given object is also a map entry and
         * the two entries represent the same mapping.  More formally, two
         * entries {@code e1} and {@code e2} represent the same mapping
         * if<pre>
         *   (e1.getKey()==null ?
         *    e2.getKey()==null :
         *    e1.getKey().equals(e2.getKey()))
         *   &amp;&amp;
         *   (e1.getValue()==null ?
         *    e2.getValue()==null :
         *    e1.getValue().equals(e2.getValue()))</pre>
         * This ensures that the {@code equals} method works properly across
         * different implementations of the {@code Map.Entry} interface.
         *
         * @param o object to be compared for equality with this map entry
         * @return {@code true} if the specified object is equal to this map
         *         entry
         * @see    #hashCode
         */
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            @SuppressWarnings("rawtypes")
			Map.Entry e = (Map.Entry)o;
            return eq(key, e.getKey()) && eq(value, e.getValue());
        }

        /**
         * Returns the hash code value for this map entry.  The hash code
         * of a map entry {@code e} is defined to be: <pre>
         *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
         *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
         * This ensures that {@code e1.equals(e2)} implies that
         * {@code e1.hashCode()==e2.hashCode()} for any two Entries
         * {@code e1} and {@code e2}, as required by the general
         * contract of {@link Object#hashCode}.
         *
         * @return the hash code value for this map entry
         * @see    #equals
         */
        public int hashCode() {
            return (key   == null ? 0 :   key.hashCode()) ^
                   (value == null ? 0 : value.hashCode());
        }

        /**
         * Returns a String representation of this map entry.  This
         * implementation returns the string representation of this
         * entry's key followed by the equals character ("<tt>=</tt>")
         * followed by the string representation of this entry's value.
         *
         * @return a String representation of this map entry
         */
        public String toString() {
            return key + "=" + value;
        }

    }

}
