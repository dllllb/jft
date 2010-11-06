package org.ext.jft.container;

import java.util.Iterator;

/**
 * @author Dmitri Babaev
 */
public class EnumeratorIterator<T> implements Iterator<T> {
	private Enumerator<T> enumerator;
	private Option<T> next;
	
	public EnumeratorIterator(Enumerator<T> enumerator) {
		this.enumerator = enumerator;
		next = enumerator.getNext();
	}
	
	public boolean hasNext() {
		return next.isDefined();
	}

	public T next() {
		T res = next.get();
		next = enumerator.getNext();
		return res;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
