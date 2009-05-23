package org.ext.jft.container;

import java.util.Set;

/**
 * @author Dmitri Babaev
 */
public interface SetF<E> extends Set<E>, CollectionF<E> {
	
	SetF<E> difference(Set<E> right);

	SetF<E> union(Set<E> right);

	SetF<E> intersection(Set<E> right);
}
