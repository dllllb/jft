package org.ext.jft.container;

/**
 * @author Dmitri Babaev
 */
public interface Generator<T> {
	Option<T> getNext();
}
