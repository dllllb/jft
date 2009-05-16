package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.decorate;

import java.util.Map;

import org.ext.jft.container.CollectionF;
import org.ext.jft.container.SetF;

/**
 * @author Dmitri Babaev
 */
public class DecoratedMapF<K, V> extends AbstractMapF<K, V> {
	private Map<K, V> inner;
	
	public DecoratedMapF(Map<K, V> map) {
		this.inner = map;
	}

	public void clear() {
		inner.clear();
	}

	public boolean containsKey(Object key) {
		return inner.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return inner.containsValue(value);
	}

	public SetF<Entry<K, V>> entrySet() {
		return decorate(inner.entrySet());
	}

	@Override
	public boolean equals(Object o) {
		return inner.equals(o);
	}

	public V get(Object key) {
		return inner.get(key);
	}

	@Override
	public int hashCode() {
		return inner.hashCode();
	}

	public boolean isEmpty() {
		return inner.isEmpty();
	}

	public SetF<K> keySet() {
		return decorate(inner.keySet());
	}

	public V put(K key, V value) {
		return inner.put(key, value);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		inner.putAll(m);
	}

	public V remove(Object key) {
		return inner.remove(key);
	}

	public int size() {
		return inner.size();
	}

	public CollectionF<V> values() {
		return decorate(inner.values());
	}
	
	@Override
	public String toString() {
		return inner.toString();
	}
}
