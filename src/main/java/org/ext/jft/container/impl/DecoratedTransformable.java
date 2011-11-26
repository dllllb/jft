package org.ext.jft.container.impl;

import java.util.Iterator;

public class DecoratedTransformable<E> extends AbstractTransformable<E> {
    private Iterable<E> innner;

    public DecoratedTransformable(Iterable<E> innner) {
        this.innner = innner;
    }

    @Override
    public Iterator<E> iterator() {
        return innner.iterator();
    }
}
