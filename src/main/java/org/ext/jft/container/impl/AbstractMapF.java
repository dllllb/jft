package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.arrayList;

import org.ext.jft.container.ListF;
import org.ext.jft.container.MapF;
import org.ext.jft.container.Option;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;

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

	public V getOrElse(K key, Mapper<K, V> factory) {
		return getOpt(key).getOrElse(factory.map(key));
	}

	public V getOrElseUpdate(K key, V elseVal) {
		V res = get(key);
		if (res != null)
			return res;

		put(key, elseVal);
		return elseVal;
	}

	public V getOrElseUpdate(K key, Mapper<K, V> factory) {
		V res = get(key);
		if (res != null)
			return res;

		res = factory.map(key);
		put(key, res);
		return res;
	}

	public <Ex extends Throwable> V getOrThrow(K key, Ex ex) throws Ex {
		return getOpt(key).getOrThrow(ex);
	}

	public V getOrThrow(K key, String message) {
		return getOpt(key).getOrThrow(message);
	}

	public <To> ListF<To> map(Combiner<K, V, To> combiner) {
		ListF<To> res = arrayList();

		for (Entry<K, V> entry : entrySet())
			res.add(combiner.combine(entry.getKey(), entry.getValue()));

		return res;
	}
}
