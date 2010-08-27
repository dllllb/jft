package org.ext.jft.function;

/**
 * @author Dmitri Babaev
 */
public abstract class Predicate<T> implements Converter<T, Boolean> {
	
	abstract public boolean test(T val);
	
	public Boolean convert(T from) {
		return test(from);
	}
	
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
	
	public Predicate<T> any(final Predicate<T>... preds) {
		return new Predicate<T>() {
			public boolean test(T val) {
				for (Predicate<T> pred : preds) {
					if (pred.test(val))
						return true;
				}
				
				return false;
			}
		};
	}
	
	public Predicate<T> all(final Predicate<T>... preds) {
		return new Predicate<T>() {
			public boolean test(T val) {
				for (Predicate<T> pred : preds) {
					if (!pred.test(val)) {
						return false;
					}
				}
				
				return true;
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
