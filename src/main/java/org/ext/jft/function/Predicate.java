package org.ext.jft.function;

/**
 * @author Dmitri Babaev
 */
public abstract class Predicate<T> {

    abstract public boolean apply(T val);

    public Predicate<T> not() {
        return new Predicate<T>() {
            public boolean apply(T a) {
                return !Predicate.this.apply(a);
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
            public boolean apply(T a) {
                return Predicate.this.apply(a) || pred.apply(a);
            }

            public String toString() {
                return String.format("or(%s, %s)", Predicate.this, pred);
            }
        };
    }

    public Predicate<T> and(final Predicate<T> pred) {
        return new Predicate<T>() {
            public boolean apply(T a) {
                return Predicate.this.apply(a) && pred.apply(a);
            }

            public String toString() {
                return String.format("and(%s, %s)", Predicate.this, pred);
            }
        };
    }

    public Mapper<T, Boolean> asMapper() {
        return new Mapper<T, Boolean>() {
            public Boolean apply(T a) {
                return Predicate.this.apply(a);
            }

            public String toString() {
                return String.format("%s.asMapper", Predicate.this);
            }
        };
    }
}
