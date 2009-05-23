package org.ext.jft.function.impl;

import java.util.Collection;

/**
 * @author Dmitri Babaev
 */
public class Predicates {
	
	public static <T> Predicate<T> notNullP() {
		return new Predicate<T>() {
			public boolean test(T val) {
				return val != null;
			}
		};
	}

	public static <T> Predicate<T> equalsP(final T standart) {
		return new Predicate<T>() {
			public boolean test(T val) {
				return val.equals(standart);
			}
		};
	}
	
	public static <T extends Comparable<T>> Predicate<T> moreThanP(final T standart) {
		return new Predicate<T>() {
			public boolean test(T val) {
				return val.compareTo(standart) > 0;
			}
		};
	}
	
	public static <T extends Comparable<T>> Predicate<T> lessThanP(final T standart) {
		return new Predicate<T>() {
			public boolean test(T val) {
				return val.compareTo(standart) < 0;
			}
		};
	}

	public static <T> Predicate<T> instanceOfP(final Class<?> cl) {
		return new Predicate<T>() {
			public boolean test(T val) {
				return cl.isInstance(val);
			}

			public String toString() {
				return String.format("instanceof(%s)", cl.getName());
			}
		};
	}

	public static <T> Predicate<T> containsP(final Collection<T> collection) {
		return new Predicate<T>() {
			public boolean test(T e) {
				return collection.contains(e);
			}
		};
	}
}
