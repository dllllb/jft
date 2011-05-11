package org.ext.jft.function;

import java.util.Comparator;

/**
 * Transforms From object into To object
 * @author Dmitri Babaev
 */
public abstract class Mapper<From, To> {
	
	abstract public To apply(From from);
	
	public <ToTo> Mapper<From, ToTo> andThen(
			final Mapper<? super To, ? extends ToTo> mapper) {
		return new Mapper<From, ToTo>() {
			public ToTo apply(From from) {
				return mapper.apply(Mapper.this.apply(from));
			}

			public String toString() {
				return String.format("%s(%s)", mapper, Mapper.this);
			}
		};
	}

	public Predicate<From> andThen(final Predicate<? super To> predicate) {
		return new Predicate<From>() {
			public boolean apply(From a) {
				return predicate.apply(Mapper.this.apply(a));
			}

			public String toString() {
				return String.format("%s(%s)", predicate, Mapper.this);
			}
		};
	}

	public Comparator<From> andThen(final Comparator<To> comparator) {
		return new Comparator<From>() {
			public int compare(From a, From b) {
				return comparator.compare(Mapper.this.apply(a), Mapper.this.apply(b));
			}

			public String toString() {
				return String.format("%s(%s)", comparator, Mapper.this);
			}
		};
	}
}
