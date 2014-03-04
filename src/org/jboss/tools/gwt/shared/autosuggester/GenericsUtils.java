package org.jboss.tools.gwt.shared.autosuggester;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Provides convenience methods for creating instances of typed collections and maps. Main purpose
 * is to make code where typed maps and collections are instantiated more readable.
 */
public final class GenericsUtils {
	public static <T> Set<T> difference(Collection<T> collection1, Collection<T> collection2) {
		Set<T> set = new HashSet<T>(collection1);
		set.removeAll(collection2);

		return set;
	}

	public static <T> Set<T> intersect(Collection<T> collection1, Collection<T> collection2) {
		Set<T> set = new HashSet<T>();

		if (collection1 != null && collection2 != null) {
			set.addAll(collection1);
			set.retainAll(collection2);
		}

		return set;
	}

	public static <T> List<T> newConcurrentList() {
		return new CopyOnWriteArrayList<T>();
	}

	public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
		return new ConcurrentHashMap<K, V>();
	}

	public static <T> Set<T> newConcurrentSet() {
		return new CopyOnWriteArraySet<T>();
	}

	public static <T> Deque<T> newDeque() {
		return new ArrayDeque<T>();
	}

	public static <T> Deque<T> newDeque(Collection<T> collection) {
		return new ArrayDeque<T>(collection);
	}

	public static <K, V> Map<K, V> newIdentityMap() {
		return new IdentityHashMap<K, V>();
	}

	public static <K, V> Map<K, V> newLinkedMap() {
		return new LinkedHashMap<K, V>();
	}

	public static <T> List<T> newList() {
		return new ArrayList<T>();
	}

	public static <T> List<T> newList(Collection<T> collection) {
		return new ArrayList<T>(collection);
	}

	public static <T> List<T> newList(T... values) {
		return newList(Arrays.asList(values));
	}

	/**
	 * @param <K> the type of the key
	 * @param <V> the type of the value
	 * @return a new map with the given generic types
	 */
	public static <K, V> Map<K, V> newMap() {
		return new HashMap<K, V>();
	}

	/**
	 * Creates a new map with one initial key-value pair
	 *
	 * @param <K> the type of all keys
	 * @param <V> the type of all values
	 * @param key the initial key
	 * @param value the inital value
	 * @return the new map, filled with one entry
	 */
	public static <K, V> Map<K, V> newMap(K key, V value) {
		Map<K, V> map = newMap();
		map.put(key, value);
		return map;
	}

	public static <K, V> Map<K, V> newMap(Map<K, V> map) {
		return new HashMap<K, V>(map);
	}

	public static <T> Set<T> newSet() {
		return new HashSet<T>();
	}

	public static <T> Set<T> newSet(Collection<T> collection) {
		return new HashSet<T>(collection);
	}

	public static <T> Set<T> newSet(T... values) {
		return newSet(Arrays.asList(values));
	}

	public static <K, V> SortedMap<K, V> newSortedMap() {
		return new TreeMap<K, V>();
	}

	public static <T> SortedSet<T> newSortedSet() {
		return new TreeSet<T>();
	}

	public static <T> SortedSet<T> newSortedSet(Collection<T> collection) {
		return new TreeSet<T>(collection);
	}

	public static <T> Set<T> union(Collection<T> collection1, Collection<T> collection2) {
		Set<T> set = new HashSet<T>(collection1);
		set.addAll(collection2);

		return set;
	}

	private GenericsUtils() {
	}
}
