package org.ext.jft.container;

import java.util.Iterator;

/**
 * {@link Iterator} that implements {@link Iterable} interface
 * @author Dmitri Babaev
 */
public interface IteratorF<E> extends Iterable<E>, Iterator<E> {
	
	/**
	 * Declaration of the Iterable.iterator method that returns {@link IteratorF} instead of {@link Iterator}
	 */
	IteratorF<E> iterator();
}
