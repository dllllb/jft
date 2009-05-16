package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.container.IteratorF;

/**
 * @author Dmitri Babaev
 */
public class DecoratedIteratorF<E> implements IteratorF<E> {
	protected Iterator<E> inner;
	
	public DecoratedIteratorF(Iterator<E> it) {
		this.inner = it;
	}

	public boolean hasNext() {
		return inner.hasNext();
	}

	public E next() {
		return inner.next();
	}

	public void remove() {
		inner.remove();
	}
	
	public IteratorF<E> iterator() {
		return this;
	}
}
