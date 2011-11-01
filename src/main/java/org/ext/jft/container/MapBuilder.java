package org.ext.jft.container;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitri Babaev
 */
public class MapBuilder<K,V> {
    private MapF<K,V> entries = Containers.hashMap();

    public static <K,V> MapBuilder<K,V> entry(K key, V value) {
        return new MapBuilder<K, V>().and(key, value);
    }

    MapBuilder<K,V> and(K key, V value) {
        entries.put(key, value);
        return this;
    }

    MapF<K,V> asHashMap() {
        return Containers.hashMap(entries);
    }

    MapF<K,V> asTreeMap() {
        return Containers.treeMap(entries);
    }
}
