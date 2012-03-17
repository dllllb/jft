package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.hashMap;

import org.ext.jft.container.*;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;

import java.util.HashMap;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractMapF<K, V> implements MapF<K, V> {

    public Option<V> getOpt(K key) {
        V res = get(key);
        return res != null ? Option.some(res) : Option.<V>none();
    }

    public V getOrElse(K key, V elseVal) {
        return getOpt(key).getOrElse(elseVal);
    }

    public V getOrElse(K key, Mapper<? super K, V> factory) {
        return getOpt(key).getOrElse(factory.apply(key));
    }

    public V getOrElseUpdate(K key, V elseVal) {
        V res = get(key);
        if (res != null)
            return res;

        put(key, elseVal);
        return elseVal;
    }

    public V getOrElseUpdate(K key, Mapper<? super K, V> factory) {
        V res = get(key);
        if (res != null)
            return res;

        res = factory.apply(key);
        put(key, res);
        return res;
    }

    public <Ex extends Throwable> V getOrThrow(K key, Ex ex) throws Ex {
        return getOpt(key).getOrThrow(ex);
    }

    public V getOrThrow(K key, String message) {
        return getOpt(key).getOrThrow(message);
    }

    public <To> ListF<To> map(Combiner<? super K, ? super V, To> combiner) {
        ListF<To> res = arrayList();

        for (Entry<K, V> entry : entrySet())
            res.add(combiner.apply(entry.getKey(), entry.getValue()));

        return res;
    }
    
    protected <K, V> MapF<K, V> newInstance() {
        return hashMap();
    }

    @Override
    public <To> MapF<K, To> project(Mapper<V, To> mapper) {
        MapF<K, To> res = newInstance();
        
        for (Entry<K, V> entry : entrySet())
            res.put(entry.getKey(), mapper.apply(entry.getValue()));

        return res;
    }

    @Override
    public <To> MapF<To, CollectionF<V>> groupBy(Mapper<V, To> mapper) {
        MapF<To, CollectionF<V>> res = newInstance();
                
        for (Entry<K, V> entry : entrySet()) {
            To key = mapper.apply(entry.getValue());
            res.getOrElseUpdate(key, Containers.<V>arrayList()).add(entry.getValue());
        }

        return res;
    }
}
