package org.ext.jft.function;

import org.ext.jft.container.Pair;

public class Separators {
	public static <T> Separator<T, T, T> duplicatingSeparator() {
		return new Separator<T, T, T>() {
			public Pair<T, T> apply(T from) {
				return Pair.pair(from, from);
			}
		};
	}
}
