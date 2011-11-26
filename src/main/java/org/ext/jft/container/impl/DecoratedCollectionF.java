package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.decorate;

import java.util.Collection;
import java.util.Iterator;

public class DecoratedCollectionF<E> extends AbstractCollectionF<E> {
    private Collection<E> inner;

    public DecoratedCollectionF(Collection<E> collection) {
        this.inner = collection;
    }

    public boolean add(E e) {
        return inner.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        return inner.addAll(c);
    }

    public void clear() {
        inner.clear();
    }

    public boolean contains(Object o) {
        return inner.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return inner.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return inner.equals(o);
    }

    @Override
    public int hashCode() {
        return inner.hashCode();
    }

    public boolean isEmpty() {
        return inner.isEmpty();
    }

    public Iterator<E> iterator() {
        return inner.iterator();
    }

    public boolean remove(Object o) {
        return inner.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        return inner.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return inner.retainAll(c);
    }

    public int size() {
        return inner.size();
    }

    public Object[] toArray() {
        return inner.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return inner.toArray(a);
    }

    @Override
    public String toString() {
        return inner.toString();
    }
}
