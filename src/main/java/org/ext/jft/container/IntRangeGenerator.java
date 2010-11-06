package org.ext.jft.container;

/**
 * @author Dmitri Babaev
 */
public class IntRangeGenerator implements Generator<Integer> {
	private int to;
	private int step;
	private int pos;
	
	public IntRangeGenerator(int from, int to, int step) {
		this.to = to;
		this.step = step;
		pos = from;
	}

	public Option<Integer> getNext() {
		if (pos < to) {
			int ret = pos;
			pos += step;
			return Option.some(ret);
		}
		else return Option.none();
	}
}
