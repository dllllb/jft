package org.ext.jft.container;

import java.util.Iterator;

/**
 * @author Dmitri Babaev
 */
public interface IteratorF<E> extends Iterable<E>, Iterator<E> {
	IteratorF<E> iterator();
}
