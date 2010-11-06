package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public class FilteringIterator<E> implements Iterator<E> {
	private Iterator<E> inner;
	private Predicate<E> predicate;
	private E lastValue;
	
	public FilteringIterator(Iterator<E> inner, Predicate<E> predicate) {
		this.inner = inner;
		this.predicate = predicate;
	}

	public boolean hasNext() {
		if (lastValue == null) {
			while (inner.hasNext()) {
				E value = inner.next();
				if (predicate.test(value)) {
					lastValue = value;
					return true;
				}
			}
			
			return false;
		}
		else {
			return true;
		}
	}
	
	public E next() {
		if (lastValue == null) {
			while (inner.hasNext()) {
				E value = inner.next();
				if (predicate.test(lastValue)) {
					return value;
				}
			}
			
			return null;
		}
		else {
			E res = lastValue;
			lastValue = null;
			return res;
		}
	}
	
	public void remove() {
		lastValue = null;
		inner.remove();
	}
}
