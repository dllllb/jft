package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.decorate;

import java.util.Map;

import org.ext.jft.container.CollectionF;
import org.ext.jft.container.SetF;

/**
 * @author Dmitri Babaev
 */
public class DecoratedMapF<K, V> extends AbstractMapF<K, V> {
	private Map<K, V> map;
	
	public DecoratedMapF(Map<K, V> map) {
		this.map = map;
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public SetF<Entry<K, V>> entrySet() {
		return decorate(map.entrySet());
	}

	@Override
	public boolean equals(Object o) {
		return map.equals(o);
	}

	public V get(Object key) {
		return map.get(key);
	}

	@Override
	public int hashCode() {
		return map.hashCode();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public SetF<K> keySet() {
		return decorate(map.keySet());
	}

	public V put(K key, V value) {
		return map.put(key, value);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		map.putAll(m);
	}

	public V remove(Object key) {
		return map.remove(key);
	}

	public int size() {
		return map.size();
	}

	public CollectionF<V> values() {
		return decorate(map.values());
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}
