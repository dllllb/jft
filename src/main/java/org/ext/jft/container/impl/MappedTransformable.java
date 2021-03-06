package org.ext.jft.container.impl;

import java.util.Iterator;

import org.ext.jft.container.Transformable;
import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public class MappedTransformable<F, T> extends AbstractTransformable<T> {
    private Iterable<F> inner;
    private Mapper<? super F, T> mapper;

    public MappedTransformable(Iterable<F> inner, Mapper<? super F, T> mapper) {
        this.inner = inner;
        this.mapper = mapper;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator<F> it = inner.iterator();

            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return mapper.apply(it.next());
            }

            public void remove() {
                it.remove();
            }
        };
    }

    @Override
    public <To> Transformable<To> map(Mapper<? super T, To> mapper) {
        return new MappedTransformable<F, To>(inner, this.mapper.andThen(mapper));
    }
}
