package org.ext.jft.container;

/**
 * Builder to build lists of lists without unchecked cast warnings
 * @author Dmitri Babaev
 */
public class ListBuilder<E> {
    private ListF<E> res;

    private ListBuilder() {}

    public ListBuilder<E> and(E element) {
        res.add(element);
        return this;
    }

    public ListF<E> get() {
        return res;
    }

    public static <E> ListBuilder<E> arrayList(E element) {
        ListBuilder<E> builder = new ListBuilder<E>();
        builder.res = Containers.arrayList();
        builder.and(element);
        return builder;
    }

    public static <E> ListBuilder<E> linkedList(E element) {
        ListBuilder<E> builder = new ListBuilder<E>();
        builder.res = Containers.linkedList();
        builder.and(element);
        return builder;
    }
}
