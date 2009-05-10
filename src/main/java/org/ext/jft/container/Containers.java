package org.ext.jft.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.ext.jft.container.impl.DecoratedIteratorF;
import org.ext.jft.container.impl.DecoratedListF;
import org.ext.jft.container.impl.DecoratedMapF;
import org.ext.jft.container.impl.DecoratedSetF;

/**
 * @author Dmitri Babaev
 */
public class Containers {
	public static <T> ListF<T> decorate(List<T> list) {
		return new DecoratedListF<T>(list);
	}
	
	public static <T> IteratorF<T> decorate(Iterator<T> it) {
		return new DecoratedIteratorF<T>(it);
	}
	
	public static <K, V> MapF<K, V> decorate(Map<K, V> map) {
		return new DecoratedMapF<K, V>(map);
	}
	
	public static <E> SetF<E> decorate(Set<E> set) {
		return new DecoratedSetF<E>(set);
	}
	
	static public <T> ListF<T> arrayList(T... values) {
		return arrayList(Arrays.asList(values));
	}
	
	static public <T> ListF<T> linkedList(T... values) {
		return linkedList(Arrays.asList(values));
	}

	static public <T> ListF<T> arrayList(Collection<T> values) {
		return decorate(new ArrayList<T>(values));
	}
	
	static public <T> ListF<T> arrayList(Iterable<T> iterable) {
		ListF<T> list = arrayList();
		for (T t : iterable)
			list.add(t);
		return list;
	}
	
	static public <T> ListF<T> linkedList(List<T> values) {
		return decorate(new LinkedList<T>(values));
	}

	public static <T> ListF<T> arrayList() {
		return decorate(new ArrayList<T>());
	}
	
	public static <T> ListF<T> linkedList() {
		return decorate(new LinkedList<T>());
	}
	
	public static <T> SetF<T> hashSet() {
		return decorate(new HashSet<T>());
	}

	public static <T> SetF<T> hashSet(T... values) {
		return hashSet(Arrays.asList(values));
	}

	public static <T> SetF<T> hashSet(Collection<T> values) {
		return decorate(new HashSet<T>(values));
	}
	
	public static <K, V> MapF<K, V> hashMap() {
		return decorate(new HashMap<K, V>());
	}
	
	public static <K, V> MapF<K, V> treeMap() {
		return decorate(new TreeMap<K, V>());
	}
	
	static public <K, V> MapF<K, V> hashMap(K[] keys, V[] values) {
		MapF<K, V> res = hashMap();
		
		for (int i = 0; i < keys.length; ++i) {
			res.put(keys[i], values[i]);
		}
		
		return res;
	}
	
	static public <T> T[] array(T... values) {
		return values;
	}
}
