package org.ext.jft.container;

/**
 * This class is a factory class.
 * It creates generator classes similar to the Python range generator.
 *
 * @author Dmitri Babaev
 */
public class Range {
    static Iterable<Integer> range(int to) {
        return range(0, to, 1);
    }

    static Iterable<Integer> range(int from, int to) {
        return range(from, to, 1);
    }

    static Iterable<Integer> range(final int from, final int to, final int step) {
        return Containers.iterable(new Enumerator<Integer>() {
            int pos = from;

            public Option<Integer> getNext() {
                if (pos < to) {
                    int ret = pos;
                    pos += step;
                    return Option.some(ret);
                } else return Option.none();
            }
        });
    }
}
