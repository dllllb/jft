package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.arrayList;

import java.util.Collections;
import java.util.Comparator;

import org.ext.jft.container.ListF;
import org.ext.jft.container.Option;
import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractListF<E> extends AbstractCollectionF<E> implements ListF<E> {

	public Option<E> getFront() {
		return this.isEmpty() ? Option.<E>none() : Option.some(get(0));
	}

	public E getFrontOrElse(E elseVal) {
		return getFront().getOrElse(elseVal);
	}

	public <Ex extends Throwable> E getFrontOrThrow(Ex ex) throws Ex {
		return getFront().getOrThrow(ex);
	}

	public Option<E> getRandomValue() {
		int size = this.size();
		int n = (int) Math.random() * size;
		return n < size ? Option.some(get(n)) : Option.<E>none();
	}

	public <B extends Comparable<Object>> ListF<E> sortBy(final Mapper<E, B> mapper) {
		ListF<E> res = arrayList(this);
		Collections.sort(res, new Comparator<E>() {
			public int compare(E o1, E o2) {
				return mapper.map(o1).compareTo(mapper.map(o2));
			}
		});
		return res;
	}
}
