package org.ext.jft.container;

import java.util.Map;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;

/**
 * @author Dmitri Babaev
 */
public interface MapF<K, V> extends Map<K, V> {

    Option<V> getOpt(K key);

    <Ex extends Throwable> V getOrThrow(K key, Ex ex) throws Ex;

    V getOrThrow(K key, String exStr);

    V getOrElse(K key, V elseVal);

    V getOrElse(K key, Mapper<? super K, V> factory);

    V getOrElseUpdate(K key, V elseVal);

    V getOrElseUpdate(K key, Mapper<? super K, V> factory);

    <To> ListF<To> map(Combiner<? super K, ? super V, To> combiner);
    
    <To> MapF<K, To> project(Mapper<V, To> mapper);

    <To> MapF<To, CollectionF<V>> groupBy(Mapper<V, To> mapper);

    SetF<K> keySet();

    CollectionF<V> values();

    SetF<Entry<K, V>> entrySet();
}
