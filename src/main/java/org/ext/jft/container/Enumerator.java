package org.ext.jft.container;

/**
 * @author Dmitri Babaev
 */
public interface Enumerator<T> {
	Option<T> getNext();
}
