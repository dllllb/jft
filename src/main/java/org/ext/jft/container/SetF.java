package org.ext.jft.container;

import java.util.Set;

import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;

/**
 * @author Dmitri Babaev
 */
public interface SetF<E> extends Set<E>, CollectionF<E> {
	
	<To> SetF<To> map(Mapper<E, To> mapper);

	SetF<E> filter(Predicate<E> predicate);
	
	SetF<E> difference(Set<E> right);

	SetF<E> union(Set<E> right);

	SetF<E> intersection(Set<E> right);
}
