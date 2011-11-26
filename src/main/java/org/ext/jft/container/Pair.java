package org.ext.jft.container;

import java.io.Serializable;

import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public class Pair<T1, T2> implements Serializable {
    private static final long serialVersionUID = 9145638285274338125L;

    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Pair<?, ?> other = (Pair<?, ?>) obj;

        if (first != null ? !first.equals(other.first) : other.first != null)
            return false;
        if (second != null ? !second.equals(other.second)
                : other.second != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (first != null ? first.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", first, second);
    }

    public T1 first() {
        return first;
    }

    public T2 second() {
        return second;
    }

    public Pair<T2, T1> swap() {
        return pair(second, first);
    }

    public static <A, B> Pair<A, B> pair(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    public static <A, B> Mapper<Pair<A, B>, A> getFirstM() {
        return new Mapper<Pair<A, B>, A>() {
            public A apply(Pair<A, B> pair) {
                return pair.first();
            }
        };
    }

    public static <A, B> Mapper<Pair<A, B>, B> getSecondM() {
        return new Mapper<Pair<A, B>, B>() {
            public B apply(Pair<A, B> pair) {
                return pair.second();
            }
        };
    }

    public static <A, B> Mapper<Pair<A, B>, Pair<B, A>> swapM() {
        return new Mapper<Pair<A, B>, Pair<B, A>>() {
            public Pair<B, A> apply(Pair<A, B> pair) {
                return pair.swap();
            }
        };
    }
}
