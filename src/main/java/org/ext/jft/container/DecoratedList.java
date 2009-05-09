package org.ext.jft.container;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public class DecoratedList<E> implements ListF<E> {
	private List<E> list;
	
	static public <T> ListF<T> decorate(List<T> list) {
		return new DecoratedList<T>(list);
	}

	private DecoratedList(List<E> list) {
		this.list = list;
	}
	
	public <To> ListF<To> map(Mapper<E, To> mapper) {
		return decorate(Lists.map(list, mapper));
	}
	
	public ListF<E> filter(Predicate<E> predicate) {
		return decorate(Lists.filter(list, predicate));
	}
	
	public E reduce(Combiner<E, E, E> combiner, E initial) {
		return Lists.reduce(list, combiner, initial);
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

	public Iterator<E> iterator() {
		return list.iterator();
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

	public List<E> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
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
