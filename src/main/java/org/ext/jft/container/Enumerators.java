package org.ext.jft.container;

import org.ext.jft.function.Predicate;

public class Enumerators {
    public static <T> Enumerator<T> until(final Enumerator<T> enumerator, final Predicate<T> untilTruePred) {
        return new Enumerator<T>() {
            @Override
            public Option<T> getNext() {
                Option<T> next = enumerator.getNext();
                for (T res : next) {
                    if (untilTruePred.apply(res)) {
                        return Option.none();
                    }
                }
                return next;
            }
        };
    }

    public static <T> Enumerator<T> limit(final Enumerator<T> enumerator, final int max) {
        return new Enumerator<T>() {
            int count = 0;
            @Override
            public Option<T> getNext() {
                return count >= max ? Option.<T>none() : enumerator.getNext();
            }
        };
    }
}
