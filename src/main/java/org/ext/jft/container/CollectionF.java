package org.ext.jft.container;

import java.util.Collection;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Predicate;
import org.ext.jft.function.Separator;

/**
 * @author Dmitri Babaev
 */
public interface CollectionF<E> extends Collection<E> {
	
	<To> CollectionF<To> map(Mapper<E, To> mapper);

	CollectionF<E> filter(Predicate<E> predicate);

	E reduce(Combiner<E, E, E> combiner, E initial);
	
	SetF<E> unique();
	
	<MapKey, MapValue> MapF<MapKey, MapValue> toMap(Separator<E, MapKey, MapValue> separator);

	<Key> MapF<Key, E> toMapMappingToKey(Mapper<E, Key> mapper);
	
	IteratorF<E> iterator();
}
