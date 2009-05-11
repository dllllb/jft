package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Containers.hashSet;

import org.ext.jft.container.CollectionF;
import org.ext.jft.container.MapF;
import org.ext.jft.container.Pair;
import org.ext.jft.container.SetF;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;
import org.ext.jft.function.Separator;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractCollectionF<E> implements CollectionF<E> {
	
	public <To> CollectionF<To> map(Mapper<E, To> mapper) {
		CollectionF<To> res = arrayList();

		for (E from : this) {
			res.add(mapper.map(from));
		}
		return res;
	}
	
	public CollectionF<E> filter(Predicate<E> predicate) {
		CollectionF<E> res = arrayList();

		for (E val : this) {
			if (predicate.test(val))
				res.add(val);
		}
		return res;
	}
	
	public E reduce(Combiner<E, E, E> combiner, E initial) {
		E res = initial;
		for (E val : this) {
			res = combiner.combine(res, val);
		}
		return res;
	}
	
	public <MapKey, MapValue> MapF<MapKey, MapValue> toMap(
			Separator<E, MapKey, MapValue> separator) {
		MapF<MapKey, MapValue> map = hashMap();

		for (E val : this) {
			Pair<MapKey, MapValue> pair = separator.separate(val);
			map.put(pair.first(), pair.second());
		}

		return map;
	}

	public <Key> MapF<Key, E> toMapMappingToKey(final Mapper<E, Key> mapper) {
		Separator<E, Key, E> separator = new Separator<E, Key, E>() {
			public Pair<Key, E> separate(E from) {
				return Pair.create(mapper.map(from), from);
			}
		};

		return toMap(separator);
	}
	
	public SetF<E> unique() {
		return hashSet(this);
	}
}
