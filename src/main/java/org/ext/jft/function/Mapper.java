package org.ext.jft.function;

import java.util.Comparator;

/**
 * Transforms From object into To object
 * @author Dmitri Babaev
 */
public abstract class Mapper<From, To> implements Converter<From, To> {
	
	abstract public To map(From from);
	
	public To convert(From from) {
		return map(from);
	}
	
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
