package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Containers.hashSet;

import org.ext.jft.container.*;

import org.ext.jft.function.Mapper;
import org.ext.jft.function.Operation;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractCollectionF<E> extends AbstractTransformable<E> implements CollectionF<E> {

    public <Key, Value> MapF<Key, Value> toMap(
            Mapper<? super E, Pair<Key, Value>> separator) {
        MapF<Key, Value> map = hashMap();

        for (E val : this) {
            Pair<Key, Value> pair = separator.apply(val);
            map.put(pair.first(), pair.second());
        }

        return map;
    }

    public <Key> MapF<Key, E> toMapMappingToKey(final Mapper<? super E, Key> mapper) {
        Mapper<E, Pair<Key, E>> separator = new Mapper<E, Pair<Key, E>>() {
            public Pair<Key, E> apply(E from) {
                return Pair.pair(mapper.apply(from), from);
            }
        };

        return toMap(separator);
    }

    public SetF<E> unique() {
        return hashSet(this);
    }

    public void forEach(Operation<? super E> operation) {
        for (E element : this) {
            operation.perform(element);
        }
    }

    @Override
    public <Key> MapF<Key, CollectionF<E>> groupBy(Mapper<? super E, Key> keyMapper) {
        MapF<Key, CollectionF<E>> res = hashMap();

        for (E element : this) {
            Key key = keyMapper.apply(element);
            res.getOrElseUpdate(key, Containers.<E>arrayList()).add(element);
        }

        return res;
    }
}
