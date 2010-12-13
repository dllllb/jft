package org.ext.jft.function;

import org.ext.jft.container.Pair;

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
	
	public static <T1, T2, R> Converter<Pair<T1, T2>, R> fuse(final Combiner<T1, T2, R> combiner) {
		return new Converter<Pair<T1,T2>, R>() {
			public R convert(Pair<T1, T2> from) {
				return combiner.combine(from.first(), from.second());
			}
		};
	}
}
