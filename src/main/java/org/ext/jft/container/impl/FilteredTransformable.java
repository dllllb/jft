package org.ext.jft.container.impl;

import org.ext.jft.container.IteratorF;
import org.ext.jft.container.Transformable;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public class FilteredTransformable<E> extends Transformable<E> {
	private Iterable<E> inner;
	private Predicate<E> predicate;
	
	public FilteredTransformable(Iterable<E> inner, Predicate<E> predicate) {
		this.inner = inner;
		this.predicate = predicate;
	}

	public IteratorF<E> iterator() {
		return new FilteringIterator<E>(inner.iterator(), predicate);
	}
}
