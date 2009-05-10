package org.ext.jft.container.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Dmitri Babaev
 */
public class DecoratedSetF<E> extends AbstractSetF<E> {
	private Set<E> set;
	
	public DecoratedSetF(Set<E> set) {
		this.set = set;
	}
	
	public boolean add(E e) {
		return set.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		return set.addAll(c);
	}

	public void clear() {
		set.clear();
	}

	public boolean contains(Object o) {
		return set.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	@Override
	public boolean equals(Object o) {
		return set.equals(o);
	}

	@Override
	public int hashCode() {
		return set.hashCode();
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public Iterator<E> iterator() {
		return set.iterator();
	}

	public boolean remove(Object o) {
		return set.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}

	public int size() {
		return set.size();
	}

	public Object[] toArray() {
		return set.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}
	
	@Override
	public String toString() {
		return set.toString();
	}
}
