package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.container.IteratorF;
import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public class MappingIterator<F, T> implements IteratorF<T> {
	private Iterator<F> inner;
	private Mapper<F, T> mapper;
	
	public MappingIterator(Iterator<F> inner, Mapper<F, T> mapper) {
		this.inner = inner;
		this.mapper = mapper;
	}

	public boolean hasNext() {
		return inner.hasNext();
	}
	
	public IteratorF<T> iterator() {
		return this;
	}
	
	public T next() {
		return mapper.map(inner.next());
	}
	
	public void remove() {
		inner.remove();
	}
}
