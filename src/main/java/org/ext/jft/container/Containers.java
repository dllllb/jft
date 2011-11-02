package org.ext.jft.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

import org.ext.jft.container.impl.DecoratedCollectionF;
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
	
	public static <K, V> MapF<K, V> decorate(Map<K, V> map) {
		return new DecoratedMapF<K, V>(map);
	}
	
	public static <E> SetF<E> decorate(Set<E> set) {
		return new DecoratedSetF<E>(set);
	}
	
	public static <E> CollectionF<E> decorate(Collection<E> set) {
		return new DecoratedCollectionF<E>(set);
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
	
	static public <T> ListF<T> linkedList(Iterable<T> iterable) {
		ListF<T> list = linkedList();
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
	
	static public <T> SetF<T> hashSet(Iterable<T> iterable) {
		SetF<T> set = hashSet();
		for (T t : iterable)
			set.add(t);
		return set;
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

    public static <K, V> MapF<K, V> hashMap(Map<K,V> entries) {
		return decorate(new HashMap<K, V>(entries));
	}
	
	public static <K, V> MapF<K, V> treeMap() {
		return decorate(new TreeMap<K, V>());
	}

    public static <K, V> MapF<K, V> treeMap(Map<K,V> entries) {
        return decorate(new TreeMap<K, V>(entries));
    }
	
	static public <T> T[] array(T... values) {
		return values;
	}
	
	static public <T> ListF<T> asList(T... values) {
		return decorate(Arrays.asList(values));
	}
	
	public static <T> Iterator<T> iterator(final Enumerator<T> enumerator) {
		return new Iterator<T>() {
			Option<T> next = enumerator.getNext();
			
			public boolean hasNext() {
				return next.isDefined();
			}

			public T next() {
				T res = next.getOrThrow(new NoSuchElementException());
				next = enumerator.getNext();
				return res;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static <T> Iterable<T> iterable(final Iterator<T> it) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return it;
			}
		};
	}
	
	public static <T> Iterable<T> iterable(Enumerator<T> enumerator) {
		return iterable(iterator(enumerator));
	}
	
	public static <T> Enumerator<T> enumerator(final Iterator<T> it) {
		return new Enumerator<T>() {
			public Option<T> getNext() {
				return it.hasNext() ? Option.some(it.next()) : Option.<T>none();
			}
		};
	}
	
	public static <E> IteratorF<E> decorate(Iterator<E> it) {
		return new DecoratedIteratorF<E>(it);
	}
	
	public static <E> Iterable<E> flatten(final Iterable<? extends Iterable<E>> iterables) {
		return new Iterable<E>() {
			public Iterator<E> iterator() {
				return new Iterator<E>() {
					Iterator<? extends Iterable<E>> outerIt = iterables.iterator();
					Iterator<E> innerIt = outerIt.hasNext() ?
						outerIt.next().iterator() : Collections.<E>emptyList().iterator();
					
					public boolean hasNext() {
						return outerIt.hasNext() || innerIt.hasNext();
					}
					
					public E next() {
						if (innerIt.hasNext())
							return innerIt.next();
						else if (outerIt.hasNext()) {
							innerIt = outerIt.next().iterator();
							return next();
						}
						else
							throw new NoSuchElementException();
					}
					
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
