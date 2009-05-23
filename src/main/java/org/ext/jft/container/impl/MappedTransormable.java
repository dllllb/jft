package org.ext.jft.container.impl;

import org.ext.jft.container.IteratorF;
import org.ext.jft.container.Transformable;
import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public class MappedTransormable<F, T> extends Transformable<T> {
	private Iterable<F> inner;
	private Mapper<F, T> mapper;
	
	public MappedTransormable(Iterable<F> inner, Mapper<F, T> mapper) {
		this.inner = inner;
		this.mapper = mapper;
	}

	public IteratorF<T> iterator() {
		return new MappingIterator<F, T>(inner.iterator(), mapper);
	}
}
