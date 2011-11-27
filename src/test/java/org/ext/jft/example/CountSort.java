package org.ext.jft.example;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.flatten;
import static org.ext.jft.container.Containers.transformable;

import org.ext.jft.container.Containers;
import org.ext.jft.generator.Enumerator;
import org.ext.jft.container.ListF;
import org.ext.jft.container.MapF;
import org.ext.jft.container.Option;
import org.ext.jft.function.Combiner;

public class CountSort {
    static public <E> ListF<E> countSort(ListF<E> old) {
        final MapF<E, Integer> map = old.reduce(new Combiner<MapF<E, Integer>, E, MapF<E, Integer>>() {
                    public MapF<E, Integer> apply(MapF<E, Integer> count, E el) {
                        count.put(el, count.getOrElse(el, 0) + 1);
                        return count;
                    }
                }, Containers.<E, Integer>treeMap());

        ListF<E> res = arrayList(flatten(map.map(new Combiner<E, Integer, Iterable<E>>() {
            public Iterable<E> apply(final E val, final Integer sum) {
                return transformable(new Enumerator<E>() {
                    int count = sum;

                    public Option<E> getNext() {
                        if (count > 0) {
                            count--;
                            return Option.some(val);
                        } else
                            return Option.none();
                    }
                });
            }
        })));

        return res;
    }
}
