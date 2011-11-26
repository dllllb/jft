package org.ext.jft.function;

import java.util.Collection;

/**
 * @author Dmitri Babaev
 */
public class Predicates {

    public static Predicate<Object> notNullP() {
        return new Predicate<Object>() {
            public boolean apply(Object val) {
                return val != null;
            }
        };
    }

    public static Predicate<Object> equalsP(final Object standart) {
        return new Predicate<Object>() {
            public boolean apply(Object val) {
                return val.equals(standart);
            }
        };
    }

    public static <T extends Comparable<T>> Predicate<T> moreThanP(final T standart) {
        return new Predicate<T>() {
            public boolean apply(T val) {
                return val.compareTo(standart) > 0;
            }
        };
    }

    public static <T extends Comparable<T>> Predicate<T> lessThanP(final T standart) {
        return new Predicate<T>() {
            public boolean apply(T val) {
                return val.compareTo(standart) < 0;
            }
        };
    }

    public static Predicate<Object> instanceOfP(final Class<?> cl) {
        return new Predicate<Object>() {
            public boolean apply(Object val) {
                return cl.isInstance(val);
            }

            public String toString() {
                return String.format("instanceof(%s)", cl.getName());
            }
        };
    }

    public static <T> Predicate<T> elementOfP(final Collection<T> collection) {
        return new Predicate<T>() {
            public boolean apply(T e) {
                return collection.contains(e);
            }
        };
    }

    public static <T> Predicate<Collection<T>> containsP(final T element) {
        return new Predicate<Collection<T>>() {
            public boolean apply(Collection<T> collection) {
                return collection.contains(element);
            }
        };
    }

    public static <T> Predicate<T> any(final Predicate<T>... preds) {
        return new Predicate<T>() {
            public boolean apply(T val) {
                for (Predicate<T> pred : preds) {
                    if (pred.apply(val))
                        return true;
                }

                return false;
            }
        };
    }

    public static <T> Predicate<T> all(final Predicate<T>... preds) {
        return new Predicate<T>() {
            public boolean apply(T val) {
                for (Predicate<T> pred : preds) {
                    if (!pred.apply(val)) {
                        return false;
                    }
                }

                return true;
            }
        };
    }
}
