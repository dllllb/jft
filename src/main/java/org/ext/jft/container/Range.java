package org.ext.jft.container;

/**
 * This class is a factory class.
 * It creates generator classes similar to the Python range generator.
 *
 * @author Dmitri Babaev
 */
public class Range {
    public static Iterable<Integer> range(int to) {
        return range(0, to, 1);
    }

    public static Iterable<Integer> range(int from, int to) {
        return range(from, to, 1);
    }

    public static Iterable<Integer> range(int from, int to, int step) {
        return Containers.iterable(generator(from, to, step));
    }

    public static IntegerEnumerator generator(int from, int to, int step) {
        return new IntegerEnumerator(from, to, step);
    }

    public static class IntegerEnumerator implements Enumerator<Integer> {
        private int pos;
        private final int from;
        private final int to;
        private final int step;

        public IntegerEnumerator(int from, int to, int step) {
            this.from = from;
            this.to = to;
            this.step = step;
            pos = from;
        }

        public Option<Integer> getNext() {
            if (pos < to) {
                int ret = pos;
                pos += step;
                return Option.some(ret);
            } else return Option.none();
        }
    }
}
