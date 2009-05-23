package org.ext.jft.function.impl;

/**
 * @author Dmitri Babaev
 */
public abstract class Predicate<T> implements org.ext.jft.function.Predicate<T> {
	public Predicate<T> not() {
		return new Predicate<T>() {
			public boolean test(T a) {
				return !Predicate.this.test(a);
			}

			public Predicate<T> not() {
				return Predicate.this;
			}

			public String toString() {
				return String.format("not(%s)", Predicate.this);
			}
		};
	}

	public Predicate<T> or(final Predicate<T> pred) {
		return new Predicate<T>() {
			public boolean test(T a) {
				return Predicate.this.test(a) || pred.test(a);
			}

			public String toString() {
				return String.format("or(%s, %s)", Predicate.this, pred);
			}
		};
	}

	public Predicate<T> and(final Predicate<T> pred) {
		return new Predicate<T>() {
			public boolean test(T a) {
				return Predicate.this.test(a) && pred.test(a);
			}

			public String toString() {
				return String.format("and(%s, %s)", Predicate.this, pred);
			}
		};
	}

	public Mapper<T, Boolean> asMapper() {
		return new Mapper<T, Boolean>() {
			public Boolean map(T a) {
				return Predicate.this.test(a);
			}

			public String toString() {
				return String.format("%s.asMapper", Predicate.this);
			}
		};
	}
}
