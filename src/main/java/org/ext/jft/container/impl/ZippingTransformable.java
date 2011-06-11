package org.ext.jft.container.impl;

import org.ext.jft.container.Pair;

import java.util.Iterator;

public class ZippingTransformable<F,S> extends DecoratingTransformable<Pair<F,S>> {
    private Iterable<F> first;
    private Iterable<S> second;

    public ZippingTransformable(Iterable<F> first, Iterable<S> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Iterator<Pair<F, S>> iterator() {
        return new Iterator<Pair<F, S>>() {
            Iterator<F> itFirst = first.iterator();
            Iterator<S> itSecond = second.iterator();

            public boolean hasNext() {
                return itFirst.hasNext() && itSecond.hasNext();
            }

            public Pair<F, S> next() {
                return Pair.pair(itFirst.next(), itSecond.next());
            }

            public void remove() {
                itFirst.remove();
                itSecond.remove();
            }
        };
    }
}
