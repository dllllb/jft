package org.ext.jft.lang;

import java.util.Iterator;

/**
 * Helper class to create {@code Iterable} from {@code Iterator}
 * @author Dmitri Babaev
 */
public class IterableIterator<E> implements Iterable<E> {
	Iterator<E> iterator;
	
	public IterableIterator(Iterator<E> iterator) {
		this.iterator = iterator;
	}
	
	public Iterator<E> iterator() {
		return iterator;
	}
}
