package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.decorate;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.ext.jft.container.IteratorF;
import org.ext.jft.container.ListF;

public class DecoratedListF<E> extends AbstractListF<E> {
	private List<E> list;
	
	public DecoratedListF(List<E> list) {
		this.list = list;
	}

	public void add(int index, E element) {
		list.add(index, element);
	}

	public boolean add(E e) {
		return list.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		return list.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return list.addAll(index, c);
	}

	public void clear() {
		list.clear();
	}

	public boolean contains(Object o) {
		return list.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean equals(Object o) {
		return list.equals(o);
	}

	public E get(int index) {
		return list.get(index);
	}

	@Override
	public int hashCode() {
		return list.hashCode();
	}

	public int indexOf(Object o) {
		return list.indexOf(o);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public IteratorF<E> iterator() {
		return decorate(list.iterator());
	}

	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		return list.listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		return list.listIterator(index);
	}

	public E remove(int index) {
		return list.remove(index);
	}

	public boolean remove(Object o) {
		return list.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	public E set(int index, E element) {
		return list.set(index, element);
	}

	public int size() {
		return list.size();
	}

	public ListF<E> subList(int fromIndex, int toIndex) {
		return decorate(list.subList(fromIndex, toIndex));
	}

	public Object[] toArray() {
		return list.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	@Override
	public String toString() {
		return list.toString();
	}
}