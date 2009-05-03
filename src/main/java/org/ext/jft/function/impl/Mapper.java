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

	public Mapper<From, To> ignoreNullM() {
		return new Mapper<From, To>() {
			public To map(From a) {
				if (a == null)
					return null;
				else
					return Mapper.this.map(a);
			}

			public String toString() {
				return String.format("ignoreNull(%s)", Mapper.this);
			}
		};
	}

	public static <From> Mapper<From, String> toStringM() {
		return new Mapper<From, String>() {
			public String map(From from) {
				return from.toString();
			}
		};
	}
	
	public static <From> Mapper<From, Class<From>> toClassM() {
		return new Mapper<From, Class<From>>() {
			@SuppressWarnings("unchecked")
			public Class<From> map(From from) {
				return (Class<From>) from.getClass();
			}
		};
	}
}
