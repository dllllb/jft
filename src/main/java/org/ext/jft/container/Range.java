package org.ext.jft.container;

/**
 * This class is factory class.
 * It creates generator classes similar to the Python range generator.
 * @author Dmitri Babaev
 */
public class Range {
	static IntRange range(int to) {
		return new IntRange(0, to, 1);
	}
	
	static IntRange range(int from, int to) {
		return new IntRange(from, to, 1);
	}
	
	static IntRange range(int from, int to, int step) {
		return new IntRange(from, to, step);
	}
}
