package org.ext.jft.container.impl;

import org.ext.jft.container.ListF;
import org.ext.jft.container.SetF;
import org.ext.jft.container.Transformable;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

import java.util.Iterator;

import static org.ext.jft.container.Containers.*;

/**
 * @author Dmitri Babaev
 */
public abstract class DecoratingTransformable<E> implements Transformable<E> {

	abstract public Iterator<E> iterator();
	
	public <To> Transformable<To> map(Mapper<? super E, To> mapper) {
		return new MappedTransformable<E, To>(this, mapper);
	}

	public Transformable<E> filter(Predicate<? super E> predicate) {
		return new FilteredTransformable<E>(this, predicate);
	}

	public E reduce(Combiner<E, E, E> combiner, E initial) {
		E res = initial;
		for (E val : this) {
			res = combiner.apply(res, val);
		}
		return res;
	}
	
	public ListF<E> toArrayList() {
		return arrayList(this);
	}
	
	public ListF<E> toLinkedList() {
		return linkedList(this);
	}
	
	public SetF<E> toHashSet() {
		return hashSet(this);
	}
}
