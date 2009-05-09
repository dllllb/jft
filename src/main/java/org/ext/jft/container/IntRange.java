package org.ext.jft.container;

import java.util.Iterator;

/**
 * @author Dmitri Babaev
 */
public class IntRange implements Iterable<Integer> {
	private int from;
	private int to;
	private int step;

	public IntRange(int from, int to, int step) {
		this.from = from;
		this.to = to;
		this.step = step;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int pos = from;
			
			public boolean hasNext() {
				return pos < to;
			}
			
			public Integer next() {
				int ret = pos;
				pos += step;
				return ret;
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
