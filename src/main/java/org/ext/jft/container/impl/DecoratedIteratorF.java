package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.container.IteratorF;

/**
 * @author Dmitri Babaev
 */
public class DecoratedIteratorF<E> implements IteratorF<E> {
	protected Iterator<E> it;
	
	public DecoratedIteratorF(Iterator<E> it) {
		this.it = it;
	}

	public boolean hasNext() {
		return it.hasNext();
	}

	public E next() {
		return it.next();
	}

	public void remove() {
		it.remove();
	}
	
	public IteratorF<E> iterator() {
		return new DecoratedIteratorF<E>(it);
	}
}
