package org.ext.jft.container;

/**
 * This class is factory class.
 * It creates generator classes similar to the Python range generator.
 * @author Dmitri Babaev
 */
public class Range {
	static Iterable<Integer> range(int to) {
		return range(0, to, 1);
	}
	
	static Iterable<Integer> range(int from, int to) {
		return range(from, to, 1);
	}
	
	static Iterable<Integer> range(int from, int to, int step) {
		return Containers.newIterable(new IntRangeGenerator(from, to, step));
	}
}
