package org.ext.jft.tool;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Genetic algorithms tools
 *
 * @author Dmitri Babev
 */
public class Genetic {
    public static interface Breeder<T> {
        public T descend(T left, T right, Random random);
    }

    public abstract static class AbstractBreeder<T> implements Breeder<T> {
        protected Random random;

        public T descend(T left, T right, Random random) {
            this.random = random;
            return descend(left, right);
        }

        protected <ST> ST any(ST left, ST right) {
            return random.nextBoolean() ? left : right;
        }

        protected abstract T descend(T left, T right);
    }

    static public <E> Iterable<E> breed(final List<E> generation, final Breeder<E> breeder, final Random random) {
        return new Iterable<E>() {
            public Iterator<E> iterator() {
                    return new Iterator<E>() {
                            Iterator<E> it = generation.iterator();

                            public boolean hasNext() {
                                    return it.hasNext();
                            }

                            public E next() {
                                E left = it.next();
                                E right = generation.get(random.nextInt(generation.size()));
                                E res;
                                res = breeder.descend(left, right, random);
                                return res;
                            }

                            public void remove() {
                                    throw new UnsupportedOperationException();
                            }
                    };
            }
        };
    }
}
