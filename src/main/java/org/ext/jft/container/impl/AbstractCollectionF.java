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
public abstract class AbstractCollectionF<E> implements CollectionF<E> {
	
	public <To> Transformable<To> map(Mapper<? super E, To> mapper) {
		return new MappedTransformable<E, To>(this, mapper);
	}
	
	public Transformable<E> filter(Predicate<? super E> predicate) {
		return new FilteredTransformable<E>(this, predicate);
	}

    public <T> Transformable<Pair<E, T>> zipWith(Iterable<T> second) {
        return new ZippingTransformable<E, T>(this, second);
    }

    public E reduce(Combiner<E, E, E> combiner, E initial) {
		E res = initial;
		for (E val : this) {
			res = combiner.apply(res, val);
		}
		return res;
	}
	
	public <R> R aggregate(Combiner<R, ? super E, R> aggregator, R initial) {
		R res = initial;
		for (E val : this) {
			res = aggregator.apply(res, val);
		}
		return res;
	}
	
	@Override
	public <R> R aggregate(Combiner<R, ? super E, R> elementAggregator,
		Combiner<R, R, R> intermediateResultAggregator, Factory<R> initial)
	{
		R res = initial.produce();
		for (E val : this) {
			res = elementAggregator.apply(res, val);
		}
		return res;
	}
	
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

    @Override
    public ListF<E> toArrayList() {
        return arrayList(this);
    }

    @Override
    public ListF<E> toLinkedList() {
        return linkedList(this);
    }

    @Override
    public SetF<E> toHashSet() {
        return hashSet(this);
    }
}
