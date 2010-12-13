package org.ext.jft.container;

import java.util.Iterator;

/**
 * @author Dmitri Babaev
 */
public interface IteratorF<E> extends Iterator<E> {
	Option<E> getOpt();
}
