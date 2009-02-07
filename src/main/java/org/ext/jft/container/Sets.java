package org.ext.jft.container;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitri Babaev
 */
public class Sets {
	public static <T> Set<T> hashSet() {
		return new HashSet<T>();
	}

	public static <T> Set<T> hashSet(T... values) {
		return hashSet(Arrays.asList(values));
	}

	public static <T> Set<T> hashSet(Collection<T> values) {
		return new HashSet<T>(values);
	}

	public static <T> Set<T> difference(Set<T> left, Set<T> right) {
		Set<T> res = union(left, right);
		res.removeAll(intersection(left, right));
		return res;
	}

	public static <T> Set<T> union(Set<T> left, Set<T> right) {
		Set<T> res = hashSet(left);
		res.addAll(right);
		return res;
	}

	public static <T> Set<T> intersection(Set<T> left, Set<T> right) {
		Set<T> res = hashSet(left);
		res.retainAll(right);
		return res;
	}

	private Sets() {
		assert false;
	}
}
