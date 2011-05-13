package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.container.Option;
import org.ext.jft.container.Transformable;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public class FilteredTransformable<E> extends Transformable<E> {
	private Iterable<E> inner;
	private Predicate<? super E> predicate;
	
	public FilteredTransformable(Iterable<E> inner, Predicate<? super E> predicate) {
		this.inner = inner;
		this.predicate = predicate;
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Iterator<E> it = inner.iterator();
			Option<E> lastValue = getNextValue();
			
			Option<E> getNextValue() {
				while (it.hasNext()) {
					E value = it.next();
					if (predicate.apply(value)) {
						return Option.some(value);
					}
				}
				
				return Option.none();
			}

			public boolean hasNext() {
				return lastValue.isDefined();
			}

			public E next() {
				E res = lastValue.get();
				lastValue = getNextValue();
				return res;
			}

			public void remove() {
				it.remove();
				lastValue = getNextValue();
			}
			
		};
	}
}
