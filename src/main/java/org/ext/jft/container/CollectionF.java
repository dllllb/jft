package org.ext.jft.container;

import java.util.Collection;

import org.ext.jft.function.Combiner;
import org.ext.jft.function.Factory;
import org.ext.jft.function.Mapper;
import org.ext.jft.function.Operation;
import org.ext.jft.function.Predicate;

/**
 * Extended {@link Collection} interface that provides extended features to the standard collections
 * @author Dmitri Babaev
 */
public interface CollectionF<E> extends Collection<E> {
	
	/**
	 * Operation that transforms each element of the collection to another object  
	 * @param mapper - functor to perform the transformation
	 * @return the {@link Iterable} structure of mapped elements
	 */
	<To> Transformable<To> map(Mapper<E, To> mapper);

	/**
	 * Operation that produces a subset of the collection with elements that matches predicate
	 * @param predicate - functor to test if element matches predicate
	 * @return the {@link Iterable} structure that represents a subset of collection's elements 
	 */
	Transformable<E> filter(Predicate<E> predicate);

	/**
	 * Operation that produces single object from the collection's element
	 * @param combiner - functor that produces a new resulting value
	 * from the previous resulting value and an element of the collection
	 * @param initial - initial resulting value before the reduce operation
	 * @return result of the reduce
	 */
	E reduce(Combiner<E, E, E> combiner, E initial);
	
	<R> R aggregate(Combiner<R, E, R> aggregator, R initial);
	
	<R> R aggregate(Combiner<R, E, R> elementAggregator,
		Combiner<R, R, R> intermediateResultAggregator, Factory<R> initial);
	
	/**
	 * Produces a set of unique objects from the collection's elements using standard {@code equals} operation
	 * to find duplicate elements
	 * @return a set of unique elements of the collection
	 */
	SetF<E> unique();
	
	/**
	 * Generates a dictionary producing key/value pairs for the elements of the collection
	 * @param separator - functor that produces a key/value pair for the collection's element
	 * @return a map of key/value pairs
	 */
	<MapKey, MapValue> MapF<MapKey, MapValue> toMap(Mapper<E, Pair<MapKey, MapValue>> separator);

	/**
	 * Produces a dictionary from the collection generating a key for each element of the collection
	 * @param mapper - functor that produces a key for the element
	 * @return a map of elements mapped by generated keys
	 */
	<Key> MapF<Key, E> toMapMappingToKey(Mapper<E, Key> mapper);
	
	/**
	 * Perform operation for each element of the container
	 * @param operation - operation to perform
	 */
	void forEach(Operation<E> operation);
	
	IteratorF<E> iterator();
}
