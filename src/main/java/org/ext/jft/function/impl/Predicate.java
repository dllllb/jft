package org.ext.jft.function.impl;

import java.util.Collection;

/**
 * @author Dmitri Babaev
 */
public abstract class Predicate<T> implements org.ext.jft.function.Predicate<T> {
	public Predicate<T> notP() {
		return new Predicate<T>() {
			public boolean test(T a) {
				return !Predicate.this.test(a);
			}

			public Predicate<T> notP() {
				return Predicate.this;
			}

			public String toString() {
				return String.format("not(%s)", Predicate.this);
			}
		};
	}

	public Predicate<T> orP(final Predicate<T> pred) {
		return new Predicate<T>() {
			public boolean test(T a) {
				return Predicate.this.test(a) || pred.test(a);
			}

			public String toString() {
				return String.format("or(%s, %s)", Predicate.this, pred);
			}
		};
	}

	public Predicate<T> andP(final Predicate<T> pred) {
		return new Predicate<T>() {
			public boolean test(T a) {
				return Predicate.this.test(a) && pred.test(a);
			}

			public String toString() {
				return String.format("and(%s, %s)", Predicate.this, pred);
			}
		};
	}

	public Predicate<T> nullIsFalseP() {
		return Predicate.<T> notNullP().andP(this);
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
