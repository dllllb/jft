package org.ext.jft.container;

/**
 * @author Dmitri Babaev
 */
public class MapBuilder<K, V> {
    private MapF<K, V> res;

    private MapBuilder() {}

    public MapBuilder<K, V> and(K key, V value) {
        res.put(key, value);
        return this;
    }
    
    public MapF<K, V> get() {
        return res;
    }

    public static <K,V> MapBuilder<K, V> hashMap(K key, V value) {
        MapBuilder<K,V> builder = new MapBuilder<K, V>();
        builder.res = Containers.hashMap();
        builder.and(key, value);
        return builder;
    }

    public static <K,V> MapBuilder<K, V> treeMap(K key, V value) {
        MapBuilder<K,V> builder = new MapBuilder<K, V>();
        builder.res = Containers.treeMap();
        builder.and(key, value);
        return builder;
    }
}
