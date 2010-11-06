package org.ext.jft.container.impl;

import java.util.Iterator;

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

	public Iterator<T> iterator() {
		return new MappingIterator<F, T>(inner.iterator(), mapper);
	}
	
	@Override
	public <To> Transformable<To> map(Mapper<T, To> mapper) {
		return new MappedTransormable<F, To>(inner, this.mapper.andThen(mapper));
	}
}
