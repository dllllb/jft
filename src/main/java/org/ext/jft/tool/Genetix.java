package org.ext.jft.tool;

import org.ext.jft.generator.Enumerator;
import org.ext.jft.container.Option;

import java.util.List;
import java.util.Random;

/**
 * Genetix algorithms tools
 *
 * @author Dmitri Babev
 */
public class Genetix {
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

    public static <T> DescendantGenerator<T> generator(List<T> samples, Breeder<T> breeder, Random random) {
        return new DescendantGenerator<T>(samples, breeder, random);
    }

    static public class DescendantGenerator<T> implements Enumerator<T> {
        private List<T> samples;
        private Breeder<T> breeder;
        private Random random;

        public DescendantGenerator(List<T> samples, Breeder<T> breeder, Random random) {
            this.samples = samples;
            this.breeder = breeder;
            this.random = random;
        }

        @Override
        public Option<T> getNext() {
            T left = samples.get(random.nextInt(samples.size()));
            T right = samples.get(random.nextInt(samples.size()));
            T res = breeder.descend(left, right, random);
            return Option.some(res);
        }
    }
}
