package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.decorate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.ext.jft.container.ListF;

public class DecoratedListF<E> extends AbstractListF<E> {
	private List<E> inner;
	
	public DecoratedListF(List<E> list) {
		this.inner = list;
	}

	public void add(int index, E element) {
		inner.add(index, element);
	}

	public boolean add(E e) {
		return inner.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		return inner.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return inner.addAll(index, c);
	}

	public void clear() {
		inner.clear();
	}

	public boolean contains(Object o) {
		return inner.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return inner.containsAll(c);
	}

	@Override
	public boolean equals(Object o) {
		return inner.equals(o);
	}

	public E get(int index) {
		return inner.get(index);
	}

	@Override
	public int hashCode() {
		return inner.hashCode();
	}

	public int indexOf(Object o) {
		return inner.indexOf(o);
	}

	public boolean isEmpty() {
		return inner.isEmpty();
	}

	public Iterator<E> iterator() {
		return inner.iterator();
	}

	public int lastIndexOf(Object o) {
		return inner.lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		return inner.listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		return inner.listIterator(index);
	}

	public E remove(int index) {
		return inner.remove(index);
	}

	public boolean remove(Object o) {
		return inner.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return inner.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return inner.retainAll(c);
	}

	public E set(int index, E element) {
		return inner.set(index, element);
	}

	public int size() {
		return inner.size();
	}

	public ListF<E> subList(int fromIndex, int toIndex) {
		return decorate(inner.subList(fromIndex, toIndex));
	}

	public Object[] toArray() {
		return inner.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return inner.toArray(a);
	}

	@Override
	public String toString() {
		return inner.toString();
	}
}