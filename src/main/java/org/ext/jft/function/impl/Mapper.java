package org.ext.jft.function.impl;

import java.util.Comparator;

/**
 * @author Dmitri Babaev
 */
public abstract class Mapper<From, To> implements
		org.ext.jft.function.Mapper<From, To> {
	public <ToTo> Mapper<From, ToTo> andThen(
			final Mapper<? super To, ? extends ToTo> mapper) {
		return new Mapper<From, ToTo>() {
			public ToTo map(From from) {
				return mapper.map(Mapper.this.map(from));
			}

			public String toString() {
				return String.format("%s(%s)", mapper, Mapper.this);
			}
		};
	}

	public Predicate<From> andThen(final Predicate<? super To> predicate) {
		return new Predicate<From>() {
			public boolean test(From a) {
				return predicate.test(map(a));
			}

			public String toString() {
				return String.format("%s(%s)", predicate, Mapper.this);
			}
		};
	}

	public Comparator<From> andThen(final Comparator<To> comparator) {
		return new Comparator<From>() {
			public int compare(From a, From b) {
				return comparator.compare(map(a), map(b));
			}

			public String toString() {
				return String.format("%s(%s)", comparator, Mapper.this);
			}
		};
	}
}
