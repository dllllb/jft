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
		return new Iterator<T>() {
			Iterator<F> it = inner.iterator();

			public boolean hasNext() {
				return it.hasNext();
			}

			public T next() {
				return mapper.map(it.next());
			}

			public void remove() {
				it.remove();
			}
		};
	}
	
	@Override
	public <To> Transformable<To> map(Mapper<T, To> mapper) {
		return new MappedTransormable<F, To>(inner, this.mapper.andThen(mapper));
	}
}
