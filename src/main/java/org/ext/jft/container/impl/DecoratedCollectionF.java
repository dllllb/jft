package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.decorate;

import java.util.Collection;

import org.ext.jft.container.IteratorF;

public class DecoratedCollectionF<E> extends AbstractCollectionF<E> {
	private Collection<E> collection;
	
	public DecoratedCollectionF(Collection<E> collection) {
		this.collection = collection;
	}

	public boolean add(E e) {
		return collection.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		return collection.addAll(c);
	}

	public void clear() {
		collection.clear();
	}

	public boolean contains(Object o) {
		return collection.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return collection.containsAll(c);
	}

	@Override
	public boolean equals(Object o) {
		return collection.equals(o);
	}

	@Override
	public int hashCode() {
		return collection.hashCode();
	}

	public boolean isEmpty() {
		return collection.isEmpty();
	}

	public IteratorF<E> iterator() {
		return decorate(collection.iterator());
	}

	public boolean remove(Object o) {
		return collection.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return collection.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return collection.retainAll(c);
	}

	public int size() {
		return collection.size();
	}

	public Object[] toArray() {
		return collection.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return collection.toArray(a);
	}
	
	@Override
	public String toString() {
		return collection.toString();
	}
}
