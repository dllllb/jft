package org.ext.jft.container;

import java.util.Collection;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Factory;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Operation;
import org.ext.jft.function.Predicate;

/**
 * Extended {@link Collection} interface that provides extended features to the standard collections
 *
 * @author Dmitri Babaev
 */
public interface CollectionF<E> extends Collection<E>, Transformable<E> {

    /**
     * Produces a set of unique objects from the collection's elements using standard {@code equals} operation
     * to find duplicate elements
     *
     * @return a set of unique elements of the collection
     */
    SetF<E> unique();

    /**
     * Generates a dictionary producing key/value pairs for the elements of the collection
     *
     * @param separator - functor that produces a key/value pair for the collection's element
     * @return a map of key/value pairs
     */
    <MapKey, MapValue> MapF<MapKey, MapValue> toMap(Mapper<? super E, Pair<MapKey, MapValue>> separator);

    /**
     * Produces a dictionary from the collection generating a key for each element of the collection
     *
     * @param mapper - functor that produces a key for the element
     * @return a map of elements mapped by generated keys
     */
    <Key> MapF<Key, E> toMapMappingToKey(Mapper<? super E, Key> mapper);

    /**
     * Perform operation for each element of the container
     *
     * @param operation - operation to perform
     */
    void forEach(Operation<? super E> operation);
}
