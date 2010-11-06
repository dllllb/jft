package org.ext.jft.container;

import java.util.Iterator;

public class IterableIterator<T> implements Iterable<T> {
	private Iterator<T> it;
	
	public IterableIterator(Iterator<T> it) {
		this.it = it;
	}

	public Iterator<T> iterator() {
		return it;
	}
}
