package org.ext.jft.container;

import static org.ext.jft.container.Containers.*;

import java.util.Iterator;

import org.ext.jft.container.impl.FilteredTransformable;
import org.ext.jft.container.impl.MappedTransormable;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public abstract class Transformable<E> implements Iterable<E> {

	abstract public Iterator<E> iterator();
	
	public <To> Transformable<To> map(Mapper<E, To> mapper) {
		return new MappedTransormable<E, To>(this, mapper);
	}

	public Transformable<E> filter(Predicate<E> predicate) {
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
