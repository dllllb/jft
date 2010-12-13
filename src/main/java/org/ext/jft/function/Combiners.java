package org.ext.jft.function;

public class Combiners {
	public static <T extends Comparable<T>> Combiner<T, T, T> max() {
		return new Combiner<T, T, T>() {
			public T combine(T fromLeft, T fromRight) {
				return fromLeft.compareTo(fromRight) < 0 ? fromRight : fromLeft;
			}
		};
	}
	
	public static <T extends Comparable<T>> Combiner<T, T, T> min() {
		return new Combiner<T, T, T>() {
			public T combine(T fromLeft, T fromRight) {
				return fromLeft.compareTo(fromRight) > 0 ? fromRight : fromLeft;
			}
		};
	}
}
