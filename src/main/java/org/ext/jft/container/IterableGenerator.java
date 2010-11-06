package org.ext.jft.container;

import java.util.Iterator;

/**
 * @author Dmitri Babaev
 */
public class IterableGenerator<T> implements Iterable<T> {
	private Enumerator<T> generator;
	
	public IterableGenerator(Enumerator<T> generator) {
		this.generator = generator;
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Option<T> next = generator.getNext();
			
			public boolean hasNext() {
				return next.isDefined();
			}

			public T next() {
				T res = next.get();
				next = generator.getNext();
				return res;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
