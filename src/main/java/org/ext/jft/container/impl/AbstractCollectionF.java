package org.ext.jft.container.impl;

import static org.ext.jft.container.Containers.hashMap;
import static org.ext.jft.container.Containers.hashSet;
import static org.ext.jft.container.Containers.arrayList;
import static org.ext.jft.container.Containers.linkedList;

import org.ext.jft.container.*;
import org.ext.jft.function.Combiner;
import org.ext.jft.function.Factory;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Operation;
import org.ext.jft.function.Predicate;
import org.ext.jft.function.Separator;

/**
 * @author Dmitri Babaev
 */
public abstract class AbstractCollectionF<E> extends AbstractTransformable<E> implements CollectionF<E> {

	public <MapKey, MapValue> MapF<MapKey, MapValue> toMap(
			Mapper<? super E, Pair<MapKey, MapValue>> separator) {
		MapF<MapKey, MapValue> map = hashMap();

		for (E val : this) {
			Pair<MapKey, MapValue> pair = separator.apply(val);
			map.put(pair.first(), pair.second());
		}

		return map;
	}

	public <Key> MapF<Key, E> toMapMappingToKey(final Mapper<? super E, Key> mapper) {
		Separator<E, Key, E> separator = new Separator<E, Key, E>() {
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
}
