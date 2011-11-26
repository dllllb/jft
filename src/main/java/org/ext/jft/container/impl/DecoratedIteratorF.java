package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.container.IteratorF;
import org.ext.jft.container.Option;

/**
 * @author Dmitri Babaev
 */
public class DecoratedIteratorF<E> implements IteratorF<E> {
    private Iterator<E> inner;

    public DecoratedIteratorF(Iterator<E> it) {
        inner = it;
    }

    @Override
    public boolean hasNext() {
        return inner.hasNext();
    }

    @Override
    public E next() {
        return inner.next();
    }

    @Override
    public void remove() {
        inner.remove();
    }

    @Override
    public Option<E> getOpt() {
        return inner.hasNext() ? Option.some(inner.next()) : Option.<E>none();
    }

}
